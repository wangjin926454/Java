package designpattern.singletonpattern;

/**
 * 静态单例模式，明确使用懒加载模式时使用
 * */
public class StaticSingleton {
    private static class SingletonHolder{
        private final static StaticSingleton SINGLETON = new StaticSingleton();
    }
    public static StaticSingleton getInstance(){
        return SingletonHolder.SINGLETON;
    }
}
