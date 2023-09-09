package src.main.java.unit06;
import java.awt.*;
import java.awt.event.*;

/**
 * 使用AWT的BorderLayout和GridLayout设计用户登录界面
 * 由于IDEA中AWT GUI组件默认情况下会出现中文乱码，因此，界面使用英文
 * 对Frame应用BorderLayout，对Panel应用GridLayout，将3个Panel分别定位在
 *   BorderLayout.NORTH、BorderLayout.CENTER和BorderLayout.SOUTH
 *   在BorderLayout.CENTER处Panel的内容不多，为了紧凑，将窗体高度设置较小
 */
public class AWTBorderAndGridAndFlowLayoutDemo extends Frame {
    TextField usernameTextField, passwordTextField;
    Button loginButton, resetButton;  //登录与重置按钮
    Checkbox checkbox;   //复选框（记住用户名及密码）
    //窗体程序运行入口
    public static void main(String[] args) {
        new AWTBorderAndGridAndFlowLayoutDemo();
    }
    //窗体类的构造方法
    AWTBorderAndGridAndFlowLayoutDemo() {
        setTitle("Border+Grid+Flow Layout Demo");
        //设置窗体尺寸大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)screenSize.getWidth()/5,(int)screenSize.getHeight()/8);
        //设置窗口位置在屏幕中央
        setLocationRelativeTo(null);
        //设置窗口大小不可调节（默认是可调节）
        setResizable(false);
        //调用创建面板并添加至窗体方法
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
    //定义创建登录面板并添加至窗体方法
    public void createLoginPanel(){
        //创建第1个面板并添加到窗体 BorderLayout.NORTH
        Panel panel1 = new Panel();
        Label label = new Label("User Login");
        label.setFont(new Font("宋体",Font.BOLD,18));
        panel1.add(label);
        add(panel1, BorderLayout.NORTH);  //添加至窗体
        //创建第2个面板并添加到窗体 BorderLayout.CENTER
        Panel panel2 = new Panel();
        panel2.setLayout(new GridLayout(2, 1));  //设置格点布局
        Panel panelUsername = new Panel();  //面板
        Label labelUsername = new Label("username:");
        labelUsername.setFont(new Font("宋体",Font.BOLD,16));
        panelUsername.add(labelUsername);
        usernameTextField = new TextField(15);
        panelUsername.add(usernameTextField);
        panel2.add(panelUsername);
        Panel panelPassword = new Panel();  //面板
        Label labelPassword = new Label("password:");
        labelPassword.setFont(new Font("宋体",Font.BOLD,16));
        panelPassword.add(labelPassword);
        passwordTextField = new TextField(15);
        passwordTextField.setEchoChar('*');  //设置回显字符
        panelPassword.add(passwordTextField);
        panel2.add(panelPassword);
        add(panel2, BorderLayout.CENTER);
        //创建第3个面板并添加到窗体 BorderLayout.SOUTH，面板使用默认的流式布局、内包含2个按钮和1个复选框
        Panel panel3 = new Panel();
        loginButton = new Button("Sure");
        loginButton.setFont(new Font("宋体",Font.BOLD,16));
        panel3.add(loginButton);
        resetButton = new Button("Reset");
        resetButton.setFont(new Font("宋体",Font.BOLD,16));
        panel3.add(resetButton);
        checkbox=new Checkbox("Remember me");
        checkbox.setFont(new Font("宋体",Font.BOLD,16));
        panel3.add(checkbox);
        add(panel3, BorderLayout.SOUTH);
    }
    //定义窗体的业务操作方法
    public void operation(){
        //登录按钮监听器
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //写登录逻辑
            }
        });
        //重置按钮监听器
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                usernameTextField.setText(" ");  //使用空格清空
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
