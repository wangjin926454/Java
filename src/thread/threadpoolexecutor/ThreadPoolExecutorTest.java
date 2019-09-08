package thread.threadpoolexecutor;

import thread.ThreadFactoryTest;

import java.util.concurrent.*;

/**
 * 线程池 ThreadPoolExecutor
 * 初始化参数:
 * corePoolSize 核心线程数
 * maximumPoolSize 最大线程数
 * keepAliveTime 最大空闲存活时间
 * TimeUnit 指定最大空闲存活时间的单位
 * new BlockingQueue 线程池队列 ，可指定某种队列，例如 ArrayBlockingQueue,LinkedBlockingQueue，SynchronousBlockingQueue
 * new ThreadFactory 指定线程工厂,可自定义，没有该参数时执行Executors.defaultThreadFactory()
 * new ThreadPoolExecutor.RejectedExecutionHandler 线程加入线程池被拒绝时处理方式，可自定义实现该接口,自动执行rejectedException方法
 * */
public class ThreadPoolExecutorTest{
    //获取cpu核心数
    private static final int N_CPU = Runtime.getRuntime().availableProcessors();
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(2,N_CPU * 2,
            600, TimeUnit.SECONDS,new ArrayBlockingQueue<>(N_CPU * 8),
            new ThreadFactoryTest(),new ThreadPoolExecutor.CallerRunsPolicy());
    public static void main(String[] args) throws Exception{
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
                //自定义异常无法自动执行/暂时未知
                //throw new NullPointerException("test1111");
            }
        });
        Future f = executor.submit(new Callable<Integer>() {
            public Integer call(){
                System.out.println("callable test");
                return 5;
            }
        });
        try{
            System.out.println("submit return " + f.get());
            //ExecutionException在Future.get()时可能会抛出的异常，由于目标线程未正确执行
        }catch (ExecutionException e){
            e.getCause();
        }
        //lambda 中只有多个语句
        executor.submit(new Thread(()->{
            System.out.println("lambda test");
            System.out.println("lambda test1");
        }
               ){
        });
        //lambda 中只有一个语句
        executor.submit(new Thread(()->
            System.out.println("lambda test")
        ){
        });
        System.out.println(executor.isShutdown());
        //线程池关闭
        executor.shutdown();
        //线程池立即关闭
        //executor.shutdownNow();
        //线程池在100S后关闭
        //executor.awaitTermination(100L,TimeUnit.SECONDS);
    }
}
