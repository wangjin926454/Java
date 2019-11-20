package java_volume.java_volume_1_7;

/**
 * 泛型擦除桥方法  https://blog.csdn.net/hao_yan_bing/article/details/89447792
 * */
public class BrigeMethodTest {
    public static void main(String[] args){
        Parent<String> parent = new Child();
        /**
         *没有桥方法时。如果此时通过反射可能会反射到父类的sayHello(T value)方法
         * 有了桥方法。jvm会在Child中自动合成sayHello(Object value)方法再调用时就不会反射到父类中此方法
         * */
        parent.sayHello("test");
    }
}

class Parent<T>{
    public void sayHello(T value){
        System.out.println("This is parent class,value is" + value);
    }

    public T getValue(){
        System.out.println("T getValue");
        return null;
    }
}
class Child extends Parent<String>{
    public void sayHello(String value){
        System.out.println("This is child class,value is" + value);
    }

    public String getValue(){
        System.out.println("getValue");
        return null;
    }
}