package main.java.unit04;
import org.junit.Test;
import java.io.*;

public class ByteStreamIODemo {   //字节流示例
    public static void main(String[] args) throws Exception{
        /**
         * 字节流IO要点：
         * 1. InputStream和OutStream表示抽象类的字节流，分别定义了字节（数组）的读写的抽象方法 read()和 write()。
         *    1.1 InputStream也提供了用于读数据、可重载的实例方法read()。无参时，读写1个字节；方法read()返回值为-1时，表示无数据可读。
         *    1.2 InputStream也定义了获取字节输入流长度的实例方法 available()
         *    1.3 OutStream也提供了用于读数据、可重载的实例方法write()，。
         * 2. 作为抽象字节流的子类，可分为字节节点流和字节过滤器流。
         *    2.1 字节节点流，有文件字节流、字节数组流、对象字节流和管道字节流等。
         *    2.2 过滤器流，用于实现特定功能，主要要数据流、缓冲流和打印流。
         * 3. DataInputStream和BufferedInputStream都是类FilterInputStream的子类
         *    FilterInputStream表示字节过滤输入流，通过定义protected修饰的方法，为子类（装饰类）提供一个标准框架。
         *    3.1 DataInputStream表示数据字节输入流，提供对基本数据类型和字符串类型数据的读写能力。
         *    3.2 BufferedInputStream表示缓冲字节输入流，提供使用缓冲区读写文件的能力（减少对文件读写的请求次数）。
         *
         *  示例：
         *  1. testAnyFileCopy()：使用字节流复制任意文件
         *  2.
         */
    }

    @Test
    public void testAnyFileCopy() throws Exception{  //使用字节流复制任意文件
        //创建分别代表源文件和目标文件的2个File对象
        File file1 = new File("d:/media/music/white.mp3");
        File file2 = new File("d:/media/music/white2.mp3");
        //创建文件字节流对象，面向抽象编程（左边是抽象类，右边是子类）
        InputStream fis = new FileInputStream(file1);  //输入流
        OutputStream fos = new FileOutputStream(file2);  //输出流

        System.out.println("正在拷贝，请稍后...");
        long startTime = System.currentTimeMillis(); //开始时间
        //方式一：指定字节数组大小为文件长度，一次性读取全部文件内容
        byte[] bytes = new byte[fis.available()];  //定义字节数组，大小为文件长度
        fis.read(bytes);  //读
        fos.write(bytes);  //写
        //方式二：指定字节数组大小为 1024，而不是为文件长度
        /*byte[] bytes = new byte[1024];
        int len;
        while ((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }*/
        long endTime = System.currentTimeMillis(); //结束时间
        System.out.println("耗时" + (endTime - startTime) + "毫秒");
        System.out.println("拷贝完成。");

        //释放资源
        fos.close();
        fis.close();
    }

