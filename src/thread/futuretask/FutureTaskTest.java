package thread.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 *通过Callable接口实现线程
 * */
public class FutureTaskTest implements Callable<Integer> {
    public static void main(String[] args) throws Exception{
        Callable<Integer> f = new FutureTaskTest();
        FutureTask<Integer> f1 = new FutureTask<>(f);
        Thread t = new Thread(f1);
        t.start();
        System.out.println(f1.get());
    }

    @Override
    public Integer call() throws Exception {
        return 5;
    }
}
