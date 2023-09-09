package main.java.unit03.advanced;

interface Animal{
    void cry();
}

public class FinalDemo {
    public static void main(String[] args) {
        String s="狗";  //为了在匿名类里使用本变量，一般需要使用final修饰。事实上，反编译后可以验证这一点。
        Animal animal=new Animal() {
            @Override
            public void cry() {
                //String s="猫";
                System.out.println(s);
                System.out.println("汪汪叫...");
            }
        };
        animal.cry();
    }
}
