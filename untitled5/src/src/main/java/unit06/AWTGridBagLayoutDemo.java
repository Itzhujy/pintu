package src.main.java.unit06;

import java.awt.*;
import java.awt.event.*;

/**
 * AWT网格袋布局 AWTGridBagLayoutDemo
 * 网格袋布局(GridBagLayout)是最灵活的，也是最复杂的一种，适合复杂界面的布局
 * 区别于网格布局，网格袋布局里每个网格的宽高度可以不一样；每个组件可以占据一个或多个网格；
 * 可以指定组件在网格中的位置
 */
public class AWTGridBagLayoutDemo extends Frame {
    TextField usernameTextField, passwordTextField;
    Button loginButton, resetButton;  //登录与重置按钮
    Checkbox checkbox;   //复选框（记住用户名及密码）
    //程序运行入口
    public static void main(String args[]) {
        new AWTGridBagLayoutDemo();
    }
    //窗体类的构造方法
    public AWTGridBagLayoutDemo() {
        setTitle("GridBagLayout Demo");
        //设置窗体尺寸大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) screenSize.getWidth()/5, (int) screenSize.getHeight()/6);
        //设置窗口位置在屏幕中央
        setLocationRelativeTo(null);
        //设置窗体大小不可调节（默认是可调节）
        setResizable(false);
        //调用创建登录面板并添加至窗体方法
        createLoginPanel();
        //添加关闭窗体操作
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //调用窗体的业务操作方法
        operation();
        //设置窗体内组件可见（默认不可见）
        setVisible(true);
    }
    //定义创建面板并添加至窗体方法
    public void createLoginPanel(){
        Panel loginPanel = new Panel();
        loginPanel.setLayout(new GridBagLayout());  //对面板应用网格袋布局
        add(loginPanel,BorderLayout.CENTER);  //添加登录面板至窗体中央
        //创建登录面板内的各个组件及其约束
        //（1）面板标题
        Label captionLabel = new Label("User Login");
        captionLabel.setFont(new Font("宋体",Font.BOLD,16));
        GridBagConstraints captionLabelConstraints = new GridBagConstraints();
        captionLabelConstraints.gridy=0;
        captionLabelConstraints.gridx=0;
        captionLabelConstraints.gridwidth=3;
        captionLabelConstraints.insets=new Insets(0,0,25,0);
        loginPanel.add(captionLabel,captionLabelConstraints);
        //（2）用户名标签
        Label usernameLabel = new Label("username:");
        GridBagConstraints usernameLabelConstraints = new GridBagConstraints();
        usernameLabelConstraints.gridy=1;
        usernameLabelConstraints.gridx=0;
        usernameLabelConstraints.anchor = GridBagConstraints.WEST;   //左对齐（默认居中）
        loginPanel.add(usernameLabel,usernameLabelConstraints);
        //（3）类字段 usernameTextField
        usernameTextField = new TextField(15);
        GridBagConstraints usernameTextFieldConstraints = new GridBagConstraints();
        usernameTextFieldConstraints.gridy=1;
        usernameTextFieldConstraints.gridx=1;
        usernameTextFieldConstraints.gridwidth=2;
        usernameTextFieldConstraints.fill=GridBagConstraints.HORIZONTAL;
        loginPanel.add(usernameTextField,usernameTextFieldConstraints);
        //（4）密码标签
        Label passwordLabel = new Label("password:");
        GridBagConstraints passwordLabelConstraints = new GridBagConstraints();
        passwordLabelConstraints.gridy=2;
        passwordLabelConstraints.gridx=0;
        passwordLabelConstraints.anchor = GridBagConstraints.WEST;   //左对齐（默认居中）
        loginPanel.add(passwordLabel,passwordLabelConstraints);
        //（5）类字段 passwordTextField
        passwordTextField = new TextField(15);
        passwordTextField.setEchoChar('*');  //设置回显字符
        GridBagConstraints passwordTextFieldConstraints = new GridBagConstraints();
        passwordTextFieldConstraints.gridy=2;
        passwordTextFieldConstraints.gridx=1;
        passwordTextFieldConstraints.gridwidth=2;
        passwordTextFieldConstraints.fill=GridBagConstraints.HORIZONTAL;
        loginPanel.add(passwordTextField,passwordTextFieldConstraints);
        //（6）登录按钮
        loginButton = new Button("Sure");
        loginButton.setFont(new Font("宋体",Font.BOLD,14));
        GridBagConstraints loginButtonConstraints = new GridBagConstraints();
        loginButtonConstraints.gridy=3;
        loginButtonConstraints.gridx=0;
        loginButtonConstraints.insets=new Insets(30,20,0,0);
        loginPanel.add(loginButton,loginButtonConstraints);
        //（7）重置按钮
        resetButton = new Button("Reset");
        resetButton.setFont(new Font("宋体",Font.BOLD,14));
        GridBagConstraints resetButtonConstraints = new GridBagConstraints();
        resetButtonConstraints.gridy=3;
        resetButtonConstraints.gridx=1;
        resetButtonConstraints.insets=new Insets(30,10,0,0);
        loginPanel.add(resetButton,resetButtonConstraints);
        //（8）记住复选框
        checkbox=new Checkbox("Remember me");
        checkbox.setFont(new Font("宋体",Font.BOLD,14));
        GridBagConstraints checkboxConstraints = new GridBagConstraints();
        checkboxConstraints.gridy=3;
        checkboxConstraints.gridx=2;
        checkboxConstraints.insets=new Insets(30,10,0,0);
        loginPanel.add(checkbox,checkboxConstraints);
    }
    //定义窗体的业务操作方法
    public void operation(){
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
                System.out.println(checkbox.getState());
            }
        });
    }
}
