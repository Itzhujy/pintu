package src.main.java.unit03.unit303;
/**
 * 使用 Java反射技术，实现另一种创建类的实例的通用方式（相对使用关键字 new 而言）。
 * Java反射技术，能提高程序的通用性。Spring MVC等框架就使用Java反射；JDK动态代理也使用了Java反射。
 * 相关知识点：
 * （1）Class<?>类型与某个具体类相关联，有多种方式创建
 * （2）类类型  Class<?>提供了普通方法 newInstance()
 * （3）包java.lang.reflect提供了反射技术的相关协作类，如 Field和 Method等
 *     其中，类 Method提供了反射调用方法 invoke()，方法第一参数为被反射调用类的实例
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person{   //被反射调用的普通类
    private String id;
    private String name;

    private void eat(){  //私有方法
        System.out.println("每个人需要吃饭。");
    }
    public void work(){
        System.out.println("每个人需要努力工作。");
    }
}

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {  //使用Java反射创建对象

        Class<?> clazz = Person.class;  //类型（类或接口）信息，此方式更加通用
        //Class<?> clazz = Class.forName("unit03.unit303.Person");   //类名前的包名不可省略！
        //Class<?> clazz=new Person().getClass();  //创建与类Person对应的类类型的对象

        Person person = (Person) clazz.newInstance();   //创建类Person的实例（注意：与之前使用new创建对象的方法不同）
        System.out.println(person instanceof Person);  //测试对象的类型
        person.work();

        //通过类类型对象获取类Person的字段信息并输出
        Field[] fields = clazz.getDeclaredFields();
        for(Field f:fields){
            System.out.println(f);
            //System.out.println(f.getName());
        }
        //通过类类型对象获取类Person的方法（构造方法除外）并输出
        Method[] methods = clazz.getDeclaredMethods();
        for(Method m:methods){
            System.out.println(m);
            //System.out.println(m.getName());
        }

        //公有方法反射调用
        System.out.println("=====公有方法反射调用=====");
        Method personWork = clazz.getMethod("work");   //work是类Person的方法名
        personWork.invoke(clazz.newInstance());  //通用
        //personWork.invoke(new Person());  //不通用

        //私有方法的反射调用
        System.out.println("=====私有方法反射调用=====");
        Method personEat = clazz.getDeclaredMethod("eat",null);
        personEat.setAccessible(true);  //设置允许访问
        personEat.invoke(clazz.newInstance());
    }
}
