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
public class ThreadPoolExecutorTest1 implements Callable<Integer>{
    private static volatile AtomicInteger a = new AtomicInteger(0);
    //  1) 当池子大小小于corePoolSize就新建线程，并处理请求
    //  2）当池子大小等于corePoolSize，把请求放入workQueue中，池子里的空闲线程就去从workQueue中取任务并处理
    //  3）当workQueue放不下新入的任务时，新建线程入池，并处理请求，如果池子大小撑到了maximumPoolSize就用RejectedExecutionHandler来做拒绝处理
    //  4）另外，当池子的线程数大于corePoolSize的时候，多余的线程会等待keepAliveTime长的时间，如果无请求可处理就自行销毁
    private static ThreadPoolExecutor tpe = new ThreadPoolExecutor(5,15,10L,
            TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(20),new ThreadFactoryTest(),new ThreadFactoryTest());
    private static Object object = new Object();
    private static ExecutorCompletionService service = new ExecutorCompletionService(tpe);

    public static void main(String[] args)throws Exception{
        Future f = null;
        for(int i=0;i<50;i++){
            f = tpe.submit(new ThreadPoolExecutorTest1());
        }
        Thread.sleep(1000);
        //获取最大线程池数量
        System.out.println(tpe.getLargestPoolSize());
        //获取线程池数量
        System.out.println(tpe.getPoolSize());
        //获取线程池存活数量
        System.out.println(tpe.getActiveCount());
        System.out.println(tpe.getQueue().size());
        //批量获取提交的异步任务的处理结果，阻塞方法，前提是目标线程已结束
        //System.out.println(service.take());
        //非阻塞方法
        System.out.println(service.poll());
        //service.poll(Long time,TimeUnit unit);
        tpe.shutdown();

    }

    @Override
    public Integer call() throws Exception {
        System.out.println(a.incrementAndGet());
        Thread.sleep(20000L);
        return a.incrementAndGet();
    }
}
