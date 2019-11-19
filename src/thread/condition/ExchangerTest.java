package thread.condition;

import java.util.concurrent.Exchanger;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * Exchanger  类似于 SynchronousQueue 一个线程与另一个线程交换数据
 * 两个线程调用exchange()，在两个线程相遇时交换数据
 * */
public class ExchangerTest {
    private static Exchanger<LinkedBlockingQueue> exchanger = new Exchanger<>();
    private static   LinkedBlockingQueue blockingQueue = new LinkedBlockingQueue(10);
    private static   LinkedBlockingQueue blockingQueue1 = new LinkedBlockingQueue(10);
    public static void main(String[] args){
        Thread t = new Thread(){
            public void run(){
                try{
                    for(int i=0;i<10;i++){
                        blockingQueue.put(i);
                    }
                    //生产者线程缓冲区已满。调用exchange()等待交换
                    blockingQueue = exchanger.exchange(blockingQueue);
                    System.out.println(Thread.currentThread().isInterrupted());
                    System.out.println(Thread.interrupted());
                    System.out.println(blockingQueue.size());

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(){
            public void run(){
                try{
                    Thread.sleep(10000);
                    //调用exchange()交换数据
                    //把bockingQueue的数据交换过来
                    blockingQueue1 = exchanger.exchange(blockingQueue1);
                    for(int i=0;i<10;i++){
                        System.out.print("take: "+blockingQueue1.take()+" ");
                    }
                    System.out.println();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t.start();
        t1.start();
    }
}
