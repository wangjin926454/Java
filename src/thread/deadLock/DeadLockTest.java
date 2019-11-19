package thread.deadLock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ThreadMXBean检测死锁类
 * */
public class DeadLockTest {
    private static Lock lock = new ReentrantLock();
    private static Lock lock1 = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static Condition condition1 = lock1.newCondition();

    private static Thread findThreadById(long id){
        Set<Thread> setThread = Thread.getAllStackTraces().keySet();
        for(Thread thread : setThread){
            if(thread.getId() == id){
                return thread;
            }
        }
        return null;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                System.out.println("Thread"+Thread.currentThread().getId()+"获得lock");
                Thread.sleep(1000);
                lock1.lockInterruptibly();
                System.out.println("Thread"+Thread.currentThread().getId()+"获得lock1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t1 = new Thread(() -> {
            try {
                lock1.lockInterruptibly();
                System.out.println("Thread"+Thread.currentThread().getId()+"获得lock1");
                Thread.sleep(1000);
                lock.lockInterruptibly();
                System.out.println("Thread"+Thread.currentThread().getId()+"获得lock");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t1.start();
        //获取所有死锁线程
        Thread.sleep(1500);
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        Optional<long[]> longs = Optional.ofNullable(threadMXBean.findDeadlockedThreads());
        if(longs.isPresent()){
            for(int i=0;i<longs.get().length;i++){
                System.out.println("线程"+longs.get()[i]+"已锁死");
            }
            Thread thread = findThreadById(longs.get()[0]);
            lock.unlock();
            thread.interrupt();
            Thread.sleep(2000);
            System.out.println("线程是否能中断标志"+thread.isInterrupted()+
                    ",线程12状态"+thread.getState()+",线程13状态"+findThreadById(longs.get()[1]).getState());
        }
    }
}
