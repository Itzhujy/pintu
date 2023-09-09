package src.main.java.unit03.unit303.reduce2;   //reduce：精减

class Manager {  //业务类
    interface Callback{   //内部接口
        void process();
    }

    private Callback callback;  //类字段

    public void setCallback(Callback callback) {   //setter
        this.callback = callback;
    }

    public void assignTask(Employee employee){  //类Manager依赖类Employee
        employee.doSomething(callback);  //将管理者对象作为方法参数传递
    }
}

class Employee{  //回调类
    //方法doSomething()的参数类型为接口类型，使得Manager实现方法自身的间接调用成为可能
    public void doSomething(Manager.Callback callback){  //类Employee依赖接口Callback
        callback.process();  
    }
}

public class MyTest {
    public static void main(String[] args)  {
        Employee employee = new Employee();
        Manager manager = new Manager();

        //manager.setCallback(() -> System.out.println("执行我预定义的方法"));
        manager.setCallback(new Manager.Callback() {
            @Override
            public void process() {
                System.out.println("执行我预定义的方法");
            }
        });

        manager.assignTask(employee);
    }
}