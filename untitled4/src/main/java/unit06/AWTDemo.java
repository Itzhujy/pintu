package main.java.unit06;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class AWTDemo extends Frame{
    //用于统计按钮单击次数
    static Button button;   //按钮
    static TextField textField;  //文本框
    static int count;  //计数

    AWTDemo(){  //构造方法
        setTitle("My AWT Frame");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //设置顶层容器大小，使用setSize()；设置面板等中间容器，使用 setPreferredSize()
        setSize((int)screenSize.getWidth()/3,(int)screenSize.getHeight()/4);
        setBackground(Color.pink);
        setLocationRelativeTo(null);
        //以下三行代码更改应用的图标
        URL url = Panel.class.getClass().getResource("/media/红十字.jpg");
        Image image=Toolkit.getDefaultToolkit().getImage(url);
        //setIconImage(image);  //更改窗体图标
        //在窗体的North位置，添加一个显示主题的面板
        Label label=new Label("drawing/display a picture");
        label.setFont(new Font("宋体", Font.BOLD, 30));
        Panel panel = new Panel();
        panel.add(label);
        add(panel,BorderLayout.NORTH);  //add(label,BorderLayout.NORTH);
        //在窗体的Center位置，绘图/显示一幅图像
        Panel panel_display=new Panel(new GridLayout(1,2));  //1行2列格点布局
        panel_display.add(new DrawingPanel());
        panel_display.add(new PicturePanel());
        add(panel_display,BorderLayout.CENTER);  //此面板只能放置CENTER，而不能在其它位置（如 WEST或EAST）
        //统计按钮单击次数
        Panel panel_count=new Panel();
        button=new Button("Hit me");
        button.setFont(new Font("宋体", Font.BOLD, 30)); //文字默认大小是12磅
        panel_count.add(button);
        textField=new TextField();
        textField.setFont(new Font("宋体", Font.BOLD, 30));
        panel_count.add(textField);
        textField.setText(String.valueOf(count));
        textField.setEnabled(false);  //禁用文本框
        textField.setColumns(3);
        add(panel_count,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        AWTDemo awtDemo = new AWTDemo();
        awtDemo.setVisible(true);  //设置窗体可见

        awtDemo.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        //按钮的单击事件方法，使用Lambda表达式，创建接口ActionListener类型的对象
        button.addActionListener(e -> {
            textField.setText(String.valueOf(++count));
        });
    }

    static class DrawingPanel extends Panel { //自定义内部类（手绘面板）用于绘图
        @Override
        public void paint(Graphics g) {
            g.setFont(new Font("楷体", Font.BOLD, 20));
            g.drawString("笑脸娃娃", 170, 30);  //插入文字
            g.setColor(Color.black);
            g.drawOval(130, 50, 190, 200);
            g.fillOval(165, 120, 20, 20); // 左眼
            g.fillOval(265, 120, 20, 20); // 右眼
            g.drawArc(155, 100, 40, 45, 45, 90); // 左眉
            g.drawArc(255, 100, 40, 45, 45, 90); // 右眉
            g.setColor(Color.red);
            g.drawArc(130, -65, 185, 255, -45, -90); // 口
            g.drawArc(130, -190, 185, 400, -45, -90); // 口
        }
    }

    static class PicturePanel extends Panel { //自定义内部类（图像面板）用于加载图像
        @Override
        public void paint(Graphics g) {
            //System.out.println("调用加载图像的paint()方法");  //paint()方法会被执行多次
            //要求图像文件放在项目文件夹resources里
            Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
            URL resource = Panel.class.getResource("/media/picture.jpg");
            Image image =defaultToolkit.getImage(resource);
            g.drawImage(image, 80, 40, 220, 220, this); //画一幅图像
        }
    }
}
