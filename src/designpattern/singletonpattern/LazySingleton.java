package designpattern.singletonpattern;
/**
 * 懒汉式单例模式
 * */
public class LazySingleton {
    private static LazySingleton lazySingleton;
    private LazySingleton(){

    }
    /**加synchronized关键字表示线程安全*/
    public static LazySingleton getInstance(){
        if(lazySingleton==null){
            lazySingleton=new LazySingleton();
        }
        return lazySingleton;
    }
}
