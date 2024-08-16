package kr.co.leegeunwon.myrestfulservice.User.Controller;

import jakarta.validation.Valid;
import kr.co.leegeunwon.myrestfulservice.User.bean.User;
import kr.co.leegeunwon.myrestfulservice.User.service.IUserDaoService;
import kr.co.leegeunwon.myrestfulservice.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {
    @Autowired
    private IUserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User user = userDaoService.findOne(id);

        // 사용자가 없을 경우, 예외를 발생시킨다.
        if( user == null ) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        EntityModel entityModel = EntityModel.of(user);

        // 링크를 만든다
        WebMvcLinkBuilder linTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(linTo.withRel("all-users"));    // http://localhost:8080/users -> all-users

        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        // 반환 값을 201 Created 준다. 인자로 location을 넘겨주면, 헤더에 Location이 추가된다.
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        User user = userDaoService.deleteById(id);

        if( user == null ) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        return ResponseEntity.noContent().build();
    }
}
