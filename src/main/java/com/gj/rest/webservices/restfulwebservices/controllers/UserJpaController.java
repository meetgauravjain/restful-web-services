package com.gj.rest.webservices.restfulwebservices.controllers;

import com.gj.rest.webservices.restfulwebservices.Beans.User;
import com.gj.rest.webservices.restfulwebservices.Exceptions.UserNotFoundException;
import com.gj.rest.webservices.restfulwebservices.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaController {

  @Autowired private UserRepository userRepository;

  @GetMapping(path = "/jpa/users")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping(path = "/jpa/users/{id}")
  public Optional<User> retrieveUser(@PathVariable int id) {
    Optional<User> user;
    user = userRepository.findById(id);
    if (!user.isPresent()) {
      throw new UserNotFoundException("id - " + id);
    }
    return user;
  }

  @DeleteMapping(path = "/jpa/users/{id}")
  public void deleteUser(@PathVariable int id) {
    userRepository.deleteById(id);
  }

  @PostMapping(path = "/jpa/users")
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
    User savedUser = userRepository.save(user);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId())
            .toUri();
    return ResponseEntity.created(location).build();
  }
}
