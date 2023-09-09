package main.java.unit09.daoPattern.service;

import main.java.unit09.daoPattern.dao.UserDao;
import main.java.unit09.daoPattern.dao.entity.User;

import java.sql.ResultSet;

public class UserDaoImp implements UserDao {
    @Override
    public ResultSet getAllUser() {
        return null;
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public boolean addUser() {
        return false;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }
}
