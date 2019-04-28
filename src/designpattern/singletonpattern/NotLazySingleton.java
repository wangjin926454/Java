package designpattern.singletonpattern;

/**
 * 饿汉式单例模式。线程安全但是达不到懒加载效果<br>
 * 常用.已经决定使用单例模式可以直接实例化<br>
 * */
public class NotLazySingleton{
    private static NotLazySingleton singleton = new NotLazySingleton();
    private NotLazySingleton(){
    }
    public static NotLazySingleton getInstance(){
        return singleton;
    }
}
