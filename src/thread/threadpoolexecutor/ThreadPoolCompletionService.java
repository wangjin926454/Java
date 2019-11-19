package thread.threadpoolexecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolCompletionService implements Callable<Integer>{
    private static Lock lock = new ReentrantLock();
    private static AtomicInteger a = new AtomicInteger(0);
    private static ExecutorService executor = Executors.newCachedThreadPool();
    private static ExecutorCompletionService service = new ExecutorCompletionService(executor);
    public static void main(String[] args) throws Exception {
        for(int i=0;i<10;i++){
            service.submit(new ThreadPoolCompletionService());
        }
        for(int i=0;i<10;i++){
            System.out.println(service.take().get().toString());
        }
    }

    @Override
    public Integer call() throws Exception {
        return a.incrementAndGet();
    }
}
