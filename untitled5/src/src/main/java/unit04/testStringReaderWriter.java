package src.main.java.unit04;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class testStringReaderWriter {

    public static void main(String[] args) {

        String aStr = "这是字符串读/写的简单例子";
        StringReader stringReader = new StringReader(aStr);
        StringWriter stringWriter = new StringWriter();
        int ch;
        try {
            while ((ch = stringReader.read()) != -1) {
                System.out.print((char) ch);
                stringWriter.write(ch);
            }
            // Convert writer to String
            System.out.println("\n内存字符写入后输出:");
            System.out.println(stringWriter.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
