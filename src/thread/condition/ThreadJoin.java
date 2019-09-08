package thread.condition;

public class ThreadJoin {
    private static Thread t ;
    private static Thread t1;
    public static void main(String[] args) throws Exception {
        t = new Thread(){
            public void run(){
                try {
                    Thread.sleep(5000);
                    System.out.println(t1.getState());
                } catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("t running");
            }
        };
        t1 = new Thread(){
            public void run(){
                try {
                    t.join();
                } catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("t1 running");
            }
        };
        System.out.println("Thread start");
        t.start();
        t1.start();
        //t sleep 10000,over仍然在t running 后面输出。join()方法表示必须当前线程执行完毕。其他线程才有机会执行
        System.out.println("over");
    }
}
