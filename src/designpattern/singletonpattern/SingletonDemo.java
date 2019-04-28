package designpattern.singletonpattern;

import java.lang.reflect.Constructor;

public class SingletonDemo {
    public static void main(String[] args){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    EnumSingleton.SINGLETON.whateverMethod();
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
        try {
            NotLazySingleton s = NotLazySingleton.getInstance();
            Class c = Class.forName("designpattern.singletonpattern.NotLazySingleton");
            Constructor[] con = c.getDeclaredConstructors();
            Constructor conc = con[0];
            //setAccessible将此对象的 accessible 标志设置为指示的布尔值。
            //值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。
            //值为 false 则指示反射的对象应该实施 Java 语言访问检查。
            conc.setAccessible(true);
            //反射可以访问饿汉式单例模式，所以最好用枚举创建单例模式
            NotLazySingleton ss = (NotLazySingleton)conc.newInstance(null);
            System.out.println(s+"/"+ss);
            System.out.println(s==ss);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception ee){
            ee.printStackTrace();
        }
    }
}
