package main.java.unit07;

/**
 * 本程序除了主线程main外，没有创建创建并运行其它的子线程。
 * 一个单线程（不包含子线程）的Java程序
 * 本程序使用了线程类Thread的静态方法sleep()
 */
public class SequentialDemo {  //顺序
	char letter;  //字母
	public SequentialDemo(char letter) {  //构造方法
		this.letter = letter;
	}
	public void printWithSleep() {  //休眠式打印，循环5次
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(300);  //先睡眠一下
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(letter);  //再打印
		}
	}
	public static void main(String[] args) {
		//输出当前线程名
		System.out.println("当前线程名："+Thread.currentThread().getName());  //输出：main
		//输出当前线程 Id
		System.out.println("当前线程id："+Thread.currentThread().getId());  //输出：1
		//下面以打字效果显示，字母A、B、C、D不会交替出现
		new SequentialDemo('A').printWithSleep();
		new SequentialDemo('B').printWithSleep();
		new SequentialDemo('C').printWithSleep();
		new SequentialDemo('D').printWithSleep();
	}
}