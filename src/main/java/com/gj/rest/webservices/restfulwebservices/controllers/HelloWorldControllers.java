package com.gj.rest.webservices.restfulwebservices.controllers;

import com.gj.rest.webservices.restfulwebservices.Beans.HelloWorldBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldControllers {

    @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
    public String helloWorld() {
        return "Hellow World";
    }

    @GetMapping(path = "/hello-world2")
    public String helloWorld2() {
        return "Hellow World, How are you";
    }

    @GetMapping(path = "/hello-world3")
    public HelloWorldBean helloWorld3() {
        return new HelloWorldBean("Hellow World, This is bean, How are you");
    }

    @GetMapping(path = "/hello-world4/path-variable/{name}")
    public HelloWorldBean helloWorld4(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hellow --, %s", name));
    }
}
