package main.java.unit04;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;


@SuppressWarnings("all")

class pipedReceiverThread extends Thread {

    // 管道输入流对象
    // 它和“管道输出流(PipedWriter)”对象绑定，
    // 从而可以接收“管道输出流”的数据，再让用户读取。
    private PipedReader in = new PipedReader();

    // 获得“管道输入流对象”
    public PipedReader getReader(){
        return in;
    }

    @Override
    public void run(){
        //readMessageOnce() ;
        readMessageContinued() ;
    }

    // 从“管道输入流”中读取1次数据
    public void readMessageOnce(){
        // 虽然buf的大小是2048个字符，但最多只会从“管道输入流”中读取1024个字符。
        // 因为，“管道输入流”的缓冲区大小默认只有1024个字符。
        char[] buf = new char[2048];
        try {
            int len = in.read(buf);
            System.out.println(new String(buf,0,len));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 从“管道输入流”读取>1024个字符时，就停止读取
    public void readMessageContinued(){
        int total=0;
        while(true) {
            char[] buf = new char[1024];
            try {
                int len = in.read(buf);
                total += len;
                // 若读取的字符总数>1024，则退出循环。
                if (total > 1024 || len==-1)
                    break;
                System.out.println(new String(buf,0,len));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class pipedSenderThread extends Thread {

    // 管道输出流对象
    // 它和“管道输入流(PipedReader)”对象绑定，
    // 从而可以将数据发送给“管道输入流”的数据，然后用户可以从“管道输入流”读取数据。
    private PipedWriter out = new PipedWriter();

    // 获得“管道输出流”对象
    public PipedWriter getWriter(){
        return out;
    }

    @Override
    public void run(){
        //writeShortMessage();
        writeLongMessage();
    }

    // 向“管道输出流”中写入一则较简短的消息："This is a short message"
    private void writeShortMessage() {
        String strInfo = "This is a short message" ;
        try {
            out.write(strInfo.toCharArray());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 向“管道输出流”中写入一则较长的消息
    private void writeLongMessage() {
        StringBuilder sb = new StringBuilder();
        // 通过for循环写入1020个字符
        for (int i=0; i<10; i++)
            sb.append("0123456789 ");
        // 再写入26个字符。
        sb.append("abcdefghijklmnopqrstuvwxyz");
        // str的总长度是1020+26=1046个字符
        String str = sb.toString();
        try {
            // 将1046个字符写入到“管道输出流”中
            out.write(str);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class testPipedReaderWriter {
    public static void main(String[] args) {
        pipedSenderThread pSt = new pipedSenderThread();
        pipedReceiverThread pRt = new pipedReceiverThread();

        PipedWriter out = pSt.getWriter();
        PipedReader in = pRt.getReader();

        try {
            //管道连接, 下面2句话的本质是一样
            //out.connect(in);
            in.connect(out);

            pSt.start();
            pRt.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

