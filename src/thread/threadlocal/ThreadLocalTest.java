package thread.threadlocal;

import thread.Demo3;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.text.SimpleDateFormat;
/**
 * ThreadLocal保持各个线程对sdf的私有
 * ThreadLocal保持各个线程对实例对象的私有。改变互不影响
 * */
public class ThreadLocalTest {
    private static final ThreadLocal<Demo3> demo3 = new ThreadLocal<Demo3>(){
        @Override
        protected Demo3 initialValue(){
            return new Demo3();
        }
    };
    private static final  ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected  SimpleDateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
    public static void main(String[] args){
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        demo3.get().setA(5);
        System.out.println("Demo3 a="+demo3.get().getA());
        System.out.println("1"+sdf.get());
        sdf.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        System.out.println("2"+sdf.get());
        Thread t = new Thread(){
            public  void run(){
                System.out.println("3"+sdf.get());
                System.out.println("Demo3 a1="+demo3.get().getA());
            }
        };
        t.start();
    }
}
