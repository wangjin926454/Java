package thread.threadpoolexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 四种线程池
 */
public class FourThreadPoolExecutor {
    //corePoolSize==0 去一个执行一个,内部是SynchronousQueue
    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    //corePoolSize == maxPoolSize 全部都是核心
    private static final ExecutorService getExecutorService = Executors.newFixedThreadPool(5);
    //只设置核心线程数
    private static final ExecutorService getExecutorService1 = Executors.newScheduledThreadPool(5);
    //只有一个核心线程数，但是工作者线程队列是LinkedBlockingQueue无界队列，无限添加。适合多生产者
    private static final ExecutorService getExecutorService2 = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {

    }
}
