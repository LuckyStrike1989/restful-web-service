package kr.co.leegeunwon.myrestfulservice.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import jakarta.validation.Valid;
import kr.co.leegeunwon.myrestfulservice.bean.AdminUser;
import kr.co.leegeunwon.myrestfulservice.bean.AdminUserV2;
import kr.co.leegeunwon.myrestfulservice.bean.User;
import kr.co.leegeunwon.myrestfulservice.dao.IUserDaoService;
import kr.co.leegeunwon.myrestfulservice.exception.UserNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminUserController {
    @Autowired
    private IUserDaoService userDaoService;

    /**
     * 사용자 목록 조회(관리자용)
     * /admin/v1/users/{id}
     * @param id
     * @return MappingJacksonValue
     */
    // @GetMapping("/v1/users/{id}")
    // @GetMapping(value = "/users/{id}", params = "version=1")
    // @GetMapping(value = "/users/{id}", headers = "X-API-VERSION=1")
    @GetMapping(value = "/users/{id}", produces = "application/vnd.company.appv1+json")
    public MappingJacksonValue retrieveUser4Amdin(@PathVariable int id) {
        User user = userDaoService.findOne(id);

        AdminUser adminUser = new AdminUser();
        if( user == null ) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        } else {
            // user -> adminUser 데이터복사(객체복사)
            BeanUtils.copyProperties(user, adminUser);
        }

        // 필터 생성
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn", "grade");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        // 필터 적용
        MappingJacksonValue mapping = new MappingJacksonValue(adminUser);
        mapping.setFilters(filters);

        return mapping;
    }

    /**
     * 사용자 목록 조회(관리자용) V2
     * /admin/v2/users/{id}
     * @param id
     * @return
     */
    // @GetMapping("/v2/users/{id}")
    // @GetMapping(value = "/users/{id}", params = "version=2")
    // @GetMapping(value = "/users/{id}", headers = "X-API-VERSION=2")
    @GetMapping(value = "/users/{id}", produces = "application/vnd.company.appv2+json")
    public MappingJacksonValue retrieveUser4AmdinV2(@PathVariable int id) {
        User user = userDaoService.findOne(id);

        AdminUserV2 adminUser = new AdminUserV2();
        if( user == null ) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        } else {
            // user -> adminUser 데이터복사(객체복사)
            BeanUtils.copyProperties(user, adminUser);
            adminUser.setGrade("VIP");  // grade 필드 추가
        }

        // 필터 생성
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate",  "grade");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfoV2", filter);

        // 필터 적용
        MappingJacksonValue mapping = new MappingJacksonValue(adminUser);
        mapping.setFilters(filters);

        return mapping;
    }


    /**
     * 사용자 전체 목록 조회(관리자용)
     * /admin/users
     * @return MappingJacksonValue
     */
    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUsers4Amdin() {
        List<User> users = userDaoService.findAll();

        List<AdminUser> adminUsers = new ArrayList<>();
        AdminUser adminUser = null;
        for(User user : users) {
            adminUser = new AdminUser();
            // user -> adminUser 데이터복사(객체복사)
            BeanUtils.copyProperties(user, adminUser);
            adminUsers.add(adminUser);
        }

        // 필터 생성
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn", "grade");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        // 필터 적용
        MappingJacksonValue mapping = new MappingJacksonValue(adminUsers);
        mapping.setFilters(filters);

        return mapping;
    }
}
