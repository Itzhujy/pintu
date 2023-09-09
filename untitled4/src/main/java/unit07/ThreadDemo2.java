package main.java.unit07;

class HelloThread2 implements Runnable {
    int i;

    @Override
    public void run() {
        synchronized (this){  //同步代码块
            i = 0;
            while (true) {
                System.out.println("当前线程:" + Thread.currentThread().getName());
                System.out.println("Hello " + i++);
                if (i > 3) break;  //共输出3+2次后，线程结束
            }
        }
    }
}

public class ThreadDemo2 {
    public static void main(String[] args) {
        HelloThread2 r = new HelloThread2();
        Thread t1 = new Thread(r);
        t1.start();
        Thread t2 = new Thread(r);
        t2.start();
    }
}
