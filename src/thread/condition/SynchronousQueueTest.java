package thread.condition;

import java.util.concurrent.SynchronousQueue;

/**
 * 特殊有界队列，适合生产者和消费者数量差不多情况下使用
 * put后暂停put线程唤醒take线程，take操作暂停take线程唤醒put线程
 * //fair表示使用公平队列还是非公平队列
 * new LinkedBlockingQueue(boolean fair)
 * */
public class SynchronousQueueTest {
    private static SynchronousQueue queue = new SynchronousQueue();
    public static void main(String[] args){
        Thread t = new Thread(){
            public void run(){
                try{
                    Thread.sleep(5000);
                    ////如果没有线程take队列该线程会被阻塞，该线程由SynchronousQueue内部维护，直到take后唤醒该线程
                    queue.put("e");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(){
            public void run(){
                try{
                    //System.out.println("test");
                    //此时take没有数据时该线程会被阻塞，该线程由SynchronousQueue内部维护，直到put后唤醒该线程
                    System.out.println(queue.take());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        //为什么一定t比t1先执行呢？因为java内存模型的原因，t与t1有happen before关系(他们之中都有同一个锁。queue中的ReentrantLock)，所以t比t1先执行
        t.start();
        t1.start();
    }

}
