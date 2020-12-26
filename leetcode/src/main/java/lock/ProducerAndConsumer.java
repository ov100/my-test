package lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 生产者消费者多线程实现
 * <p>
 * 实现方式：
 * 1: 使用synchronized、父类Object中(wait、notify、notifyAll)
 * 2: 使用java.util.concurrent.locks下的lock锁
 * 3: 使用java.util.concurrent.CountDownLatch
 * 4: 使用java.util.concurrent.Semaphore
 * 5: 使用java.util.concurrent下阻塞队列
 */
public class ProducerAndConsumer {
    private static BlockingQueue<String> queue = new ArrayBlockingQueue(10);
    private static volatile boolean STOP = false;


    public void producer() throws InterruptedException {
        while (!STOP) {

            String data = "生产商品" + System.nanoTime();
            boolean result = queue.offer(data, 1, TimeUnit.SECONDS);

            while (!result) {
                System.out.println("插入队列失败，进行retry->" + data);
                TimeUnit.SECONDS.sleep(5);
                result = queue.offer(data, 1, TimeUnit.SECONDS);
            }

            System.out.println("插入队列成功->" + data);
        }
    }

    public void consumer() throws InterruptedException {
        while (true) {
            String result = queue.poll(10, TimeUnit.SECONDS);
            if (null == result) {
                System.out.println("消费超时");
                return;
            }

            TimeUnit.SECONDS.sleep(1);
            System.out.println("成功消费->" + result);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Producer().execute();
        new Consumer().execute();

        TimeUnit.SECONDS.sleep(60);
        STOP = true;
    }


    private static class Producer {
        public void execute() {
            new Thread(() -> {
                try {
                    new ProducerAndConsumer().producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ).start();
        }
    }

    private static class Consumer {
        public void execute() {
            new Thread(() -> {
                try {
                    new ProducerAndConsumer().consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ).start();
        }
    }
}
