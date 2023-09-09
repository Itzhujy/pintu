package main.java.unit03.advanced;
/*
 * 单例模式：有些对象只需在内存里保留一份，以节约资源。
 * 单例类的构造函数为私有，在类的外部无法使用new创建其实例；
 * 提供一个自身的静态私有成员变量；
 * 提供一个公有的静态方法，用于获取单例类的实例对象。
 */

import java.util.Date;

public class Singleton {
	//自身类型的静态成员（类属性）——自关联
	private static Singleton instance; 
	//定义无参构造方法为私有，保证在类外不能创建该类的实例
	private Singleton() {
		System.out.println("执行了构造方法。");
	}
	
	//公有的静态方法getInstance()用于获取单例类的实例
	public static Singleton getInstance() {
		if (instance==null) {
			instance=new Singleton();  //实例化
			System.out.println("第一次创建实例！");
		} else {
			System.out.println("不再新建对象，直接使用原来的实例！");
		}
		return instance;  //返回对象
	}

	public static void main(String args[]) {

		Date date1 = new Date();
		System.out.println(date1);
		Date date2 = new Date();
		System.out.println(date2);
		System.out.println(date1 == date2);  //输出：false
		System.out.println(date1.equals(date2));  //输出：false
		String str1 = date1.toString();
		String str2 = date2.toString();
		System.out.println(str1.equals(str2));  //输出：true
		System.out.println(new Date() == new Date());  //输出：false
		System.out.println(new Date().toString().equals(new Date().toString()));  //输出：true

		Singleton singleton1,singleton2;  //声明对象
		singleton1=Singleton.getInstance(); //对象实例化
		System.out.println("singleton1引用的对象："+singleton1);
		System.out.println("singleton1引用的对象的Hash码："+singleton1.hashCode());

		System.out.println("==================================================");
		singleton2=Singleton.getInstance();
		System.out.println("singleton2引用的对象："+singleton2);
		System.out.println("singleton2引用的对象的Hash码："+singleton2.hashCode());
		System.out.println("两个引用的对象在内存中的id相同，因此，它们的Hash码相同。反之不然。");
	}
}
