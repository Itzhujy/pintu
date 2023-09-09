package src.main.java.unit03.unit302;

/*泛型是一个未知的数据类型,当我们不确定什么数据类型时,可以使用泛型;
 * 泛型可以接受任意的数据类型,如Integer,String,Parent,...
 * 创建对象的时候确定泛型的数据类型!
 * 可以定义泛型类, 方法 和 接口
 *
 * 定义泛型方法: 泛型定义在方法的修饰符和返回值类型之间,格式:
 * 修饰符 <泛型> 返回值类型 方法名(参数列表(使用泛型)){ 方法体; }
 * 含有泛型的方法,在调用方法时确定泛型的数据类型
 * 传递什么类型的参数, 泛型就是什么类型
 *
 * 泛型的好处是在编译的时候检查类型安全，并且自动拆装箱: 所有的强制转换都是自动(没有强制转换)和隐式的.
 * 例如, 自动装箱: Integer.valueOf(int i); 自动拆箱: i.intValue();
 * 泛型很好地避免了强制类型转换，其应用例如,定义一个方法，它可以传入任意类型的对象，并且返回这个类型的对象。
 * 泛型类型无法被实例化: " array= new T[length]"，因为编译器无法知道该怎么做。没有特定类型，编译器将无法知道要调用哪个构造函数.
 * 泛型是引用类型，是参数化类型，可以理解为一个抽象类型，只是代表了类型的抽象，因此我们不能直接实例化它.
 *
 * 解决这类问题的办法是: 先为特定类型编写实现，然后再使用泛型将其抽象出来。
 */

import java.util.Set;

//1: 泛型类型无法被直接实例化,直到创建对象时才确定!
class genericClass<E> {
    private E no;

    genericClass() {
    }

    genericClass(E no) {
        this.no = no;
    }

    public E getNo() {
        return no;
    }

    public void setNo(E no) {
        this.no = no;
    }

    //定义泛型方法, 返回值类型为泛型 E
    public <E> E genericMethod(E e) {
        System.out.println(e);
        return null; //new E(); //imagine if that was allowed
    }

    //2:由于泛型擦除的原因，以下方法并不视为方法的重载且无法编译
    public void sets(Set<String> strSet) {
    }
    //public void sets(Set<Integer> intSet) { }
}

interface genericInterface<T> {  //泛型接口
    void display(T t);
}

/**
 * 实现含有泛型的接口,可以是泛型, 也可以是具体类型;
 * 接口使用什么泛型,实现类就用什么泛型; 类跟着接口走;创建对象时确定泛型的类型
 */
class genericClass_intf<T> implements genericInterface<T> {
    @Override
    public void display(T t) {
        System.out.println(t);
    }
}

public class genericClassDemo {
    public static void main(String[] args) {
        //System.out.println("泛型类型因为只代表类型的抽象而不能被实例化! 同样泛型不能用作方法的重载!");
        //1:不写泛型默认为Object类型
        genericClass gc1 = new genericClass();
        gc1.setNo("200101");
        Object no1 = gc1.getNo();
        System.out.println("default Object: " + no1.toString());

        //2:泛型使用Integer类型
        genericClass<Integer> gc2 = new genericClass<>();
        gc2.setNo(202002);
        Integer no2 = gc2.getNo();
        System.out.println("Concrete Integer: " + no2);

        //泛型使用String类型String
        genericClass<String> gc3 = new genericClass<>();
        gc3.setNo("202103");
        String no3 = gc3.getNo();
        System.out.println("Concrete String: " + no3);

        //测试泛型方法
        gc1.genericMethod(new Object());
        gc1.genericMethod(100);
        gc1.genericMethod("This");
        gc1.genericMethod(100.0);
        gc1.genericMethod(true);

        //测试含有泛型的接口
        genericClass_intf gc_intf1 = new genericClass_intf<>();
        gc_intf1.display("字符串");

        genericClass_intf<Integer> gc_intf2 = new genericClass_intf<>();
        gc_intf2.display(1000);

        genericClass_intf<Double> gc_intf3 = new genericClass_intf<>();
        gc_intf3.display(1000.0);

    }
}
