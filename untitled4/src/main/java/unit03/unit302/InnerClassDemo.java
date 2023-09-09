package main.java.unit03.unit302;
/**
 * 内部类的使用：使用内部类实现多重继承
 * 当 Father和Mother是接口时，我们确实是看不出来使用内部类存在何种优点。
 * 如果 Father、Mother不是接口，而是抽象类或者具体类呢，此时就只能使用内部类实现多重继承。
 * 摘自《Think in java》
 *    1、内部类可以用多个实例，每个实例都有自己的状态信息，并且与其他外围对象的信息相互独立。
 *    2、在单个外围类中，可以让多个内部类以不同的方式实现同一个接口，或者继承同一个类。
 *    3、创建内部类对象的时刻并不依赖于外围类对象的创建。
 *    4、内部类并没有令人迷惑的“is-a”关系，他就是一个独立的实体。
 *    5、内部类提供了更好的封装，除了该外围类，其他类都不能访问。
 */

interface Father {
    //
}

interface Mother {
    //
}

class Son implements Father, Mother {   //一个类同时实现接口Father和Mother
    //
}

class Daughter implements Father {   //类Daughter实现接口Father
    class Mother_ implements Mother {   //类Mother_实现接口Mother，同时作为类Daughter的内部类，
        //
    }
}

public class InnerClassDemo {
    public static void main(String[] args) {
        //
    }
}
