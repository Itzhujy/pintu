package main.java.unit03.unit302;

/**
 * 继承与接口的综合运用
 * 在使用继承的同时，使用接口解决了Java单继承的不足
 */
interface IFish { //定义接口
    public void swimming();//没有主体的方法申明
}

interface IBird {  //定义接口
    void fly();//没有主体的方法申明
}

class Monkey {  //普通类
    public String name;
    public int age;

    public void jump() {
        System.out.println("我是猴子，会跳");
    }
}

//类继承的同时，还实现多个接口，弥补了Java单继承的不足！
class LittleMonkey extends Monkey implements IFish, IBird {
    @Override
    public void swimming() {  //实现接口方法
        System.out.println("我是小猴，也能象鱼儿游泳");//
    }
    @Override
    public void fly() {  //实现接口方法，作用类似于子类重写父类方法
        System.out.println("我是小猴，也能象鸟儿飞");
    }
}

public class ExtendsAndImplementsDemo {    //测试类
    public static void main(String args[]) {
        LittleMonkey lm = new LittleMonkey(); //实例化
        lm.jump();  //调用基类方法
        System.out.println("----------------");
        lm.swimming(); //调用接口（“父类”）的方法
        lm.fly();  //调用接口（“父类”）的方法
    }
}
//本例可将 Monkey设计为抽象类 Animal，并让 LittleMonkey继承 Animal。