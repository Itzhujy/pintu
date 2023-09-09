package src.main.java.unit07;

class TicketThread extends Thread{  //线程类
    private String windowName;  //售票窗口名
    private static int counter;  //售票计数器

    TicketThread(String ticketWindowName){  //构造方法
        this.windowName =ticketWindowName;
        counter=0;
    }

    @Override
    public void run() {
        while (true){
            synchronized (SaleTicket.ticketNum.getClass()){  //类类型对象唯一
                if(SaleTicket.ticketNum>0){
                    System.out.print(windowName+"正在出售第"+ (20-SaleTicket.ticketNum+1)+"张票... ");
                    counter++;
                    if(counter%3==0){  //每行输出3条售票信息
                        System.out.println(" ");
                    }
                    SaleTicket.ticketNum--;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}

public class SaleTicket {  //主类
    public static Integer ticketNum=20;  //总票数作为同步对象

    public static void main(String[] args) {
        new TicketThread("1#窗口").start();
        new TicketThread("2#窗口").start();
        new TicketThread("3#窗口").start();
    }
}
