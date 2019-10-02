package designpattern.proxypattern.runtimeproxy;

public class RuntimeProxyed implements Runtime {
    @Override
    public void runtime() {
        System.out.println("Runtime");
    }

    @Override
    public String eat(String a) {
        System.out.println("I like eat "+a);
        return a;
    }
}
