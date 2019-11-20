package designpattern.proxypattern;

/**
 * 静态代理被代理类
 * */
public class RunProxyed implements Run {
    @Override
    public void run() {
        System.out.println("我是被代理类");
    }
}
