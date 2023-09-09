package main.java.unit06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * 对用户登录窗体中的登录面板使用分组布局
 * 窗体使用JFrame、面板使用JPanel
 * 使用 GroupLayout创建分组布局对象 groupLayout，以JFrame的内容面板作为构造参数
 * 对 groupLayout应用方法 createSequentialGroup()，分别创建水平顺序组对象 hGroup和垂直顺序组 vGroup
 * 分别对 hGroup和vGroup 添加组（根据需要在此之前设置间隔）、创建并行组、添加组件
 */
public class SwingGroupLayoutDemo extends JFrame {
    JTextField usernameTextField;
    JPasswordField passwordTextField;
    JButton loginButton, resetButton;  //登录与重置按钮
    JCheckBox checkbox;   //复选框（记住用户名及密码）
    //程序运行入口
    public static void main(String args[]) {
        new SwingGroupLayoutDemo();
    }
    //窗体类的构造方法
    public SwingGroupLayoutDemo() {
        setTitle("分组布局示例");
        //设置窗体尺寸大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) screenSize.getWidth()/5, (int) screenSize.getHeight()/6);
        //设置窗口位置在屏幕中央
        setLocationRelativeTo(null);
        //设置窗体大小不可调节（默认是可调节）
        setResizable(true);
        //调用创建登录面板并添加至窗体方法
        createLoginPanel();
        //添加关闭窗体操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //调用窗体的业务操作方法
        operation();
        //设置窗体内组件可见（默认不可见）
        setVisible(true);
    }
    //定义创建面板并添加至窗体方法
    void createLoginPanel(){
        //（1）创建登录的组件
        //（1-1）基本组件
        JLabel jLabel_caption = new JLabel("用户登录");
        jLabel_caption.setFont(new Font("黑体",Font.BOLD,16));
        JLabel jLabel_username = new JLabel("用户名：");
        usernameTextField = new JTextField();  //类字段
        JLabel jLabel_password = new JLabel("密    码：");
        passwordTextField = new JPasswordField();  //类字段
        //passwordTextField.setEchoChar('*');   //设置密码输入时的显示字符，默认“·”
        //（1-2）命令面板
        JPanel jPanel_command=new JPanel();
        loginButton = new JButton("确定");  //类字段
        loginButton.setFont(new Font("黑体",Font.BOLD,16));
        resetButton = new JButton("重置");  //类字段
        resetButton.setFont(new Font("黑体",Font.BOLD,16));
        checkbox = new JCheckBox("记住我");  //类字段
        jPanel_command.add(loginButton);
        jPanel_command.add(resetButton);
        jPanel_command.add(checkbox);
        //（2）创建分组布局对象，并应用到窗体
        GroupLayout groupLayout = new GroupLayout(getContentPane());  //必须使用JFame的内容面板
        setLayout(groupLayout);
        //（2-1）创建水平组对象并作为分组布局对象的水平组
        GroupLayout.SequentialGroup hGroup = groupLayout.createSequentialGroup();
        groupLayout.setHorizontalGroup(hGroup);
        //给水平组添加组、进而添加组件
        hGroup.addGap(120);  //设置相对窗体的Left（以像素为单位）
        hGroup.addGroup(groupLayout.createParallelGroup()  //创建并行组
                            .addComponent(jLabel_username)  //用户名标签
                            .addComponent(jLabel_password)); //密码标签
        hGroup.addGap(10);  //设置第1个水平组的Left（以像素为单位）
        hGroup.addGroup(groupLayout.createParallelGroup()
                            .addComponent(jLabel_caption,GroupLayout.Alignment.CENTER)   //标题
                            .addComponent(usernameTextField)  //用户名文本框
                            .addComponent(passwordTextField)  //密码文本框
                            .addComponent(jPanel_command));
        hGroup.addGap(80);  //设置第2个水平组的Left（以像素为单位）
        //（2-2）创建垂直组对象并并作为分组布局对象的垂直组
        GroupLayout.SequentialGroup vGroup = groupLayout.createSequentialGroup();
        groupLayout.setVerticalGroup(vGroup);
        //添加基本组件至垂直组
        vGroup.addGap(60);  //设置相对窗体的Top（以像素为单位）
        vGroup.addGroup(groupLayout.createParallelGroup().addComponent(jLabel_caption));
        //vGroup.addComponent(jLabel_caption);
        vGroup.addGap(20);  //设置第2个垂直组的Top（以像素为单位）
        vGroup.addGroup(groupLayout.createParallelGroup()
                .addComponent(jLabel_username)
                .addComponent(usernameTextField));
        vGroup.addGap(5);  //设置第3个垂直组的Top（以像素为单位）
        vGroup.addGroup(groupLayout.createParallelGroup()
                .addComponent(jLabel_password)
                .addComponent(passwordTextField));
        vGroup.addGap(15); //设置第4个垂直组的Top（以像素为单位）
        vGroup.addGroup(groupLayout.createParallelGroup()
                .addComponent(jPanel_command));
        vGroup.addGap(100);
    }
    //定义窗体的业务操作方法
    void operation(){
        //登录按钮监听器
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("写登录逻辑");
            }
        });
        //重置按钮监听器
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //使用空格清空
                usernameTextField.setText(" ");
                passwordTextField.setText(" ");
            }
        });
        //复选框（选项）监听器
        checkbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(checkbox.isSelected());
            }
        });
    }
}
