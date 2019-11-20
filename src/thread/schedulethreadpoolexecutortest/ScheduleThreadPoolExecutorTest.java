package thread.schedulethreadpoolexecutortest;

import thread.ThreadFactoryTest;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduleThreadPoolExecutorTest implements Runnable {
    private static AtomicInteger a = new AtomicInteger(0);
    //实现ScheduleExecutorService实例的两个静态工厂方法
    private static ScheduledExecutorService service = Executors.newScheduledThreadPool(5,new ThreadFactoryTest());
    //private static ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
    //private static ScheduledExecutorService service1 = new ScheduledThreadPoolExecutor(5);

    public static void main(String[] args) throws Exception{
        //定时任务执行一次,方法中是Callable接口
        //ScheduledFuture<Integer> f = service.schedule(new ScheduleThreadPoolExecutorTest(),5, TimeUnit.SECONDS);

        //定时任务一直执行，在initialDelay时间后开始执行，period时间执行一次，如果执行线程时间超过了period后面执行周期会变得不固定(多久执行下一次取决于线程中的耗时)
        ScheduledFuture f = service.scheduleAtFixedRate(new ScheduleThreadPoolExecutorTest(),5,1, TimeUnit.SECONDS);
        //定时任务一直执行，在initialDelay时间后开始执行，period时间执行一次，如果执行线程时间超过了period后面执行周期会变得不固定(多久执行下一次取决于线程中的耗时+delay)
        //ScheduledFuture f = service.scheduleWithFixedDelay(new ScheduleThreadPoolExecutorTest(),5,1,TimeUnit.SECONDS);
        //System.out.println(f.get());
        //service.shutdown();
    }

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println(System.currentTimeMillis());
    }

    /*@Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return a.incrementAndGet();
    }*/
}
