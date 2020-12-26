package lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 死锁
 *
 * @author gb
 * @date 2020/11/07
 */
public class Deadlock {
    private int [] lock1 = new int[0];
    private int [] lock2 = new int[0];

    private void a() {
        synchronized (lock1){
            System.out.println("get lock1");

            synchronized (lock2){
                System.out.println("get lock2");
                sleep();
            }
        }
    }

    private void b(){
        synchronized (lock2){
            System.out.println("get lock2");

            synchronized (lock1){
                System.out.println("get lock1");
                sleep();
            }
        }
    }

    private void sleep(){
        try {
            Thread.sleep(100000L);
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        Deadlock deadlock = new Deadlock();
        //Thread t1 = new Thread(()->deadlock.a());
        //Thread t2 = new Thread(()->deadlock.b());

        //t1.start();
        //t2.start();

        AtomicInteger nextQueueCyclicCounter = new AtomicInteger(0);
        for (int i = 0; i < 20; i++) {
            int current = nextQueueCyclicCounter.get();
            int next = (current + 1) % 1;
            if (nextQueueCyclicCounter.compareAndSet(current, next)) {
                System.out.println("current:"+current+"->next:"+next);
            }
        }
    }
}