    @Test
    public void testBufferedStreamAsFilterStream() throws Exception{  //测试缓冲字节流
        File file1 = new File("d:/media/music/white.mp3");
        File file2 = new File("d:/media/music/white2.mp3");
        long startTime,endTime;  //记录起止时间
        byte[] bytes = new byte[1024];  //定义字节数组
        int len;  //读写字节长度

        InputStream bfis = new BufferedInputStream(new FileInputStream(file1));
        OutputStream bfos = new BufferedOutputStream(new FileOutputStream(file2));
        System.out.println("使用缓冲流拷贝，请稍后...");
        startTime = System.currentTimeMillis(); //开始时间
        while ((len=bfis.read(bytes))!=-1){
            bfos.write(bytes,0,len);
        }
        endTime = System.currentTimeMillis(); //结束时间
        System.out.println("拷贝完成。耗时" + (endTime - startTime) + "毫秒");
        bfis.close();bfos.close();  //释放资源

        System.out.println("------------------------");
        InputStream fis = new FileInputStream(file1);
        OutputStream fos = new FileOutputStream(file2);
        System.out.println("不使用缓冲流拷贝，请稍后...");
        startTime = System.currentTimeMillis(); //开始时间
        while ((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        endTime = System.currentTimeMillis(); //结束时间
        System.out.println("拷贝完成。耗时" + (endTime - startTime) + "毫秒");
        fis.close();fos.close();  //释放资源
    }

    /**
     * 打印流PrintStream是处理流，是对字节流OutputStream的封装
     * 数据流DataInputStream和DataOutputStream也是处理流，用法类似于PrintStream
     * 本方法测试打印流PrintStream到文件字节流的使用
     */
    @Test
    public void triangleToFile() throws Exception{
        //创建拟写入的文件输出流对象。未指定路径时，将写入项目根路径。
        OutputStream fileOutputStream = new FileOutputStream("triangle.txt");
        //创建输出到文件的打印流对象
        PrintStream printStream = new PrintStream(fileOutputStream);
        //PrintStream printStream = new PrintStream(fileOutputStream,true,"UTF-8");
        //PrintStream printStream = new PrintStream(fileOutputStream,true); //第2参数表示 autoFlush
        int rows = 5;  //行数
        char ch = '*';
        int i, j;  //循环变量
        for (i = 0; i < rows; i++) {
            for (j = 0; j < i; j++) {  //输出第i行*前，需要空i个空格
                System.out.print(" ");  //输出到控制台
                printStream.print(" ");  //输出（写入文件，不会打印到控制台）
            }
            for (j = 0; j < 2 * (rows - i) - 1; j++) {
                System.out.print(ch);
                printStream.print(ch);
            }
            for (j = 0; j < i - 1; j++) {
                System.out.print(" ");
                printStream.print(" ");
            }
            System.out.println(" ");
            printStream.println(" ");
        }
        printStream.flush();  //也可在构造方法的第2参数指定true实现autoFlush
        printStream.close();
        //验证方法：在Windows里直接打开该文件。
    }

    @Test
    public void fileToScreen() throws Exception{  //以字节流方式，读取信息并输出到屏幕
        //创建文件输入流对象（节点流）
        InputStream fis = new FileInputStream("triangle.txt");
        //创建缓冲字符输入流对象，从文本文件逐行读取并输出
        /*BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String str;
        while((str = br.readLine()) != null){
            System.out.println(str);
        }*/
        //PrintStream printStream = new PrintStream(System.out);
        PrintStream printStream = new PrintStream(System.out,true,"GBK");

        byte[] bytes = new byte[fis.available()];
        //输出有多种方式
        printStream.println(new String(bytes));
        /*fis.read(bytes);
        for(byte b:bytes){
            printStream.print((char)b);
        }*/
        //System.out.println(new String(bytes));

        printStream.close();
        fis.close();
    }


    @Test
    public void fileCopyWithBuffered() throws Exception{

        //创建文件输入流（字节流）对象，面向抽象编程
        //InputStream fis = new FileInputStream("c:/media/music/white.mp3");
        InputStream fis = new FileInputStream("c:/temp/附件：《Java EE开发技术》宣传片V1.mp4");
        BufferedInputStream bfis = new BufferedInputStream(fis);
        //OutputStream fos = new FileOutputStream("d:/media/music/white2.mp3");
        OutputStream fos = new FileOutputStream("c:/temp/附件：《Java EE开发技术》宣传片V2.mp4");
        BufferedOutputStream bfos = new BufferedOutputStream(fos);

        //读写操作
        System.out.println("正在拷贝，请稍后...");
        long startTime = System.currentTimeMillis(); //开始时间
        byte[] bytes = new byte[1024];  //指定字节数组大小为1024，而不是为文件长度
        int len;
        while ((len=bfis.read(bytes))!=-1){
            bfos.write(bytes,0,len);
        }
        long endTime = System.currentTimeMillis(); //结束时间
        System.out.println("耗时" + (endTime - startTime) + "毫秒");
        System.out.println("拷贝完成。");

        //释放资源（有先后顺序）；关闭外层的处理流，内部的节点流自动关闭。
        bfos.close();
        bfis.close();
    }

    @Test
    public void testDataStreamAsFilterStream() throws Exception{  //测试作为过滤器流的数据流
        //向上转型（面向抽象编程）
        OutputStream fos = new FileOutputStream("myData.dat");
        //装饰底层流（字节流）得到高层流（数据流）。此处，不能将 DataOutputStream 向上转型为 FliterOutputStream
        DataOutputStream dos = new DataOutputStream(fos);
        //写数据
        dos.writeUTF("张三");
        dos.writeInt(7500);
        dos.writeDouble(3.14159);
        dos.writeChar('A');
        dos.close();  //关闭高层流时将自动关闭底层流
        //文件myData.dat使用Windows记事本程序打开时，将会有乱码（思考为什么？）。

        //读取数据流时，需要与写入的数据流对应
        DataInputStream dis = new DataInputStream(new FileInputStream("myData.dat"));
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        dis.close();
    }

    @Test
    public void testObjectStream() throws Exception{  //测试对象流
        OutputStream fos = new FileOutputStream("bookInfo.dat");  //创建文件输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(fos);  //创建对象输出流对象
        oos.writeUTF("Java程序设计简明教程");
        oos.writeInt(45);
        oos.close();
        //运行后，查看文件bookInfo.dat的大小，并使用 hexdump查看

        InputStream fis=new FileInputStream("bookInfo.dat");
        ObjectInputStream ois=new ObjectInputStream(fis);
        //获取对象输入流，要与对象输出流对应。
        System.out.println(ois.readUTF());
        System.out.println(ois.readInt());
        ois.close();
    }
}
