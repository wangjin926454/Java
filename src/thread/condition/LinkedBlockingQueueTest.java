package thread.condition;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * LinkedBlockingQueue 链表阻塞队列,使用同一个put使用一个锁,take使用一个锁
 * 此队列可以表示有界队列和无界队列，有界队列时显示初始化容量即可。
 * 此队列适用于高并发的情况下使用
 * capacity表示初始化队列大小,此队列只支持非公平队列
 * new LinkedBlockingQueue(int capacity)
 * */
public class LinkedBlockingQueueTest {
    private static LinkedBlockingQueue queue = new LinkedBlockingQueue(10);
    public static void main(String[] args){
        try{
            queue.put("e");
            System.out.println(queue.take());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
