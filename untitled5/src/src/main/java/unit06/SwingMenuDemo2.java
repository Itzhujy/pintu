package src.main.java.unit06;

import javax.swing.*;
import java.awt.*;

public class SwingMenuDemo2 extends JFrame {
    public SwingMenuDemo2(){
        setTitle("Swing菜单示例2");
        //设置窗体尺寸大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) screenSize.getWidth()/3, (int) screenSize.getHeight()/3);
        createMenu();  //创建菜单
    }
    public void createMenu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu_file = new JMenu("文件");
        JMenuItem menuItem11 = new JMenuItem("新建");
        menu_file.add(menuItem11);

        //JMenuItem menuItem12 = new JMenuItem("保存");
        //JMenuItem menuItem12 = new JCheckBoxMenuItem("保存");  //JCheckBoxMenuItem是JMenuItem的子类
        JMenuItem menuItem12 = new JRadioButtonMenuItem("保存");  //JRadioButtonMenuItem是JMenuItem的子类
        menu_file.add(menuItem12);

        menu_file.addSeparator();  //菜单项之间的分隔线
        JMenuItem menuItem13 = new JMenuItem("退出");
        menu_file.add(menuItem13);
        menuItem13.addActionListener(e -> {
            dispose();
            System.exit(0);
        });
        menuBar.add(menu_file);
        JMenu menu_edit = new JMenu("编辑");
        menuBar.add(menu_edit);

        setJMenuBar(menuBar);  //设置窗体菜单
        //add(menuBar);  //使用本方法添加窗体菜单，需要更改窗体布局，如 setLayout(new FlowLayout(FlowLayout.LEFT))
    }
    public static void main(String[] args) {
        SwingMenuDemo2 swingMenu2 = new SwingMenuDemo2();
        swingMenu2.setVisible(true);
    }
}
