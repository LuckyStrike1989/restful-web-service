package kr.co.leegeunwon.myrestfulservice.controller;

import kr.co.leegeunwon.myrestfulservice.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // GET
    // URI - /hello-world
    // @RequestMapping(method=RequestMethod.GET, path="/hello-world")

    /**
     * localhost:8088/hello-world
     * @return
     */
    @GetMapping(path = "/hello-world")
    public String helloworld() {
        return "Hello World";
    }

    /**
     * localhost:8088/hello-world-bean
     * @return
     */
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloworldBean() {
        return new HelloWorldBean("Hello World!");
    }

    /**
     *  localhost:8088/hello-world-bean/path-variable/{name}
     * @param name
     * @return
     */
    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloworldBeanPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
