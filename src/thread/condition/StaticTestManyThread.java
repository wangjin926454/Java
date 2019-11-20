package thread.condition;


/**
 * static变量在内存中只有一份
 * */
public class StaticTestManyThread {
    private static int a = 5;
    private int b = 10;
    private static Thread t ;
    public static void main(String[] args){
        StaticTestManyThread stmt1 = new StaticTestManyThread();
        System.out.println("b="+stmt1.b);
        stmt1.b = 11;
        a = 6;
        t = new Thread(){
            public void run(){
                StaticTestManyThread stmt = new StaticTestManyThread();
                System.out.println("a="+stmt.a);
                stmt.a = stmt.a + 1;
                System.out.println("a="+a);
                System.out.println("b="+stmt.b);
            }
        };
        t.start();
        System.out.println("a="+a);
    }
}
