import java.util.LinkedList;
import java.util.Queue;

class Producer implements Runnable {
    private final Queue<Integer> buffer;
    private final int maxSize;

    public Producer(Queue<Integer> buffer, int maxSize) {
        this.buffer = buffer;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            synchronized (buffer) {
                try {
                    while (buffer.size() == maxSize) {
                        System.out.println("缓冲区已满，生产者等待...");
                        buffer.wait();
                    }
                    System.out.println("生产者生产数据: " + i);
                    buffer.offer(i++);
                    buffer.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 模拟生产耗时
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private final Queue<Integer> buffer;

    public Consumer(Queue<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                try {
                    while (buffer.isEmpty()) {
                        System.out.println("缓冲区为空，消费者等待...");
                        buffer.wait();
                    }
                    int data = buffer.poll();
                    System.out.println("消费者消费数据: " + data);
                    buffer.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 模拟消费耗时
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        final int maxSize = 5;
        Queue<Integer> buffer = new LinkedList<>();

        Producer producer = new Producer(buffer, maxSize);
        Consumer consumer = new Consumer(buffer);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
