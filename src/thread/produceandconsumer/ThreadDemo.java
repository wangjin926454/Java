package thread.produceandconsumer;

public class ThreadDemo {
    /*
    用来锁死线程.当obj为wait时produce线程无法执行相当于等待
    当obj.notify()唤醒时consumer线程执行相当于唤醒
    * */
    static final Object obj = new Object();
    private static  boolean FLAG = false;

    public static void main(String[] args)throws Exception{
        Thread t = new Thread(new Produce());
        Thread t1 = new Thread(new Consumer());
        t1.start();
        Thread.sleep(1000);
        t.start();
    }

    static class Produce implements Runnable{

        @Override
        public void run() {
            synchronized (obj){
                System.out.println("进入生产者");
                System.out.println("生产");
                try{
                    Thread.sleep(1000);
                    FLAG = true;
                    Thread.sleep(5000);
                    obj.notify();
                    System.out.println("生产完成");
                }catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println("退出生产者");
            }
        }
    }
    static class Consumer implements Runnable{

        @Override
        public void run() {
           synchronized (obj){
               System.out.println("进入消费者");
               while(!FLAG){
                    try{
                        System.out.println("还没生产,进入等待");
                        obj.wait();
                        System.out.println("开始消费");
                        System.out.println("消费完成");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
               }
               System.out.println("退出消费者");
           }
        }
    }

}
