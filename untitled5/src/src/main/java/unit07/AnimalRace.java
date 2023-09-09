package src.main.java.unit07;

/**
 * 动物（乌龟和兔子）赛跑，对应于两个线程
 * 多次运行，乌龟和兔子都有可能先到达终点
 * 要求：兔子休眠时间随机且比乌龟稍长
 */
class AnimalThread extends Thread {
    private String name;  //动物名称
    private int speed;  //速度
    private int distance=50;  //距离
    private int sumDistance = 0; //已跑距离初值
    private long sleepTime = 500; //休眠时长（以毫秒为单位）

    public AnimalThread(String name, int speed) {  //构造方法
        this.name = name;
        this.speed = speed;
    }

    @Override
    public void run() {  //线程业务逻辑
        while (sumDistance < distance) {
            if(name.equals("乌龟")){
                try {
                    Thread.sleep(sleepTime);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }else{
                try {  //兔子休眠时间随机但比乌龟稍长
                    double v = sleepTime * (1 + Math.random());
                    Thread.sleep((long)v);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            sumDistance += speed;  //已经跑了多长距离
            System.out.println(name + " : 我已经跑了 " + sumDistance);
        }
        System.out.println(name + " 终于冲过终点了 ! "); //执行本语句后线程结束
    }
}

public class AnimalRace {
    public static void main(String[] args) {
        //创建2个线程并运行
        new AnimalThread("乌龟", 15).start();
        new AnimalThread("兔子", 20).start();

        //线程对象只有通过调用start()方法启动，才具有多线程特性。
        //如果将上面的线程方法start()修改为run()，则变成顺序程序。
        /*new AnimalThread("乌龟", 15).run();
        new AnimalThread("兔子", 20).run();*/

        System.out.println("当前线程名："+Thread.currentThread().getName());
        try {
            Thread.sleep(30*1000);  //休眠半分钟，以便在Java VisualVM里观察进程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
