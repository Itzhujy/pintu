package main.java.unit08;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 使用UDP协议的Socket通信之客户端程序
 * DatagramPacket：数据报文包
 * DatagramSocket：数据报文套接字，具有发送报文方法send(datagramPacket)
 */
public class UDPClient {
    public static void main(String[] args){
        //创建SocketAddress的子类InetSocketAddress的实例，以服务器地址及端口作为构造参数
        InetSocketAddress ip = new InetSocketAddress("127.0.0.1", 5678);
        //创建待发送信息的字节数组
        byte[] buf=(new String("Hello，UDP Server.")).getBytes();
        //定义数据报文包对象，它包含信息
        DatagramPacket dp=new DatagramPacket(buf,buf.length,ip);
        try{
            DatagramSocket datagramSocket = new DatagramSocket(9999);
            System.out.println("UDP客户端已经创建。");
            datagramSocket.send(dp);  //发送报文到指定的UDP服务器端口
            System.out.println("数据报文已经发送。");
            datagramSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}