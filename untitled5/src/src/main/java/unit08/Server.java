package src.main.java.unit08;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 基于TCP连接的Socket通信之服务端程序
 * 一旦得到来自客户端的连接，将向客户端发送信息
 * 如果是对象的传输，则需要在传输前序列化对象
 */
public class Server {  //TCP服务端
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(5432);
        System.out.println("TCP Server Started...");

        while (true){
            //服务器一直在监听，因为它不知道客户端什么时候连接
            Socket socket = serverSocket.accept();  //体现面向连接

            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            Thread.sleep(3000);  //休眠3秒

            //向远程客户端发送消息
            bw.write(socket.getInetAddress().getHostAddress()+"/"+socket.getPort()+"：Hello!");
            bw.write(" 我是TCP服务端，IP地址为："+socket.getLocalAddress()+"/"+socket.getLocalPort());
            bw.close();//关闭后客户端才能接收到消息
            os.close();
        }
    }
}
