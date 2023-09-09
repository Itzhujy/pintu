package main.java.unit04;
import java.io.*;
/**
 * Java的文件操作通过流对象完成。本例演示了字节流与字符流的文件读写。
 * 使用字节数组（字节流）读写文件
 * Java程序中，字符编码使用2字节的 Unicode编码。
 * 不同的系统和平台以及出于节省空间的考虑，对 Unicode编码有的不同实现方式。
 * Unicode的实现方式称为 UTF( Unicode Transformation Format, Unicode转换格式)。
 * 在Windows+IDEA环境下，写入文件的长度=ASCII字符个数*1+中文字符*3+1（换行符）
 * Windows记事本程序编写的文本文件，汉字存储的是2字节的汉字内码。
 */
public class JavaIODemo02 {
    public static void main(String[] args) throws Exception{   //字节流IO
        //创建要写的目标文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream(new File("d:\\hello.txt"));
        //从键盘读入数据并存放至字节数据
        byte[] b=new byte[128];
        System.out.print("请输入一串字符并回车：");
        int len = System.in.read(b); //返回输入的字符（包括换行符）对应的字节输入流长度
        System.out.println("写入的文件长度（含换行符）："+len);
        //写入
        fileOutputStream.write(b,0,len);  //有效长度
        //fileOutputStream.write(b);  //写入全部数组
        fileOutputStream.flush();  //必须
        //关闭流对象
        fileOutputStream.close();

        System.out.print("请输入一串字符并回车：");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));  //缓冲字符流
        String readLine = bufferedReader.readLine();  //等待输入
        System.out.println("读入的字符串长度（不含换行）："+readLine.length());
        FileWriter fileWriter = new FileWriter(new File("d:\\hello2.txt"));
        fileWriter.write(readLine);
        fileWriter.flush();  //必须
        fileWriter.close();
        bufferedReader.close();
        //结果表明：输入同样的字符串，文件hello1.txt的大小=hello2.txt的大小+1
    }
}
