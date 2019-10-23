package designpattern.proxypattern.runtimeproxy;

public class RuntimeProxyed1 implements Runtime {
    @Override
    public void runtime() {
        System.out.println("runtime 1 ");
    }

    @Override
    public String eat(String a) {
        System.out.println("Runtime 1");
        return a;
    }
}
