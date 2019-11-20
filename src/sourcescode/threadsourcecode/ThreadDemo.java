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
        System.out.println(this);       //Thread[wangjin,10,main][name,Priority,main]
        System.out.println("t1 runnable:"+this.getState());
        System.out.println("test");
        System.out.println(this.isDaemon());
    }

    public static void main(String[] args){
        ThreadDemo t = new ThreadDemo(143L);
        ThreadDemo t1 = new ThreadDemo(120L);
        Thread t2 = new Thread(){
          public void run(){
              System.out.println("new Thread() test");
          }
        };
        t2.start();
        t.setDaemon(true);
        t.setName("wangjin");
        t.setPriority(10);
        t1.setDaemon(false);
        t1.setName("wangjin1");
        t1.setPriority(1);
        t.start();
        t1.start();
        System.out.println("t1 before:"+t1.getState());      //RUNNABLE
        System.out.println("t before:"+t.getState());       //
        System.out.println(t1.getContextClassLoader());     //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(t1.getClass());      //class sourcescode.threadsourcecode.ThreadDemo
        //System.out.println(Thread.isDaemon());
        //System.out.println(Thread.getAllStackTraces());
        //System.out.println(Thread.);
    }
}
