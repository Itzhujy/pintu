package src.main.java.unit08;

import java.io.*;
import java.net.Socket;

/**
 * 基于TCP连接的Socket通信之客户端程序
 * 客户端访问本地端口为5432的服务端
 * 先创建连接，然后输出来自服务端的文本消息（仅一行）
 * 如果服务器未启动，就会出现异常
 */
public class Client {   //TCP客户端
    public static void main(String[] args) {
        try {
            //体现面向连接，使用主机的IP及端口
            //Socket socket = new Socket("127.0.0.1", 5432);
            Socket socket = new Socket("192.168.1.5", 5432);  //局域网测试
            System.out.println("客户端已经连到到TCP服务器.");

            InputStream is = socket.getInputStream(); //获取来自服务端的输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));  //包装成缓冲字符流
            String s = br.readLine();  //读取一行文本
            System.out.println(s);
        } catch (Exception e) {   //连接失败时
            System.out.println("服务器异常！");
            //e.printStackTrace();
        }
    }
}
