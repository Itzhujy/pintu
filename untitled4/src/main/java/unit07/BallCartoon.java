package main.java.unit07;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * 小球卡通动画
 * 在一个大小为 1450*750的面板内的坐标(0,740)处，绘制沿水平方向移动（步长为 10）、且逐步变大的红色小球
 * 小球移动要点：面板类实现接口 Runnable，在线程业务逻辑内改变小球起始坐标和大小并重新绘制
 */
public class BallCartoon extends JFrame {
    private static MyPanel myPanel;  //关联

    public BallCartoon() {  //构造方法
        setTitle("小球卡通动画");
        myPanel = new MyPanel();
        add(myPanel);
        pack();  //未指定窗体大小时，本语句的功能是让窗体适应面板大小
        //setLocationRelativeTo(null);   //窗体位于屏幕中央
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BallCartoon ballCartoon = new BallCartoon();//创建窗体对象
        ballCartoon.setVisible(true);  //设置可见
        Thread panelThread = new Thread(myPanel); //创建一个线程
        panelThread.setName("panelThread");  //设置线程名称
        panelThread.start(); //运行线程，添加行为；当注释本行代码时，窗体只会在左下角出现一个小球点
        System.out.println("主线程运行结束");
    }

    static class MyPanel extends JPanel implements Runnable{
        private int startX = 0;   //小球起始点（左上角）X坐标
        private int startY = 740; //小球起始点（左上角）Y坐标
        private int diameter = 10; //小球直径

        public MyPanel() {  //构造方法
            setPreferredSize(new Dimension(1450, 750));  //设置面板的大小
            //setSize(1450, 750);  //若使用本方法，屏幕显示和小球运行了轨迹将出现异常
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            //下面的2行代码是绘制辅助的矩形
            /*g.setColor(Color.gray);
            g.drawRect(startX,startY,diameter,diameter);*/

            g.setColor(Color.red);    //设置小球颜色
            g.fillOval(startX, startY, diameter, diameter); //填充小球是椭小球的特例，参数为(X坐标,Y坐标,宽,高)
        }

        @Override
        public void run() {  //业务方法
            while (true) {
                if (startX >= 1450 - diameter) { //若小球运动到区域边界则结束循环
                    break;
                } else {
                    startX += 10;     //每次X坐标加10
                }
                startY -= 10;     //每次Y坐标减10
                diameter += 10;  //每次小球大小增加10
                repaint();       //重绘小球
                try {
                    Thread.sleep(400);  //休眠
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("小球不能再滚动了");
            //本程序代码运行时，会自动加载AWT等相关线程。因此，程序结束时，进程不能正常结束。
            //直接关闭窗体，也能正常结束进程。
            //下面的代码，先获取进程id，然后主动杀死进程，实现窗体关闭。
            /*RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
            System.out.println(runtimeMXBean.getName());   //pid@systemName
            int pid = Integer.valueOf(runtimeMXBean.getName().split("@")[0]);
            System.out.println("当前进程id为："+pid);
            try {
                Runtime.getRuntime().exec("taskkill /F /PID "+pid);
                System.out.println("当前进程已经杀死。");
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
    }
}
