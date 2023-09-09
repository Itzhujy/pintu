package src.main.java.unit06; /**
 * 制作菜单的三个层次：JMenuBar（菜单栏）-->JMenu（菜单）-->菜单项（JMenuItem）、JSeparator（分隔符）
 *                                其中，特殊的菜单项有：JCheckBoxMenuItem、JRadioButtonMenuItem
 * 定义菜单事件与菜单项单击事件
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SwingMenuDemo extends JFrame {
    public SwingMenuDemo(){   //构造方法
        setTitle("Swing菜单示例");
        setSize(1000, 500);  //设置窗体大小，不能使用pack()方法。否则，此命令失效。
        setLocation(500,500);  //设置窗体起始位置
        setResizable(false);
        init();
    }

    public  void init(){  //初始化方法
        setLayout(new FlowLayout());
        //创建菜单栏
        JMenuBar jMenuBar = new JMenuBar();
        //添加菜单栏到窗体
        setJMenuBar(jMenuBar);
        //创建菜单并添加至菜单栏
        JMenu jMenu1 = new JMenu("用户管理");  //包含若干菜单项
        jMenuBar.add(jMenu1);
        JMenu jMenu2 = new JMenu("员工信息管理");
        jMenuBar.add(jMenu2);
        JMenu jMenu3 = new JMenu("退出");  //不包含菜单项
        jMenuBar.add(jMenu3);

        //创建菜单项并添加至相应的菜单，并使用特殊有菜单项分隔符
        JMenuItem menuItem1_1 = new JMenuItem("追加新用户");  //创建普通的菜单项
        jMenu1.add(menuItem1_1);  //添加至菜单
        JSeparator jSeparator1 = new JSeparator();  //创建分隔符
        jMenu1.add(jSeparator1);  //将分隔符添加至菜单
        JMenuItem menuItem1_2 = new JMenuItem("用户信息查询");
        jMenu1.add(menuItem1_2);
        JSeparator jSeparator2 = new JSeparator();
        jMenu1.add(jSeparator2);
        JMenuItem menuItem1_3 = new JMenuItem("用户信息修改");
        jMenu1.add(menuItem1_3);
        JSeparator jSeparator3 = new JSeparator();
        jMenu1.add(jSeparator3);
        JMenuItem menuItem1_4 = new JMenuItem("删除用户");
        jMenu1.add(menuItem1_4);

        //添加单击监听器
        //菜单监听，接口 ActionListener失效，而选用 MouseListener或 MenuListener
        jMenu3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int yn = JOptionPane.showConfirmDialog(
                        null, //父组件
                        "真的要退出吗？",
                        "请确认",
                        //下面的类常量可换成YES_NO_CANCEL_OPTION
                        JOptionPane.YES_NO_OPTION
                );
                if(yn==0) {  //确认退出
                    dispose();
                    System.exit(0);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //菜单项监听，使用接口 ActionListener
        menuItem1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //实际开发中，应该使用
                System.out.println("test2");
            }
        });

    }
    public static void main(String[] args) {
        SwingMenuDemo jMenuDemo = new SwingMenuDemo();
        jMenuDemo.setVisible(true);
        jMenuDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
