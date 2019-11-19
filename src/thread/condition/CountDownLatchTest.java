package thread.condition;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch  调用CountDownLatch.await()后，必须等待计数器为0之后才执行自身
 * */
public class CountDownLatchTest {
    private static final CountDownLatch cdl = new CountDownLatch(5);
    static int data = 0;
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(){
            public void run(){
                for(int i=0;i<10;i++){
                    System.out.print("countDownLatch "+i+",");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    data = i;
                    cdl.countDown();
                }
            }
        };
        t.start();
        cdl.await();
        //cdl.await(1000, TimeUnit.MILLISECONDS);
        System.out.println();
        System.out.println("countDownLatch over,cdl="+data);
    }
}
