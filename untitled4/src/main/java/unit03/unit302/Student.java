package main.java.unit03.unit302;

abstract class MessageKind{   //抽象消息类
    public abstract String getMessage();   //获取消息的抽象方法
}

class Sms extends MessageKind{   //子类1

    @Override
    public String getMessage() {
        return "短信息";
    }
}

class QQ extends MessageKind{  //子类2

    @Override
    public String getMessage() {
        return "QQ消息";
    }
}

public class Student {   //主类
    String name;

    public Student(String name) {  //构造方法
        this.name = name;
    }

    public void sendMessage(String msg){   //发消息实例方法
        System.out.println(name+"在发【"+msg+"】");
    }

    public static void main(String[] args) {
        Student zs = new Student("张三");
        zs.sendMessage(new Sms().getMessage());
        zs.sendMessage(new QQ().getMessage());
    }
}
