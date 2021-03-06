package com.gj.rest.webservices.restfulwebservices.controllers;

import com.gj.rest.webservices.restfulwebservices.Beans.User;
import com.gj.rest.webservices.restfulwebservices.Dao.UserDaoService;
import com.gj.rest.webservices.restfulwebservices.Exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

  @Autowired private UserDaoService userDaoService;

  @GetMapping(path = "/users")
  public List<User> getAllUsers() {
    return userDaoService.findAll();
  }

  //  @GetMapping(path = "/users/{id}")
  //  public User retrieveUser(@PathVariable int id) {
  //    User user;
  //    user = userDaoService.findOne(id);
  //    if (null == user) {
  //      throw new UserNotFoundException("id - " + id);
  //    }
  //    return user;
  //  }

  @GetMapping(path = "/users/{id}")
  public EntityModel<User> retrieveUser(@PathVariable int id) {
    User user;
    user = userDaoService.findOne(id);
    if (null == user) {
      throw new UserNotFoundException("id - " + id);
    }
    EntityModel<User> model = EntityModel.of(user);
    WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).getAllUsers());
    model.add(linkBuilder.withRel("all-users"));
    return model;
  }

  @DeleteMapping(path = "/users/{id}")
  public void deleteUser(@PathVariable int id) {
    User user;
    user = userDaoService.deleteById(id);
    if (null == user) {
      throw new UserNotFoundException("id - " + id);
    }
  }

  @PostMapping(path = "/users")
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
    User savedUser = userDaoService.save(user);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId())
            .toUri();
    return ResponseEntity.created(location).build();
  }
}
