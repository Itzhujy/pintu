package src.main.java.unit07.ks;

/**
 * 两个线程各自打印 10 次线程名，两次打印之间间隔 1 秒。
 */
class MyThread extends Thread {  //定义一个线程类
    private String threadName;
    public MyThread(String threadName) {  //构造方法
        this.threadName=threadName;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + this.threadName);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("A");
        MyThread thread2 = new MyThread("B");
        thread1.start();
        thread2.start();
    }
}
