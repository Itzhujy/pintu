package src.main.java.unit06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingUIDemo extends JFrame {
    static JTextField usernameTextField;  //文本框
    static JPasswordField passwordTextField;  //密码框
    static JButton loginButton, resetButton;  //登录与重置按钮
    static JCheckBox checkbox;   //复选框（记住用户名及密码）

    public SwingUIDemo(){  //构造方法
        setTitle("Swing UI示例");
        //设置窗体尺寸大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) screenSize.getWidth()/5, (int) screenSize.getHeight()/6);
        //设置窗口位置在屏幕中央
        setLocationRelativeTo(null);
        //设置窗体大小不可调节（默认是可调节）
        setResizable(true);
        //调用创建登录面板并添加至窗体方法
        createLoginPanel();
    }

    public static void main(String[] args) {  //主方法
        SwingUIDemo swingUI = new SwingUIDemo();
        swingUI.setVisible(true);
        swingUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //可省略

        //以下完成按钮的单击监听
        loginButton.addActionListener(e -> {
            //模拟后台数据库登录
            String un=usernameTextField.getText();
            String pwd=new String(passwordTextField.getPassword());
            if(un.equals("wzx") && pwd.equals("123456")){
                JOptionPane.showMessageDialog(null, "恭喜，登录成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                //当主窗体MainFrame创建后，放开取消如下2行代码的注释
                new MainFrame(usernameTextField.getText()); //登录成功后，进入主窗体
                swingUI.dispose();  //主动销毁当前的登录窗体
            }else{
                JOptionPane.showMessageDialog(null,"用户名或密码错误","错误提示",JOptionPane.ERROR_MESSAGE);
            }
        });
        resetButton.addActionListener(e -> {
            //清空文本框和密码框
            usernameTextField.setText("");
            passwordTextField.setText("");

        });
        checkbox.addActionListener(e -> {
            if (checkbox.isSelected()) {
                JOptionPane.showMessageDialog(null, "checked", "提示", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "unhecked", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    void createLoginPanel(){  //定义创建面板并添加至窗体方法
        //（1）创建登录的组件
        //（1-1）基本组件
        JLabel jLabel_caption = new JLabel("用户登录");
        jLabel_caption.setFont(new Font("黑体",Font.BOLD,16));
        JLabel jLabel_username = new JLabel("用户名：");
        usernameTextField = new JTextField("wzx");  //类字段，给了默认值
        JLabel jLabel_password = new JLabel("密    码：");
        passwordTextField = new JPasswordField("123456");  //类字段，给了默认值
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
        hGroup.addGap(120);  //设置水平间隔（以像素为单位），不设置，最初的水平组将位于窗体最左边
        hGroup.addGroup(groupLayout.createParallelGroup()  //对水平组添加包含2个组件的并行组
                .addComponent(jLabel_username)  //用户名标签
                .addComponent(jLabel_password)); //密码标签
        hGroup.addGap(10);
        hGroup.addGroup(groupLayout.createParallelGroup()
                .addComponent(jLabel_caption,GroupLayout.Alignment.CENTER) //表单标题在第2个水平组里居中
                .addComponent(usernameTextField)  //用户名文本框
                .addComponent(passwordTextField)  //密码文本框
                .addComponent(jPanel_command));   //命令面板
        hGroup.addGap(80);  //设置水平间隔。不设置，最后的水平组将延伸至窗体右边
        //（2-2）创建垂直组对象并并作为分组布局对象的垂直组
        GroupLayout.SequentialGroup vGroup = groupLayout.createSequentialGroup();
        groupLayout.setVerticalGroup(vGroup);
        //添加基本组件至垂直组
        vGroup.addGap(60);  //设置垂直间隔（以像素为单位），不设置，最初的垂直组将位于窗体最顶部
        vGroup.addGroup(groupLayout.createParallelGroup().addComponent(jLabel_caption));  //表单标题
        //vGroup.addComponent(jLabel_caption);  //顺序组只有一个组件时，不必创建并行组
        vGroup.addGap(20);
        vGroup.addGroup(groupLayout.createParallelGroup()
                .addComponent(jLabel_username)   //用户名标签
                .addComponent(usernameTextField));  //用户名文本框
        vGroup.addGap(15);
        vGroup.addGroup(groupLayout.createParallelGroup()
                .addComponent(jLabel_password)   //密码标签
                .addComponent(passwordTextField));  //密码文本框
        vGroup.addGap(20);
        vGroup.addGroup(groupLayout.createParallelGroup()
                .addComponent(jPanel_command));
        vGroup.addGap(100);
    }
}
