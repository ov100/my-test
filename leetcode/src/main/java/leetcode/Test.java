package leetcode;


import lombok.Getter;

import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * tt
 *
 * @author gb
 * @date 2020/10/13
 */
public class Test {
    private DelayQueue<DelayQueueInfo> delayQueue = new DelayQueue();
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);
    private ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20, 60, TimeUnit.MICROSECONDS, queue);


    private int num;
    private void product(){
        delayQueue.offer(new DelayQueueInfo(1000L, "test"+num, 1));
        System.out.println(LocalDateTime.now()+"生产test"+num);
        num++;
    }

    private void consume(){
        try {
            DelayQueueInfo info = delayQueue.take();
            System.out.println(LocalDateTime.now()+"消费"+info.getKey());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class DelayQueueInfo implements Delayed {
        /**
         * 到期时间
         */
        private final long expire;

        /**
         * 缓存key
         */
        @Getter
        private final String key;

        /**
         * 重试次数
         */
        @Getter
        private int retryNum;

        private DelayQueueInfo(long delay, String key, int retryNum) {
            this.key = key;
            this.expire = System.currentTimeMillis() + delay;    //到期时间 = 当前时间+延迟时间
            this.retryNum = retryNum;
        }


        /**
         * 获得延迟时间   用过期时间-当前时间
         *
         * @param unit 时间单位
         * @return 延迟时间
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        /**
         * 延迟队列内部比较排序算法
         */
        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }
    }

    public static void main(String[] args) {
        Test test = new Test();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                try {
                    test.product();
                    test.pool.execute(()->test.consume());
                    Thread.sleep(1000L);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
