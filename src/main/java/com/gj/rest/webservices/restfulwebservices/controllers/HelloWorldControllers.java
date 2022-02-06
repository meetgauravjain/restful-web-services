package com.gj.rest.webservices.restfulwebservices.controllers;

import com.gj.rest.webservices.restfulwebservices.Beans.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldControllers {

  @Autowired private MessageSource messageSource;

  @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
  public String helloWorld() {
    return "Hello World";
  }

  @GetMapping(path = "/hello-world2")
  public String helloWorld2() {
    return "Hello World, How are you";
  }

  @GetMapping(path = "/hello-world3")
  public HelloWorldBean helloWorld3() {
    return new HelloWorldBean("Hello World, This is bean, How are you");
  }

  @GetMapping(path = "/hello-world4/path-variable/{name}")
  public HelloWorldBean helloWorld4(@PathVariable String name) {
    return new HelloWorldBean(String.format("Hellow --, %s", name));
  }

  @GetMapping(path = "/hello-world-internationalization")
  public String helloWorld5(
      //@RequestHeader(name = "Accept-Language", required = false) Locale locale)
  )
  {
    return messageSource.getMessage("good.morning.message", null,
            "Default message",
    //        locale
            LocaleContextHolder.getLocale());
  }
}
