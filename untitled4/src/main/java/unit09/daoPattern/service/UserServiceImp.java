package main.java.unit09.daoPattern.service;

import main.java.unit09.daoPattern.dao.UserDao;
import main.java.unit09.daoPattern.dao.entity.User;
import unit09.daoPattern.dao.MySQLUtil;

import java.sql.ResultSet;
import java.util.List;

/**
 * DAO更换数据库的种类，不需要修改Service层
 */
public class UserServiceImp implements UserService{
    UserDao userDao=new UserDaoImp();  //调用DAO层
    private User user;

    @Override
    public boolean isUser(User user) {
        this.user = user;
        String un = user.getUsername();
        String pwd = user.getPassword();
        try {
            ResultSet query = MySQLUtil.query("select * from user where username=? and password=?", un, pwd);
            if(query.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isUser(User user) {
        return false;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        User user=new User();
        try {
            ResultSet query = MySQLUtil.query("select * from user where username=?",username);
            if(query.next()){
                user.setUsername(query.getString("username"));
                user.setPassword(query.getString("password"));
                user.setRealname(query.getString("realname"));
                user.setMobile(query.getString("mobile"));
                user.setAge(query.getInt("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
