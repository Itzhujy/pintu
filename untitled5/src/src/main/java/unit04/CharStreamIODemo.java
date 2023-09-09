package src.main.java.unit04;

import org.junit.Test;
import java.io.*;

public class CharStreamIODemo {
    public static void main(String[] args) throws Exception{
        /**
         * 字符流IO知识要点：
         * 字符流InputStreamReader（OutputStreamWriter）是抽象类Reader的子类，具有字符读写能力。
         * FileWriter（FileReader）是类OutputStreamWriter（FileWriter）的子类。
         * 文件字符流 FileReader和 FileWriter较字符流而言，增加了文件读写能力。
         * 缓冲字符流 BufferedRead，可以逐行读取字符。
         * PrintWriter用于包装输出字符流类对象，可以向该字符流中写入Java基本数据类型和字符串类型。
         * 示例程序：
         * 1. testAnyFileCopy()：使用字节流复制任意文件
         * 2.
         */
        //下面的代码，不能写在单元测试里。使用缓冲字符输入流。
        System.out.print("请输入一串字符，以回车键结束：" );
        InputStreamReader isr = new InputStreamReader(System.in);  //键盘字节输入流
        BufferedReader br = new BufferedReader(isr);  //缓冲字符流
        String str = br.readLine();  //整行读取
        System.out.printf("你输入了%d个字符，内容是：%s",str.length(),str);
        br.close(); //关闭输入流
        System.out.println();

        //使用文件字符输出流写文本文件
        long startTime=System.currentTimeMillis();
        FileWriter fw = new FileWriter("myText.txt");
        fw.write(str);
        fw.close();
        long endTime=System.currentTimeMillis();
        System.out.printf("不使用缓冲，花费时间：%d秒",(endTime-startTime));
        System.out.println();

        //使用缓冲字符输出流写文本文件
        startTime=System.currentTimeMillis();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("myText.txt")));
        bw.write(str);
        fw.close();
        endTime=System.currentTimeMillis();
        System.out.printf("使用缓冲，花费时间：%d秒",(endTime-startTime));

        /**
         * 从控制台输入一串字符
         * 统计输入的字符个数
         * 使用文件字符输出流写入文本文件
         */
        /*System.out.print("请输入一串字符，以回车键结束：");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();  //接收键盘输入
        System.out.printf("你输入了%d个字符，内容是：%s",line.length(),line);
        scanner.close();*/
    }

    @Test
    public void testInputStreamReader() throws Exception{  //抽象字符流的基本实现
        InputStream fis = new FileInputStream("d:/media/paper.txt");
        Reader isr = new InputStreamReader(fis,"GBK");  //向上转型
        int ch;
        while((ch=isr.read())!=-1){   //回车时结束
            System.out.print((char)ch);
        }
        isr.close();
    }

    @Test
    public void testBufferedReader() throws Exception{  //测试缓冲字符流（与非缓冲比较）
        //使用Windkws记事本程序打开文本文件，可查看字符编码。当不是UTF-8时，需要设定为GBK。
        File file = new File("d:/media/paper.txt");
        char[] chars;  //字符数组存放文本文件的内容
        long startTime,endTime;  //开始时间、结束时间
        //不使用缓冲读取文本文件
        startTime = System.currentTimeMillis();
        FileReader fr = new FileReader(file);  //字符文件输入流
        chars = new char[(int) file.length()];
        endTime = System.currentTimeMillis();
        fr.read(chars); fr.close();
        System.out.println("不使用缓冲读取文本文件，花费" + (endTime - startTime) + "毫秒");
        System.out.println("-----------------------------");
        Reader isr=new InputStreamReader(new FileInputStream(file),"GBK");
        BufferedReader br=new BufferedReader(isr);
        startTime = System.currentTimeMillis();
        chars = new char[(int)file.length()];
        endTime = System.currentTimeMillis();
        /*String readLine;
        while ((readLine=br.readLine())!=null) {  //逐行读取
            System.out.println(readLine);
        }*/
        br.read(chars);br.close();
        System.out.println("使用缓冲读取文本文件，花费" + (endTime - startTime) + "毫秒");
    }

    @Test
    public void testFilterReader() throws Exception{
        //测试字符过滤器流
        InputStreamReader isr = new InputStreamReader(System.in);
        //向上转型（面向抽象编程）；装饰底层流得到高层流
        FilterReader fr = new PushbackReader(isr);
    }

    @Test
    public void fileFlush() throws IOException {   //测试冲刷缓冲区
        File file_read = new File("D://original.txt");
        File file_write = new File("D://copy.txt");
        FileReader reader = new FileReader(file_read);
        FileWriter writer = new FileWriter(file_write);
        char[] bytes = new char[1024];
        int len;
        while ((len=reader.read(bytes))!=-1){
            writer.write(bytes,0,len);
        }
        //1.强制将缓冲区内的数据写入文件
        //writer.flush();
        //2.关闭流时，自动将缓冲区内的数据写入文件
        //writer.close();
        //reader.close();
        //结论：不调用flush()方法和流关闭方法，内容不会写入到目标文件。
    }

    @Test
    public void getTextFileCharCount() throws Exception{  //获取文本文件的字符个数
        //File对象与InputStream/OutputStream对象都具有获取文件大小的方法，但Reader/Writer没有
        FileReader fileReader = new FileReader("myText.txt");
        int ch,count=0;
        while ((ch=fileReader.read())!=-1){   //一次读一个字符
            if(ch!=10 && ch!=13 && ch!=0){  //不计回车符、换行符和 null
                count++;
                System.out.print((char)ch);
            }
        }
        System.out.println();
        System.out.println("文件字符个数："+count);
        fileReader.close();
    }
}
