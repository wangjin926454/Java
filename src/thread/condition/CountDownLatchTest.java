package thread.condition;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    private static final CountDownLatch cdl = new CountDownLatch(10);
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(){
            public void run(){
                for(int i=0;i<10;i++){
                    System.out.print("countDownLatch "+i+",");
                    cdl.countDown();
                }
            }
        };
        t.start();
        //cdl.await();
        cdl.await(1000, TimeUnit.MILLISECONDS);
        System.out.println();
        System.out.println("countDownLatch over");
    }
}
