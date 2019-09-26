package designpattern.proxypattern;

/**
 * 静态代理代理类
 * */
public class RunProxy implements Run{
    private RunProxyed  run;
    RunProxy(){
        this.run = new RunProxyed();
    }

    @Override
    public void run() {
        System.out.println("代理类开始");
        run.run();
        System.out.println("代理类结束");
    }
}
