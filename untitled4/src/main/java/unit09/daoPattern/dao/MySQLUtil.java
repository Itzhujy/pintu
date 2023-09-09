package main.java.unit09.daoPattern.dao;
/**
 * 访问MySQL8的通用类
 */
import java.sql.*;

public class MySQLUtil { // 类定义
    private static Connection conn = null; //
    private static PreparedStatement pst = null; // 参数式查询必须

    static {  //静态代码块，在调用业务方法前自动执行
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //加载MySQL8驱动包，IDEA里不可省略
            String url = "jdbc:mysql://localhost:3306/memmana?serverTimezone=UTC&characterEncoding=utf-8";
            String username = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, username, password); // 创建链接对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet query(String sql, Object... args) throws Exception { // 选择查询方法
        // SQL命令中含有通配符，使用可变参数使得可以传离散或数组两种方式的参数
        pst = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            pst.setObject(i + 1, args[i]);
        }
        return pst.executeQuery();
    }

    public static boolean cud(String sql, Object... args) throws Exception { // 增加_c，修改_u，删除_d
        pst = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            pst.setObject(i + 1, args[i]);
        }
        return pst.executeUpdate() >= 1 ? true : false; // 返回操作查询是否成功？
    }

    public static void closeConn() throws Exception { // 关闭数据库访问方法
        if (pst != null)
            pst.close();
        if (conn != null)
            conn.close();
    }
}
