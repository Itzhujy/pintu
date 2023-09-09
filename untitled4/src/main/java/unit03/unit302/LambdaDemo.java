package main.java.unit03.unit302;

/**
 * Lambda表达式示例
 * JDK 1.8高级特性，可以使用Lambda运算符：->
 * 使用Lambda表达式，可以进一步简化接口类型对象的定义
 * 可以省略参数类型和要实现的接口方法（根据上下文智能识别）
 * 使用Lambda表达式的条件：仅包含一个抽象方法的接口类型的参数（接口方法的参数个数没有限制）
 */
interface Printer{   //定义一个打印接口，包含一个接口方法
    void print(String str);
}

public class LambdaDemo {
    //方法第2参数为接口类型
    public void printSomething(String sth,Printer printer) {
        printer.print(sth);
    }

    public static void main(String[] args) {
        //（一）使用匿名内部类，而不使用 Lambda表达式。此时，IDEA自动提示可以使用 Lambda表达式
        new LambdaDemo().printSomething("Hello", new Printer() {
            @Override
            public void print(String str) {
                System.out.println("Hello");
            }
        });

        //（二）使用 Lambda表达式
        Printer printer=(str)->{
            //实现接口Printer的抽象方法
            System.out.println(str);
        };
        //当接口实现只有一行代码时，可省略一对花括号
        //Printer printer=str->System.out.println(str);
        printer.print("Hello1");

        new LambdaDemo().printSomething("Hello2", printer);
        //函数式编程，比使用匿名对象更加简洁
        new LambdaDemo().printSomething("Hello3", str->System.out.println(str));
    }
}