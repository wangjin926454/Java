package thread;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程工厂
 * */
public class ThreadFactoryTest implements ThreadFactory, RejectedExecutionHandler {
    private final UnCaughtException uce = new UnCaughtException();
    public static void main(String[] args){
        ThreadFactoryTest test = new ThreadFactoryTest();
        test.newThread(new Thread(){
            public void run(){
                //调用重写的toString方法
                System.out.println(Thread.currentThread());
                throw new RuntimeException("test test");
            }
        }).start();
       // t;
        //System.out.println(t.toString());
    }

    @Override
    public Thread newThread(Runnable r) {
        //创建线程并重写toString方法
        Thread t = makeThread(r);
        t.setUncaughtExceptionHandler(uce);
        return t;
    }

    protected Thread makeThread(final Runnable r){
        return new Thread(r){
            @Override
            public String toString(){
                ThreadGroup group = getThreadGroup();
                String groupName = null==group?"":group.getName();
                return "This is toString test";
            }
        };
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("rejectedExecution test");
    }

    //抛未捕获的异常时自动调用实现UncaughtExceptionHandler接口的重写的uncaughtException方法
    static class UnCaughtException implements Thread.UncaughtExceptionHandler{

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName()+" "+e.getMessage());
        }
    }

}
