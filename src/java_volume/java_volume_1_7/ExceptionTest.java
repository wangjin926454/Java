package java_volume.java_volume_1_7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExceptionTestHandlder implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("my UncaughtException" + e);
    }
}
/**
 * 未捕获异常处理器
 * */
public class ExceptionTest implements  Runnable {
    /**
     * see ExceptionTest1
     * */
    public static void main(String[] args){
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionTest());
        } catch (RuntimeException e){
            System.out.println("RuntimeException has been handled");  //异常不能被捕获、且会抛出到控制台 解决方法见 ExceptionTest1
        }
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}