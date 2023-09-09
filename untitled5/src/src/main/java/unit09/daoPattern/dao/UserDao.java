package src.main.java.unit09.daoPattern.dao;

import unit09.daoPattern.dao.entity.User;

import java.sql.ResultSet;

public interface UserDao {
	ResultSet getAllUser();  //获取所有用户
	User getUser(String username);  //根据用户名获取用户信息
	boolean addUser(User user);  //增加一个用户
}
