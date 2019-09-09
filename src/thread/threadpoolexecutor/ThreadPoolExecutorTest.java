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
                //未捕获的异常将由执行ThreadFactory中uncaughtException方法,
                // 前提是线程必须执行方法必须是execute方法提交的而不是submit
                throw new NullPointerException("test1111");
            }
        });
        Future f = executor.submit(new Callable<Integer>() {
            public Integer call(){
                System.out.println("callable test");
                //抛出异常需要捕获ExecutionException
                //throw new NullPointerException();
                return 5;
            }
        });
        try{
            //f.get()方法是线程阻塞的、如果一直没有返回值则会一直阻塞
            //对此可以使用f.get(10L,TimeUnit.SECONDS);超时会抛出TimeoutException
            System.out.println("submit return " + f.get());
            //ExecutionException在Future.get()时可能会抛出的异常，由于目标线程未正确执行
        }catch (ExecutionException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            f.cancel(true);
            //线程是否已经被取消
            System.out.println(f.isCancelled());
            //线程是否已经结束
            System.out.println(f.isDone());
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
