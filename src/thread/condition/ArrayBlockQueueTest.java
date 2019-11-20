package thread.condition;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ArrayBlockingQueue 数组阻塞队列,使用同一个ReentrantLock
 * 此队列只能表示有界队列,此队列适用于并发度比较低的情况下使用
 * capacity表示初始化队列大小,fair表示公平队列还是非公平队列
 * new ArrayBlockingQueue(int capacity,boolean fair)
 * */
public class ArrayBlockQueueTest {
    private static BlockingQueue queue = new ArrayBlockingQueue(10);
    public static void main(String[] args){
        try{
            //非阻塞队列
            //queue.offer("e");
            //非阻塞队列
            //queue.poll();
            queue.put("e");
            System.out.println(queue.take());
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
