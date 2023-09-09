package src.main.java.unit07;

class HelloThread3 implements Runnable {
    int i;
    synchronized void show(){   //同步方法
        System.out.println("当前线程:" + Thread.currentThread().getName());
        System.out.println("Hello " + i++);
    }

    @Override
    public void run() {
        i = 0;
        while (true) {
            show();  //调用同步方法
            if (i > 3) break;  //共输出3+2次后，线程结束
        }
    }
}

public class ThreadDemo3 {
    public static void main(String[] args) {
        HelloThread3 r = new HelloThread3();
        Thread t1 = new Thread(r);
        t1.start();
        Thread t2 = new Thread(r);
        t2.start();
    }
}
