package main.java.unit02.ext;

import java.util.Date;

/**
 * 研究类 java.sql.Date与 java.util.Date
 * java.sql.Date是java.util.Date的子类，可按Ctrl+H验证
 * 不可使用java.sql.Date的无参构造方法
 * 区别：java.sql.Date对象只包含【年-月-日】信息
 */
public class DateDemo {
    public static void main(String[] args) {
        Date date1 = new Date();
        System.out.println(date1);

        java.sql.Date date2=new java.sql.Date(date1.getTime());  //向下转型
        System.out.println(date2);

        Date date3=date2;  //向上转型
        System.out.println(date3);  //不会输出【时-分-秒】信息
    }
}
