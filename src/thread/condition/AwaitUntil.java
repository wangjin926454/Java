package thread.condition;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitUntil {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread t = new Thread(){
          public void run(){
              lock.lock();
              try{
                  System.out.println("waitUntil begin");
                  //在超时等待期间可以被唤醒,超时自动唤醒
                  condition.awaitUntil(new Date(System.currentTimeMillis()+10000L));
                  System.out.println("waitUntil end");
              }catch (InterruptedException e){
                  System.out.println("InterruptedException");
              }finally {
                  lock.unlock();
              }
          }
        };
        Thread t2 = new Thread(){
          public void run(){
              lock.lock();
              try{
                  System.out.println("signal begin:"+System.currentTimeMillis());
                  //condition.signalAll();
                  System.out.println("signal end:"+System.currentTimeMillis());
              }finally {
                  lock.unlock();
              }
          }
        };
        t.start();
        t2.start();
    }
}
