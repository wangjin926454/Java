package permission;


import permission.aotherpackage.Demo1;

public class Demo extends Demo1 implements Cloneable{

    public static void main(String[] args)throws Exception{
        Demo demo = new Demo();
        //demo.test();
        Object object = demo.clone();
        System.out.println(object.getClass().equals(demo.getClass()));
        System.out.println(object.equals(demo));
        System.out.println(object.toString());

    }
}
