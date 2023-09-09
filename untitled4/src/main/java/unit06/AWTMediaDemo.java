package main.java.unit06;

import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 使用AWT显示图像、播放音乐
 * 要点：
 * （1）图像位于面板里，面板添加至窗体里
 * （2）获取默认工具包：Toolkit.getDefaultToolkit()，创建 Image对象
 * （3）播放音频，需要使用类加载器加载资源（不同于显示图像）
 */
public class AWTMediaDemo extends Frame {  //定义窗体
    private Dimension screenSize;  //屏幕尺寸
    private Button playButton;  //播放按钮

    public static void main(String[] args) {
        new AWTMediaDemo("使用AWT显示图像、播放音乐");
    }

    AWTMediaDemo(String titlename) {  //构造方法
        //重设窗体图标
        URL url = getClass().getResource("/media/红十字.jpg");  //在media前，必须加斜杠！
        Image image = Toolkit.getDefaultToolkit().getImage(url);  //使用AWT UI工具包
        setIconImage(image);
        //设置窗体标题
        setTitle(titlename);
        //设置窗体大小
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new Dimension((int) this.screenSize.getWidth() / 3, (int) this.screenSize.getHeight() / 3));
        //设置窗体背景
        setBackground(Color.LIGHT_GRAY);
        //设置窗体位置
        setLocationRelativeTo(null);
        //面板默认使用流式布局，窗体默认使用边界布局，添加面板至窗体底部
        Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        playButton = new Button("Play Music");
        playButton.setForeground(Color.GREEN);  //设置前景色
        playButton.setFont(new Font("宋休",Font.BOLD,16));  //设置字体及大小
        playButton.setEnabled(false);  //禁用
        buttonPanel.add(playButton);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playButton.setEnabled(false);  //禁用
                    playSound("media/ForElise.wav");   //在media前，不能加斜杠！
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        add(buttonPanel, BorderLayout.SOUTH);  //添加面板至窗体
        //监听窗体关闭
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {  //重写方法 windowClosing()
                super.windowClosing(e);
                System.exit(0);
            }
        });
        //设置窗体可见
        setVisible(true);
        //在主线程上，播放背景音乐（Frame不支持多线程）
        try {
            playSound("media/ForElise.wav");   //在media前，不能加斜杠！
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    //在窗体上绘制一幅图像
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/media/tiantang.jpg"));
        int imgWidth = getWidth() * 2 / 3;
        int imgHeight = getHeight() * 2 / 3;
        int startX = getWidth() / 3 / 2;  //起始点横坐标
        int startY = getHeight() / 3 / 2;
        g.drawImage(image, startX, startY, imgWidth, imgHeight, this);
    }

    public void playSound(String filename) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        //加载音频文件与加载图像文件不同，需要通过类加载器获取资源流
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);  //缓冲流
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedInputStream);

        AudioFormat audioFormat = audioStream.getFormat();
        SourceDataLine sourceLine = (SourceDataLine) AudioSystem.getLine(new DataLine.Info(SourceDataLine.class, audioFormat));
        sourceLine.open(audioFormat);
        sourceLine.start();  //播放
        int nBytesRead = 0;
        int BUFFER_SIZE = 128000;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1 ) {
            nBytesRead = audioStream.read(abData, 0, abData.length);
            if (nBytesRead >= 0) sourceLine.write(abData, 0, nBytesRead);
        }
        sourceLine.drain();
        sourceLine.close();
        playButton.setEnabled(true);  //启用
    }
}
