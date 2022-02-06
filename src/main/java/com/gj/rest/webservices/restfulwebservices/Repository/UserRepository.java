package com.gj.rest.webservices.restfulwebservices.Repository;

import com.gj.rest.webservices.restfulwebservices.Beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {}
