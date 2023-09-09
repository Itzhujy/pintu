package main.java.unit09.daoPattern.service;

import main.java.unit09.daoPattern.dao.entity.User;

import java.util.List;

public interface UserService {
    boolean isUser(User user);
    List<User> getAllUser();
    User getUserByUsername(String username);
}
