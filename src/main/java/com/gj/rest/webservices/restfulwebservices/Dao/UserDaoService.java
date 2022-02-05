package com.gj.rest.webservices.restfulwebservices.Dao;

import com.gj.rest.webservices.restfulwebservices.Beans.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

  private static List<User> userList = new ArrayList<>();
  private static int userCount = 8;

  static {
    userList.add(new User(1, "A", new Date()));
    userList.add(new User(2, "B", new Date()));
    userList.add(new User(3, "C", new Date()));
    userList.add(new User(4, "D", new Date()));
    userList.add(new User(5, "E", new Date()));
    userList.add(new User(6, "F", new Date()));
    userList.add(new User(7, "G", new Date()));
    userList.add(new User(8, "H", new Date()));
  }

  public static List<User> getUserList() {
    return userList;
  }

  public static void setUserList(List<User> userList) {
    UserDaoService.userList = userList;
  }

  public List<User> findAll() {
    return userList;
  }

  public User save(User user) {

    if (user.getId() == null) {
      user.setId(++userCount);
    }
    userList.add(user);
    return user;
  }

  public User findOne(int id) {
    for (User user : userList) {
      if (user.getId() == id) {
        return user;
      }
    }
    return null;
  }

  public User deleteById(int id) {

    Iterator<User> iterator = userList.iterator();

    while (iterator.hasNext()) {
      User user = iterator.next();
      if (user.getId() == id) {
        iterator.remove();
        return user;
      }
    }
    return null;
  }
}
