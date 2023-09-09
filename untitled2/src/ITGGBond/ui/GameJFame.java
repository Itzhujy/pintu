package ITGGBond.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFame extends JFrame implements KeyListener, ActionListener {
    //记录空白方块在二维数组中的位置
    int x = 0;
    int y = 0;
    int[][]data=new int[4][4];
    String path="images\\livei\\";
    //定义一个数组，存储正确的数据
    int [][]win = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0},
    };
    //定义变量来统计步数
    int step = 0;

    //创建选项下面的条目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem accountItem = new JMenuItem("公众号");

    public GameJFame(){
        //初始化界面
        initJFrame();
        //初始化菜单
        initJMenuBar();
        //初始化数据
        initData();
        //初始化图片
        initImage();


        //显示出来
        this.setVisible(true);
    }


    private void initData() {
        //1.定义一个一维数组
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        //打乱顺序
        Random r=new Random();
        for(int i=0;i<tempArr.length;i++)
        {
            int index=r.nextInt(tempArr.length);
            int temp=tempArr[i];
            tempArr[i]=tempArr[index];
            tempArr[index]=temp;
        }
          //给二维数组添加数据
        for(int i=0;i<tempArr.length;i++)
        {
            if (tempArr[i]==0) {
                x=i/4;
                y=i%4;
            }
            data[i/4][i%4]=tempArr[i];
        }

    }

    //初始化图片
    private void initImage() {
        //清空原本已经出现的图片
        this.getContentPane().removeAll();

        if(victory()){
            JLabel wins = new JLabel("游戏胜利");
            wins.setBounds(360,100,500,500);
            this.getContentPane().add(wins);
        }

        JLabel stepCount=new JLabel("步数"+step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);

        //外循环把内循环重复执行4次
        for(int i=0;i<4;i++) {
            //表示一行添加四张图片

            for (int j = 0; j < 4; j++) {
                int num=data[i][j];
                //创建一个图片ImageIcon的对象
                //ImageIcon icon = new ImageIcon();
                //创建一个JLabel的对象（管理容器）
                JLabel jLabel1 = new JLabel(new ImageIcon(path+""+num+".jpg"));
                //指定图片位置
                jLabel1.setBounds(105 * j+180, 105 * i+134, 105, 105);
                //把管理容器添加到界面当中
                //this.add(jLabel);
                //给图片添加边框
                jLabel1.setBorder(new BevelBorder(0));//0:表示凸起来1：表示凹下去
                this.getContentPane().add(jLabel1);
                //刷新一下界面
                this.getContentPane().repaint();
            }
        }

    }


    private void initJMenuBar() {
        //初始化菜单
        //创建整个的菜单对象
        JMenuBar jMenuBar=new JMenuBar();

        //创建菜单上两个选项的对象（功能 关于我们）
        JMenu functionJMenu=new JMenu("功能");
        JMenu aboutJMenu=new JMenu("关于我们");



        //给条目绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        //创建选项下面的条目添加到选项当中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //将菜单里的两个选项添加到菜单里
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置界面的宽高
        this.setSize(800,800);
        //设置界面的标题
        this.setTitle("拼图单机版 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null) ;
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //关闭默认居中
        this.setLayout(null);
        //给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    //按下不松时调用该方法
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == 65){
            //把图片中所有的图片删除
            this.getContentPane().removeAll();
            //加载完整的图片
            JLabel all = new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(150,134,420,420);
            this.getContentPane().add(all);
            this.getContentPane().repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(victory()){
            //1.返回结果 2.结束方法，void不需要返回结果
            return;
        }
        //左37，上38，右39，下40
        int code = e.getKeyCode();
        if(code == 37){
            if(y==3){
                return;
            }
            System.out.println("向左移动");
            data[x][y]=data[x][y+1];
            data[x][y+1]=0;
            y++;
            step++;
            initImage();
        }else if(code == 38){
            if(x==3){
                return;
            }
            System.out.println("向上移动");
            data[x][y]=data[x+1][y];
            data[x+1][y]=0;
            x++;
            step++;
            initImage();
        }else if(code == 39){
            if(y==0){
                return;
            }
            System.out.println("向右移动");
            //把空白方块下方的数字赋值给空白方块
            data[x][y]=data[x][y-1];
            data[x][y-1]=0;
            y--;
            step++;
            initImage();
        }else if(code == 40){
            if(x==0){
                return;
            }
            System.out.println("向下移动");
            data[x][y]=data[x-1][y];
            data[x-1][y]=0;
            x--;
            step++;
            initImage();
        }else if(code == 65){
            initImage();
        }else if(code == 87){
            data = new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0},
            };
            initImage();
        }


    }


    //判断data数组中的数据是否跟win相同
    //如果全部相同，返回true，否则false
    public boolean victory(){
        for(int i = 0;i<data.length;i++){
            for(int j =0;j<data[i].length;j++){
                if (data[i][j] != win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取当前被点击的条目对象
        Object obj = e.getSource();
        //判断
        if(obj == replayItem){
            //步数清零
            step=0;
            //打乱图片
            initData();
            //加载图片
            initImage();

        }else if(obj == reLoginItem){
            //关闭当前游戏的界面
            this.setVisible(false);
            //打开登录界面
            new LoginJFame();

        }else if(obj == closeItem){
            System.exit(0);

        }else if(obj == accountItem){

        }
    }
}
