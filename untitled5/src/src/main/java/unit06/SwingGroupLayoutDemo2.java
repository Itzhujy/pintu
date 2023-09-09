package src.main.java.unit06;

import javax.swing.*;

public class SwingGroupLayoutDemo2 {
    public static void main(String[] args) {
        //窗口
        JFrame loginFrame = new JFrame("登录界面");
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //面板
        JPanel panel = new JPanel();
        //布局
        GroupLayout groupLayout = new GroupLayout(panel);
        panel.setLayout(groupLayout);

        //组件
        JLabel titleLabel = new JLabel("用户登录");
        JLabel usernameLabel = new JLabel("账号：");
        JLabel passwordLabel = new JLabel("密码：");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        JButton loginButton = new JButton("登录");
        JButton resetButton = new JButton("重置");

        //自动添加组件之间的间隙
        groupLayout.setAutoCreateGaps(true);
        //自动添加组件与容器的间隙
        groupLayout.setAutoCreateContainerGaps(true);

        //设置水平组：每行作为一个子组后（如果有多个组件的话），顺序添加子组或组件到水平组
        /* 水平并行(上下) 账号密码标签 */
        GroupLayout.ParallelGroup paralGroupLabel = groupLayout.createParallelGroup()
                .addComponent(usernameLabel)
                .addComponent(passwordLabel);
        /* 水平并行(上下) 账号密码输入框 */
        GroupLayout.ParallelGroup paralGroupField = groupLayout.createParallelGroup()
                .addComponent(usernameField)
                .addComponent(passwordField);
        /* 水平串行(左右) 账号密码标签和输入框 */
        GroupLayout.SequentialGroup seqHorGroupInput = groupLayout.createSequentialGroup().
                addGroup(paralGroupLabel)
                .addGroup(paralGroupField);
        /* 水平串行(左右) 登录重置按钮 */
        GroupLayout.SequentialGroup seqHorGroupBtn = groupLayout.createSequentialGroup()
                .addComponent(loginButton)
                .addComponent(resetButton);
        /* 水平并行(上下) 标题、账号密码、按钮 */
        GroupLayout.ParallelGroup paralHorGroup = groupLayout.createParallelGroup()
                .addComponent(titleLabel, GroupLayout.Alignment.CENTER)
                .addGroup(seqHorGroupInput)
                .addGroup(GroupLayout.Alignment.CENTER, seqHorGroupBtn);
        /* 设置分组布局的水平组 */
        groupLayout.setHorizontalGroup(paralHorGroup);

        /**
         * 垂直组（仅确定 Y 轴方向的坐标/排列方式）
         *
         * 垂直串行: 垂直排列（上下排列）
         * 垂直并行: 水平排列（左右排列）
         */
        /* 垂直并行（左右）账号标签和输入框 */
        GroupLayout.ParallelGroup paralGroupUsername = groupLayout.createParallelGroup()
                .addComponent(usernameLabel)
                .addComponent(usernameField);
        /* 垂直并行（左右）密码标签和输入框 */
        GroupLayout.ParallelGroup paralGroupPassword = groupLayout.createParallelGroup()
                .addComponent(passwordLabel)
                .addComponent(passwordField);
        /* 垂直并行（左右）登录按钮和重置按钮 */
        GroupLayout.ParallelGroup paralGroupButton = groupLayout.createParallelGroup()
                .addComponent(loginButton)
                .addComponent(resetButton);
        /* 垂直串行（上下）标题、账号、密码、按钮 */
        GroupLayout.SequentialGroup seqVerGroup = groupLayout.createSequentialGroup()
                //.addGap(30)  //设置top
                .addComponent(titleLabel).addGroup(paralGroupUsername)
                .addGroup(paralGroupPassword)
                .addGroup(paralGroupButton);
        /* 设置分组布局的垂直组 */
        groupLayout.setVerticalGroup(seqVerGroup);

        /* 设置内容面板 */
        loginFrame.setContentPane(panel);
        /* 自动计算窗口大小并调整 */
        loginFrame.pack();
        /* 窗口位于屏幕中间（居中） */
        loginFrame.setLocationRelativeTo(null);
        /* 窗口可视化 */
        loginFrame.setVisible(true);
    }
}
