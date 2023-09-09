package main.java.unit07;

class MyThread extends Thread{
    @Override
    public void run() {   //线程的业务逻辑
        super.run();
        for(int i=0;i<5;i++){
            System.out.print('A');
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Temp {
    static Runnable runnable=new Runnable(){
        @Override
        public void run() {
            for(int i=0;i<5;i++){
                System.out.print('A');
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    public static void main(String[] args) {
        System.out.println("主线程运行开始，并即将运行子线程");
        System.out.println(Thread.currentThread().getName());

        //new MyThread().start(); //创建线程对象并启动
        new Thread(runnable).start();

        System.out.println("主线程运行结束");
    }
}
