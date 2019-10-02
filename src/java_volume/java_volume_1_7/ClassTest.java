package java_volume.java_volume_1_7;

/**
 * 获取Class实例
 * */
public class ClassTest {
    public static void main(String[] args)throws Exception{
        Class class1 = ClassTest.class;
        ClassTest classTest = (ClassTest) class1.newInstance();
        System.out.println(classTest);
        System.out.println(class1.toString());
        Class class2 = new ClassTest().getClass();
        System.out.println(class2);
        Class class3 = Class.forName("java_volume.java_volume_1_7.ClassTest");
        System.out.println(class3);
    }
}
