package java_volume.java_volume_1_7;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest1 {
    public static void main(String[] args) throws Exception{
        Class p = Class.forName("java_volume.java_volume_1_7.ReflectTest");
        //获取父类的类限定名
        System.out.println(p.getSuperclass().getName());
        //获取所有的接口
        Class<?>[] c = p.getInterfaces();
        System.out.println("实现的接口有----");
        for(Class c1:c){
            System.out.print(c1.getName()+" ");
        }
        System.out.println("实现接口结束");
        //获取所有构造函数
        Constructor<?>[] cs = p.getConstructors();
        for(int i=0;i<cs.length;i++){
            //获取每一个构造函数中参数类型
            Class<?>[] c2  = cs[i].getParameterTypes();
            for(int j=0;j<c2.length;j++){
                if(j==c2.length-1){
                    System.out.print(c2[j].getName());
                }else{
                    System.out.print(c2[j].getName()+",");
                }
            }
        }
        //获取所有public
        System.out.println();
        System.out.println("获取所有public参数");
        Field[] fields = p.getFields();
        for (Field f:fields){
            System.out.println(f.toGenericString());
        }
        System.out.println("获取所有参数");
        Field[] fields1 = p.getDeclaredFields();
        for (Field f:fields1){
            System.out.println(f.toGenericString());
        }
        //获取所有方法
        Method[] methods = p.getMethods();
        System.out.println("获取所有方法信息");
        for(int i=0;i<methods.length;i++){
            Class<?> returnType = methods[i].getReturnType();
            Class<?> param[] = methods[i].getParameterTypes();
            int temp = methods[i].getModifiers();
            //获取方法修饰符
            System.out.print(Modifier.toString(temp)+" ");
            //获取返回值
            System.out.print(returnType.getName()+" ");
            //获取方法名
            System.out.print(methods[i].getName()+" ");
            System.out.println();
            for(int j=0;j<param.length;j++){
                //获取方法参数
                System.out.println("获取方法参数");
                System.out.println(param[j].getName()+" "+"arg"+j);
                if(j<param.length-1){
                    System.out.print(",");
                }
            }
        }
        //反射调用
        System.out.println("反射调用");
        Method method = p.getMethod("test1",String.class);
        method.invoke(p.newInstance(),"invoke test1");
        System.out.println("private 属性设置");
        ReflectTest phoneTest =(ReflectTest) p.newInstance();
        Field field = p.getDeclaredField("str");
        field.setAccessible(true);
        field.set(phoneTest,"access private str");
        System.out.println(phoneTest.getStr());
    }
}
