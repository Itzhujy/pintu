package src.main.java.unit03.unit303;

/**
 * 方法回调示例：管理者与员工
 * （1）对于管理者来说：给员工发布任务、获得员工的反馈结果。
 * （2）对于员工来说：处理管理者交给的任务、将结果反馈给管理者。
 * 要点：在main()方法里，manager执行某个方法时，并未直接调用Manager实现的接口方法，
 *      而是通过Employee的doSomthing()方法间接调用了Manager实现的接口方法。
 */
interface Callback {    //回调接口
    void process();  //根据需要，可以定义为有参数
}

class Manager implements Callback {   //管理者；实现回调接口
    @Override
    public void process() {
        System.out.println("【我是管理者，执行我预定义的方法...】");
    }

    //管理者向员工布局任务，调用了类Employee的方法
    public void assignTask(Employee employee) {
        System.out.println("我是管理者，向员工布置任务");
        //Manager对象将自身作为Employee对象的方法参数
        employee.doSomthing(this);
    }
}

class Employee{   //员工
    //方法设计接收一个CallBack参数，使得 Manager实现方法回调成为可能
    //员工完成任务后，需要知道要向谁反馈
    public void doSomthing(Callback callBack) {
        System.out.println("我是员工，任务收到。完成任务后，将及时反馈...");
        //在Manager对象执行方法assignTask()时，已经将自身对象作为Employee的方法参数
        callBack.process();
    }
}

public class CallbackDemo {
    public static void main(String[] args) {
        Employee employee = new Employee();
        Manager manager = new Manager();
        manager.assignTask(employee);
        System.out.println("我是管理者，继续工作");
    }
}
