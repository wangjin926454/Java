package designpattern.proxypattern.runtimeproxy;

public class RuntimeTest {
    public static void main(String[] args){
        RuntimeProxyed rp = new RuntimeProxyed();
        Runtime runtime  = (Runtime) RuntimeProxy.getProxyInstance(rp);
        String a = runtime.eat("rice");
        runtime.runtime();
        System.out.println(a);
    }
}
