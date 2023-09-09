package main.java.unit03.unit303.reduce;   //reduce：精减

interface Callback{
    void process();
}

class Manager implements Callback{
    @Override
    public void process() {  //实现接口（是预定义的，将来要自动被执行）
        System.out.println("执行我预定义的方法");
    }
    
    public void assignTask(Employee employee){  //类Manager依赖类Employee
        employee.doSomething(this);  //将管理者对象作为方法参数传递
    }
}

class Employee{  //回调类
    //方法doSomething()的参数类型为接口类型，使得Manager实现方法自身的间接调用成为可能
    public void doSomething(Callback callback){  //类Employee依赖接口Callback
        callback.process();  
    }
}

public class MyTest {
    public static void main(String[] args)  {
        Employee employee = new Employee();
        new Manager().assignTask(employee);
    }
}