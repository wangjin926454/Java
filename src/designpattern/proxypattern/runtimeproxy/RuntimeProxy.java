package designpattern.proxypattern.runtimeproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RuntimeProxy {

    public static Object getProxyInstance(Object obj){

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String methodName = method.getName();
                        System.out.println("method begin "+methodName+"   ");
                        Object result = method.invoke(obj,args);
                        System.out.println("method end "+methodName+"    ");
                        return result;
                    }
                });
    }
}





