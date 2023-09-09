package main.java.unit04;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * 在控制台用“*”输出一个5行倒立的等边三角型，并写到文件triangle.txt中。
 * Java IO操作都是流的操作，System.in和System.out是设备文件（流）。
 * 打印流PrintStream是过滤输出流FilterOutputStream的子类，能方便地打印各种类型的数据。
 * 本程序的 PrintStream对象，也可替换成 PrintWriter对象。
 * 1）共同点: PrintStream和PrintWriter都能输出各种形式的数据，方法也几乎相同，PrintWriter多了个接受 Writer参数。
 * 2）不同点：PrintStream面向字节；PrintWriter面向字符，且还有字符编码的问题。
 */
public class TriangleAndTextFile {
    public static void main(String[] args) throws Exception {

        //创建拟写入的文件输出流对象。未指定路径时，将写入项目根路径。
        FileOutputStream fileOutputStream = new FileOutputStream("triangle.txt");
        //创建输出到文件的打印流对象
        PrintStream printStream = new PrintStream(fileOutputStream);
        //PrintStream printStream = new PrintStream(fileOutputStream,true); //第2参数表示 autoFlush
        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        int n = 5;  //行数
        int i, j;  //循环变量
        for (i = 0; i < n; i++) {
            for (j = 0; j < i; j++) {  //输出第i行*前，需要空i个空格
                System.out.print(" ");  //输出到控制台
                printStream.print(" ");  //输出（写入文件，不会打印到控制台）
            }
            for (j = 0; j < 2 * (n - i) - 1; j++) {
                System.out.print("*");
                printStream.print("*");
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
    }

    @Test
    public void printTriangleFromTextFile() throws Exception{
        //1、创建文件字符输入流（不是键盘）
        FileReader fileReader = new FileReader("triangle.txt");
        //2、创建字符打印流（屏幕）
        PrintWriter printWriter = new PrintWriter(System.out);
        //3、读写操作
        char[] chars=new char[1024];  //数组大小任意
        int len=fileReader.read(chars);
        while (len!=-1){
            for(char c:chars){
                printWriter.print(c);
            }
            len=fileReader.read(chars);
        }
        //4、关闭流
        printWriter.close();
        fileReader.close();
    }

    @Test
    public void printTriangleFromTextFile2() throws Exception{
        //1、创建缓冲文件字符输入流（不是键盘）
        FileReader fileReader = new FileReader("triangle.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        //2、创建字符打印流（屏幕）
        PrintWriter printWriter = new PrintWriter(System.out);
        //3、读写操作
        String readLine;
        while ((readLine = bufferedReader.readLine())!=null){
            printWriter.println(readLine);  //方法 readLine()以行为单位读取，不包括回车（换行）
        }
        //4、关闭流
        printWriter.close();
        fileReader.close();
    }
}
