package src.main.java.unit07;

class HelloRunnable implements Runnable {
    int i;

    @Override
    public void run() {      // 重写Runnable接口的run()方法
        i = 1;
        while (true) {
            //方法println()使用了synchronized修饰。因此，线程输出的2条打印语句不能保证在屏幕上连续。
            System.out.println("当前运行的线程:" + Thread.currentThread().getName());
            System.out.println("线程"+Thread.currentThread().getName()+"输出Hello " + i++);
            if (i > 3) break;  //共输出3*2次后，线程结束
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        //下面代码多次运行结果表明：输出Hello和线程名的顺序随机，次数并非总是3（可能为4）
        //由同一对象创建的不同线程=>存在变量共享
        HelloRunnable r = new HelloRunnable();  //创建线程对象
        new Thread(r).start();   //创建线程并运行
        new Thread(r).start();   //创建线程并运行

        //下面代码多次运行结果表明：输出Hello和线程名的顺序随机。
        //由不同对象创建的线程=>完全独立运行，输出Hello和线程名的次数都是3
        /*new Thread(new HelloRunnable()).start();
        new Thread(new HelloRunnable()).start();*/
    }
}
