package java_volume_1_7;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExceptionTest1 {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool(new HandlderThreadFactory());
        exec.execute(new MyException());
    }
}

/**
 * 未捕获异常处理器
 * */
class MyUnException implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("捕获" + e);
    }
}
class HandlderThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        System.out.println("new Thread is creating");
        Thread t = new Thread(r);
        System.out.println("new Thread is created");
        t.setUncaughtExceptionHandler(new MyUnException());
        System.out.println(t.getUncaughtExceptionHandler());
        return t;
    }
}
class MyException implements  Runnable{

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by "+t);
        System.out.println("eh = "+t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}