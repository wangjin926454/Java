package designpattern.proxypattern.runtimeproxy;

import java.util.Properties;

public class RuntimeTest {
    public static void main(String[] args){

        Properties properties = System.getProperties();
        properties.put("sun.misc.ProxyGenerator.saveGeneratedFiles",true);
        RuntimeProxyed rp = new RuntimeProxyed();
        RuntimeProxyed1 rp1 = new RuntimeProxyed1();
        Runtime runtime  = (Runtime) RuntimeProxy.getProxyInstance(rp1);
        runtime.runtime();
    }
}
