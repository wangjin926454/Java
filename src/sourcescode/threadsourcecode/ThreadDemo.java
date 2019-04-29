package sourcescode.threadsourcecode;

/**
 * Thread demo
 * */
public class ThreadDemo extends Thread {
    private long min;
    public ThreadDemo(Long min){
        this.min=min;
    }
    public void run(){
        System.out.println(this);
        System.out.println(this.getState());
        System.out.println("test");
    }

    public static void main(String[] args){
        ThreadDemo t = new ThreadDemo(143L);
        ThreadDemo t1 = new ThreadDemo(120L);
        t.setDaemon(true);
        t.setName("wangjin");
        t.setPriority(10);
        t1.setDaemon(false);
        t1.setName("wangjin1");
        t1.setPriority(1);
        t.start();
        t1.start();
        System.out.println(t1.getState());
        System.out.println(t.getState());
        System.out.println(t1.getContextClassLoader());
        System.out.println(t1.getClass());
        //System.out.println(Thread.getAllStackTraces());
        //System.out.println(Thread.);
    }
}
