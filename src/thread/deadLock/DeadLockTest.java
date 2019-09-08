package thread.deadLock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

/**
 * ThreadMXBean检测死锁类
 * */
public class DeadLockTest {
    public static void main(String[] args){
        Thread t = new Thread(){
          public void run(){
              ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
              for(;;){
                  long[] ids = threadMXBean.findDeadlockedThreads();
                  System.out.println(Arrays.toString(ids));
              }
          }
        };
        t.start();
    }
}
