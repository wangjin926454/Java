package sourcescode.enumsourcode;

/**
 * enum source code demo
 * */
public class EnumDemo {
    public enum A {
        SINGLETON,SECOND;
        void doSomething(){
            System.out.println("enum test");
        }
    }
    public static void main(String[] args){
        A.SINGLETON.doSomething();         //enum test
        System.out.println(A.SINGLETON.getDeclaringClass());    //class sourcescode.enumsourcode.EnumDemo$A
        System.out.println(A.SINGLETON.getClass());     //class sourcescode.enumsourcode.EnumDemo$A
        System.out.println(A.SINGLETON.name());     //SINGLETON
        System.out.println(A.values());     //[Lsourcescode.enumsourcode.EnumDemo$A;@2503dbd3
        System.out.println(A.SINGLETON.ordinal());  //0
        System.out.println(A.SECOND.ordinal());     //1
        System.out.println(A.SECOND.equals(A.SINGLETON));   //false
        System.out.println(A.SINGLETON.hashCode());
        System.out.println(A.SECOND.hashCode());
    }
}
