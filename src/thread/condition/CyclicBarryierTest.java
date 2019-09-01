package thread.condition;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CyclicBarryierTest {
    private static final CyclicBarrier cb = new CyclicBarrier(10);
    private static final Lock lock = new ReentrantLock();
    private static Condition condition  = lock.newCondition();
    public static void main(String[] args) throws Exception{
        for(int j=0;j<10;j++){
            Thread t = new Thread(){
                public void run(){
                    try{
                        System.out.println("await");
                        cb.await();
                    } catch (InterruptedException ie){
                        System.out.println("InterruptedException");
                    } catch (BrokenBarrierException bbe){
                        System.out.println("BrokenBarrierException");
                    } finally {
                        System.out.println("finally ");
                    }
                }
            };
            t.start();
        }
    }
}
