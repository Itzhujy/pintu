package src.main.java.unit08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 以下代码属于面向连接的可靠传输，即使用TCP协议的
 * Socket通信之客户端程序
 * 一旦创建与服务端的连接，将得到来自服务端的响应信息
 * 如果是接收的是对象，则需要进行对象的反序列化
 */

public class TCPClient {
    public static void main(String[] args) {
        try{
            System.out.println ("Client starting...");

            //在5432端口创建socket连接
            Socket socket = new Socket("127.0.0.1", 5432);
            //获取服务端的响应信息，对于客户端而言，它是输入流
            InputStream is = socket.getInputStream();  //为socket创建输入流
            BufferedReader br=new BufferedReader(new InputStreamReader(is));  //封装为缓冲字符流动
            System.out.println( br.readLine() );  // readLine()读取一行

            br.close();
            is.close();
            socket.close();   //关闭socket连接
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
