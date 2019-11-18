package thread.extendsandimplements;

/**
 * 使用Runnable实现多线程可以实现共享一个全局变量
 * */
public class ImplementsThreadTest implements  Runnable{

    private int a = 5;

    @Override
    public void run() {
        System.out.println(a--);
    }

    public static void main(String[] args) {
        ImplementsThreadTest test = new ImplementsThreadTest();
        for(int i=0;i<5;i++){
            new Thread(test).start();
        }
    }
}
