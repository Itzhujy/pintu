package main.java.unit03.unit301;

class Super {
    static String greeting() {  //静态方法
        return "Good night";
    }
    String name() {
        return "Tom";
    }
}

class Sub extends Super {
    static String greeting() {  //静态方法
        return "Hello";
    }

    String name() {   //重写
        return "Mary";
    }
}

public class ExtendsDemo {

    public static void main(String[] args) {
        Super s = new Sub();
        System.out.println(s.greeting() + "," + s.name());
    }
}