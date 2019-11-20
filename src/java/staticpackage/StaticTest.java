package java.staticpackage;
/**
 * 1.内部类中只有静态内部类才能够有静态成员变量和方法
 * 2.是在成员的引用上，静态内部类只能访问外部类的静态成员,非静态内部类可以访问外部类的静态和非静态成员
 * 3.在引用对象上，静态内部类可以直接引用，非静态内部类需要用new StaticTest.B()才能引用成员
 * */
public class StaticTest {
    private static String a = "a";
    private String aa = "aa";
    static class A{
        private static String b = "b";
        private String bb1 = "bb";
        public static void test(){
            System.out.println(b);
            System.out.println(a);
            //System.out.println(bb1);
            //报错
            //System.out.println(aa);
        }
    }
    public void test(){
        System.out.println(A.b);
        //报错
        //System.out.println(B.aa);
        System.out.println(new StaticTest.B().aa);
    }
     class B{
        //报错
       // private static String a = "a";
        private String aa = "aa";
        //下面两行报错
        //private static String b = "b";
         //public static void test(){
            //System.out.println(b);
        //}
         public void test(){
             System.out.println(aa);
             System.out.println(a);
         }

    }
}
