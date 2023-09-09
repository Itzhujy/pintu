package src.main.java.unit06;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {

    public MyFrame() {  //构造方法
        setTitle("MyFrame");
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = defaultToolkit.getScreenSize();
        setSize((int)screenSize.getWidth()/3,(int)screenSize.getHeight()/3);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        myFrame.setBackground(Color.RED);
        myFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}
