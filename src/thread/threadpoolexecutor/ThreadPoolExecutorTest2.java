package thread.threadpoolexecutor;

import thread.ThreadFactoryTest;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 四种线程池
 * ExecutorThreadPool
 * newCachedThreadPool适合耗时短。内部是一个SynchronousQueue,核心线程池大小为0
 * newFixedThreadPool固定大小线程池,内部是一个LinkedBlockingQueue，核心线程池大小与最大线程池大小相等
 * newSingleThreadPool适合多生产者单一消费者、实现加锁效果
 * */
public class ThreadPoolExecutorTest2 implements Callable<Integer>{
    private static Object object = new Object();
    private static volatile AtomicInteger a = new AtomicInteger(0);
    // 在ThreadPoolExecutor初始化中Queue为ArrayBlockingQueue和LinkedBlockingQueue和LinkedBlockingDeque且有大小限制时：
    //  1) 当池子大小小于corePoolSize就新建线程，并处理请求
    //  2）当池子大小等于corePoolSize，超过的线程加入ArrayBlockingQueue等待执行,
    //  3) 线程池能容纳的最大容量 = maximumPoolSize + Queue(int capacity)
    //  4）当workQueue放不下新入的任务时，就用RejectedExecutionHandler来做拒绝处理
    //  5）另外，当池子的线程数大于corePoolSize的时候，多余的线程会等待keepAliveTime长的时间，如果无请求可处理就自行销毁

    //在ThreadPoolExecutor初始化中Queue为SynchronousQueue和LinkedBlockingQueue和LinkedBlockingDeque且有没有限制时：(new ArrayBlockingQueue必须初始化数量，在这里无效)
    //SynchronousQueue和LinkedTransferQueue没有数量限制。因为他根本不保持这些任务，而是直接交给线程池去执行。当任务数量超过最大线程数时会直接抛异常。
    //LinkedBlockingQueue一直添加在其缓存队列中，因为LinkedBlockingQueue是无界队列


    private static ThreadPoolExecutor tpe = new ThreadPoolExecutor(5,10,1,
            TimeUnit.SECONDS,new LinkedBlockingQueue<>(1),new ThreadFactoryTest(),new ThreadFactoryTest());
    //若要批量执行任务且要获得返回值可以使用ExecutorCompletionService实例
    private static ExecutorCompletionService service = new ExecutorCompletionService(tpe);

    public static void main(String[] args)throws Exception{
        Future f = null;
        for(int i=0;i<30;i++){
            //若要批量执行任务且要获得返回值可以使用ExecutorCompletionService实例
            tpe.submit(new Thread(){
                public void run(){
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            //获取返回值，没有线程执行完毕则此步骤会阻塞，直到有异步任务执行结束
            //System.out.println(service.take().get());
            //Thread.sleep(1000);
            //获取线程池大小，不包括线程队列中
            System.out.print("当前线程池总数"+tpe.getPoolSize()+" ");
            //获取线程队列大小
            System.out.print("当前线程池队列数"+tpe.getQueue().size()+" ");
            System.out.print("当前线程池核心数"+tpe.getCorePoolSize()+" ");
            System.out.print("线程池接受到的线程数量"+tpe.getTaskCount()+" ");
            System.out.print("线程池已处理完毕的线程数量"+tpe.getCompletedTaskCount()+" ");
            System.out.print("正在执行的线程数量"+tpe.getActiveCount());
            System.out.println();
            //非阻塞队列
            //service.poll();
            //service.poll(Long long,TimeUnit unit);
        }
        System.out.println(tpe.getPoolSize());
        Thread.sleep(2000);
        System.out.println(tpe.getPoolSize());

    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(100000);
        return a.incrementAndGet();
    }
}
