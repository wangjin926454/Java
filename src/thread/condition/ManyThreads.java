package thread.condition;

public class ManyThreads {
    public static void main(String[] args){
        Thread t = new Thread(){
            public void run(){
                System.out.println("test");
            }
        };
        t.start();
        t.getState();
    }
}
