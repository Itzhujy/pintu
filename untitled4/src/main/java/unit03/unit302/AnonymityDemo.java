package main.java.unit03.unit302;
/**
 * 程序中创建一个接口的实现类，创建该实现类的对象仅仅使用一次，会造成内存资源浪费
 * 实际开发中，很少是自己定义接口，自己写实现。
 * 在后续课程（如Android）中，许多方法的参数是接口类型或者抽象类型，通常使用该类型的匿名对象
 * 注意：使用new运算符，不能能直接创建其实例
 */
interface ISay {
    void sayHello();
}
/*class ISayImp implements ISay{  //非匿名用法
    @Override
    public void sayHello() {
        System.out.println("Hello java!");
    }
}*/

public class AnonymityDemo {
    public static void main(String[] args) {
        //创建接口ISay的匿名实现类对象say
        ISay say = new ISay() {
            @Override
            public void sayHello() {
                System.out.println("Hello Java!");
            }
        };
        //ISayImp say = new ISayImp();  //配合非匿名用法
        say.sayHello(); //调用接口方法

        /*new ISay(){
            @Override
            public void sayHello() {
                System.out.println("Hello Java!");
            }
        }.sayHello();*/
    }
}
