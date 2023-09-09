package main.java.unit04;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
/**
 *  是一组在内存字符流上的操作/前者:把字符数组作为源的输入流的实现, 不与读/写文件打交道, 无需关闭; 该流可以作为临时的字符数组内存使用，运行结束后自动删除;
 *
 */
public class testCharArrayReaderWriter {
    public static void main(String[] args) throws IOException {
        //
        String tmp = "abcdefghijklmnopqrstuvwxyz";
        int length = tmp.length();
        char cs[] = new char[length];
        tmp.getChars(0, length, cs, 0);   //将字符串转变为字符数组
        CharArrayReader car1 = new CharArrayReader(cs);
        //CharArrayReader car2 = new CharArrayReader(cs, 0, 5);
        CharArrayWriter caw1 = new CharArrayWriter();      //输出流实例

        int i;
        System.out.println("字符数组读流实例输出:");
        while ((i = car1.read()) != -1) {
            System.out.print((char) i);
            caw1.write(i);
        }
        System.out.println("\n字符数组写流实例输出:");
        System.out.println(caw1.toString());                //char[] mychars=caw1.toCharArray(): 将输出流转换为字符数组

    }

}
