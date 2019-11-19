package thread.condition;

import java.util.concurrent.Semaphore;
/**
 * java.util.concurrent.Semaphore;
 * 初始化一个容量表示限流的数量,超过此数量当前线程被暂停,需要在finally中释放
 * acquire需要跟release成对使用
 * */
public class SemaphoreTest {
    private static Semaphore semaphore = new Semaphore(10,true);
    public static void main(String[] args){
        Thread t = new Thread(){
            public void run(){
                for(int i=0;i<11;i++){
                    System.out.println("已获得信号量"+i);
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                        System.out.println("已释放信号量"+i);
                    }
                }
            }
        };
        t.start();
    }
}
