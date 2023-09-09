package src.main.java.unit08;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 使用UDP协议的Socket通信之服务端程序
 * DatagramSocket：数据报文包
 * 使用DatagramSocket的receive(datagramPacket)
 */
public class UDPServer {  //UDP通信服务端
    public static void main(String[] args) {
        byte buf[]=new byte[1024];
        //创建数据报文包，以字节数组和缓冲区大小作为构造参数
        DatagramPacket datagramPacket=new DatagramPacket(buf,buf.length);
        try {
            //创建报文套接字，以端口号作为构造参数
            DatagramSocket datagramSocket = new DatagramSocket(5678);
            System.out.println("UDP Server started...");
            while(true){
                datagramSocket.receive(datagramPacket);  //阻塞式接收
                //输出数据报文信息
                String msg = new String(buf, 0, datagramPacket.getLength());
                System.out.println(msg);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}