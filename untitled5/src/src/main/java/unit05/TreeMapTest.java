package src.main.java.unit05;
//http://epy.iteye.com/blog/1975264
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;


public class TreeMapTest {
	private static Random random = new Random();
	private static Random random2 = new Random();

	private static final int SIZE = 100000;
	private static final int GETCNT = 100000;

	public static void main(String[] args) {
		TreeMapDemo2();
		//HashMapTest();
	}

	public static void TreeMapDemo2() {
		System.out.println("\nTreeMap Test");
		System.gc();
		printHeapMemoryInfo();
		TreeMap<String, Short> trMap = new TreeMap<String, Short>();
		int i = 0;
		Short val;
		while (i < SIZE) {
			val = trMap.put(getRandomPhone(), (short)(i%4));
			if (val == null) {
				i++;
			}
		}

		System.out.println("size : " + trMap.size());

		System.gc();
		printHeapMemoryInfo();

		long startTime = System.currentTimeMillis();
		for (i=0; i<GETCNT; i++) {
			trMap.get(getRandomPhone2());
		}
		System.out.println("search " + GETCNT + " times, usedTime: " + (System.currentTimeMillis() - startTime) + "ms.");

	}

	public static void HashMapTest() {
		System.out.println("\nHashMap Test");
		System.gc();
		printHeapMemoryInfo();
		HashMap<String, Short> hashMap = new HashMap<String, Short>();
		int i = 0;
		Short val;
		while (i < SIZE) {
			val = hashMap.put(getRandomPhone(), (short)(i%4));

			if (val == null) {
				i++;
			}
		}

		System.out.println("size : " + hashMap.size());

		System.gc();
		printHeapMemoryInfo();

		long startTime = System.currentTimeMillis();
		for (i=0; i<GETCNT; i++) {
			hashMap.get(getRandomPhone2());
		}
		System.out.println("search " + GETCNT + " times, usedTime: " + (System.currentTimeMillis() - startTime) + "ms.");

	}

	/**
	 * 返回一个手机号码，有十亿种可能性，（中国移动用户总数约十亿）
	 * @return
	 */
	public static String getRandomPhone() {
		return String.valueOf(13000000000L + random.nextInt(1000000000));
	}

	/**
	 * 返回一个测试手机号码，有十亿种可能性，（中国移动用户总数约十亿）
	 * @return
	 */
	public static String getRandomPhone2() {
		return String.valueOf(13000000000L + random2.nextInt(1000000000));
	}


	public static void printHeapMemoryInfo() {
		Runtime runtime = Runtime.getRuntime();
		System.out.printf("maxMemory : %.2fM\n", runtime.maxMemory()*1.0/1024/1024);
		System.out.printf("totalMemory : %.2fM\n", runtime.totalMemory()*1.0/1024/1024);
		System.out.printf("freeMemory : %.2fM\n", runtime.freeMemory()*1.0/1024/1024);
		System.out.printf("usedMemory : %.2fM\n", (runtime.totalMemory()-runtime.freeMemory())*1.0/1024/1024);
	}
}
