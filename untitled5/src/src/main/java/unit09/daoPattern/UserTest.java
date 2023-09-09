package src.main.java.unit09.daoPattern;

import org.junit.Test;
import unit09.daoPattern.dao.UserDao;
import unit09.daoPattern.dao.UserDaoImp;
import unit09.daoPattern.dao.entity.User;
import unit09.daoPattern.service.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTest {
    UserService userService;

    @Test
    public void test1() {  //输出指定用户信息测试
        UserDao userDao = new UserDaoImp(); //创建对象，向上转型
        System.out.println(userDao.getUser("Zhangsan")); //调用接口方法
    }

    @Test
    public void test2() {  //输出所有用户信息测试
        UserDao userDao = new UserDaoImp();
        ResultSet rs = userDao.getAllUser();
        try {
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRealname(rs.getString("realname"));
                user.setMobile(rs.getString("mobile"));
                user.setAge(rs.getInt("age"));
                System.out.println(user.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {  //增加用户测试
        //由读者参照完成
    }
}
