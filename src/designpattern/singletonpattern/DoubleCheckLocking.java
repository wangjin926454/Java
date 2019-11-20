package designpattern.singletonpattern;
/**
 * DoubleCheckLocking
 * */
public class DoubleCheckLocking {
    private static volatile DoubleCheckLocking singletonPattern;
    private DoubleCheckLocking(){
    }
    public static DoubleCheckLocking getInstance(){
        if(singletonPattern == null){
            synchronized (DoubleCheckLocking.class){
                if(singletonPattern==null){
                    singletonPattern = new DoubleCheckLocking();
                }
            }
        }
        return singletonPattern;
    }
}
