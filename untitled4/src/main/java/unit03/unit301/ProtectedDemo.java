package main.java.unit03.unit301;

import main.java.unit03.unit301.sub.Animal;

/**
 * 访问修饰符 protected，用于修饰有继承关系的基类成员
 * 使用protected修饰的成员，对于同包或子类均可见
 * 在子类里，只能通过子类实例访问保护方法，而不能通过基类实例访问保护方法
 */
public class ProtectedDemo extends Animal {
    public static void main(String[] args) {
        new ProtectedDemo().printMsg();  //通过子类实例访问保护方法，ok
        //new Animal().printMsg();  //在子类里，通过基类实例访问保护方法，error
    }
}
