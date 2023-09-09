package src.main.java.unit09;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        try {
            //创建接口java.sql.Driver类型的实例（驱动）
            Driver driver=new com.mysql.cj.jdbc.Driver();  //需要进行异常捕促
            //注册驱动程序
            DriverManager.registerDriver(driver);
            //数据库的连接字符串
            String url="jdbc:mysql://localhost:3306/memmana?serverTimezone=UTC";
            //获取接口Connection（表示数据库连接对象）的实例
            Connection connection = DriverManager.getConnection(url, "root", "root");
            //创建接口Statement（表示执行数据库操作的命令对象）的实例
            Statement statement = connection.createStatement();
            //执行SQL查询，得到接口ResultSet（表示结果集对象）的实例
            ResultSet rs = statement.executeQuery("select * from user where age>80");
            //遍历结果集（对象）
            while (rs.next()){
                //从结果集对象获取字段值，需要明确字段类型
                String exp=rs.getString("username") ;
                exp+="--" +rs.getString("realname");
                exp+="--" + rs.getInt("age");
                System.out.println(exp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
