package thread.extendsandimplements;

/**
 * 使用继承实现多线程不利于共享全局变量
 * */
public class ExtendsThreadTest extends Thread {

    private int a = 5;

    public void run(){
        System.out.println(a--);
    }
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new ExtendsThreadTest().start();
        }
    }
}
