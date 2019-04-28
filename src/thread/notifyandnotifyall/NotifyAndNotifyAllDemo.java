package thread.notifyandnotifyall;

/**
 * @author Administrator
 * 线程状态:
 * NEW:刚刚创建但没有调用start方法
 * RUNNABLE:就绪,就差CPU调用
 * BLOCKED:被调用,但是其他线程正在synchronized代码中
 * WAITING:等待状态,等待其他线程notify或中断
 * TIME-WAITING:sleep(timeout)或wait(timeout)自动唤醒
 * TERMINATED:终止线程
 * 调用join()和sleep()方法，sleep()时间结束或被打断，join()中断,IO完成都会回到Runnable状态，等待JVM的调度。
 * 调用wait()，使该线程处于等待池(wait blocked pool),直到notify()/notifyAll()，
 * 线程被唤醒被放到锁定池(lock blocked pool )，
 * 释放同步锁使线程回到可运行状态（Runnable）
 * 对Running状态的线程加同步锁(Synchronized)使其进入(lock blocked pool ),同步锁被释放进入可运行状态(Runnable)。
 * */
public class NotifyAndNotifyAllDemo {
    static boolean flag = false;
    private static Object obj = new Object();
    public static void main(String[] args)throws Exception{
        Thread t1 = new Thread(new A());
        Thread t2 = new Thread(new B());
        Thread t3 = new Thread(new C());
        Thread t4 = new Thread(new D());
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(2000);
        //flag=true;
        t4.start();
    }
    static class A implements Runnable{

        @Override
        public void run() {
            synchronized (obj){
                while(!flag){
                    try{
                        obj.wait();
                        System.out.println("Thread 1");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class B implements Runnable{

        @Override
        public void run() {
            synchronized (obj){
                while(!flag){
                    try{
                        obj.wait();
                        System.out.println("Thread 2");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class C implements Runnable{

        @Override
        public void run() {
            synchronized (obj){
                while(!flag){
                    try{
                        obj.wait();
                        System.out.println("Thread 3");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class D implements Runnable{

        @Override
        public void run() {
            synchronized (obj){
                flag=true;
                // t1 t2 t3自由发挥抢cpu时间全部处于RUNNABLE状态
                //obj.notifyAll();
                //唤醒一个,但不确定是谁，其他线程处于WAITING状态
                obj.notify();
            }
        }
    }
}
