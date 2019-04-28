package thread.notifyandnotifyall;

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
