package main.java.unit07;

class TicketWindow implements Runnable {  //实现Runnable接口
	private static int nums = 20;  //总票数
	private static int counter;  //售票计数器
	@Override
	public void run() {  //线程业务逻辑
		while (true) {
			if (nums > 0) {
				System.out.print("窗口" + Thread.currentThread().getName()+ "售出第"+(20-nums+1)+"张票...  ");
				nums--;
				counter++;
				if(counter%3==0){  //每行输出3条售票信息
					System.out.println(" ");
				}
				try {    //一秒钟出一张票
					Thread.sleep(1000);  //设置线程休眠
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				break;  //售票完毕
			}
		}
	}
}
public class SaleTicket0 {
    public static void main(String[] args) {
        TicketWindow ticketRunnable= new TicketWindow();  //创建Runnable对象
        //创建3个线程（以Runnable对象作为构造参数）并启动
        new Thread(ticketRunnable).start();
        new Thread(ticketRunnable).start();
        new Thread(ticketRunnable).start();
    }
}
