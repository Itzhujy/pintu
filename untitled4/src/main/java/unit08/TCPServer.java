package main.java.unit08;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 基于TCP连接的Socket通信之服务端程序
 * 一旦得到来自客户端的连接，将向客户端发送信息
 * 如果是对象的传输，则需要在传输前序列化对象
 */

public class TCPServer {
    public static void main(String[] args) {
        int count=0;  //连接计数
        ServerSocket serverSocket=null;
        String sendString="Hello Net World!";      //服务器向给客户端发送消息
        System.out.println ("Server starting...");
        try {
            serverSocket = new ServerSocket(5432);    //服务器分配一个通信的端口号5432
        } catch (IOException e) {
            System.out.println ("server socket error");
            return;
        }

        while (true) {  // 服务器一直监听通信端口
            try {
                System.out.println ("Waiting connection...");

                Socket socket =serverSocket.accept();  //等待客户端连接
                count++;

                //一旦获取客户端请求，程序才开始往下继续：
                System.out.println ("第"+count+"次 Accepting Connection at " +
                        socket.getInetAddress() + ":" +socket.getLocalPort() +
                        "   at time: "+ (new Date()).toLocaleString());

                //为Socket通信创建输出流
                OutputStream os = socket.getOutputStream();
                BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(os)); //封装成字符流
                bw.write(sendString+"\n");  // 输出消息
                System.out.println ("Message send completed!");

                bw.close();
                os.close();
                socket.close();  //关闭连接，但不关闭serverSocket.close()
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
