package main.java.unit09.daoPattern.dao;

import main.java.unit09.daoPattern.dao.entity.User;

import java.sql.ResultSet;

public class UserDaoImp implements UserDao {
	private User user;  //实现类
	@Override
	public ResultSet getAllUser() {  //重写接口方法
		try {
			return MySQLUtil.query("select * from user");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public User getUser(String un) {  //重写接口方法
		try {
			ResultSet rs = MySQLUtil.query("select * from user where username=?", un);
			if(rs.next()) {
				//封装
				User user=new User();
				user.setUsername(un);
				user.setPassword(rs.getString("password"));
				user.setRealname(rs.getString("realname"));
				user.setMobile(rs.getString("mobile"));
				user.setAge(rs.getInt("age"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public boolean addUser() {

		return false;
	}

	@Override
	public boolean addUser(User user) {  //重写接口方法
		//由读者参照完成
		return false;
	}
}
