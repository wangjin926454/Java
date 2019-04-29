package sourcescode.packagetype;

/**
 * 包装类源码分析
 * */
public class BooleanPackageTypeDemo {
    public static void main(String[] args){
        System.out.println(Boolean.TYPE);       //boolean
        //only true return true
        Boolean a =new Boolean("aaaa");     //false
        System.out.println(a);
        //only true return true
        Boolean b = new Boolean("sss");
        System.out.println(b.booleanValue());   //false
        Boolean b1 = new Boolean(true);
        System.out.println(b1.toString());      //true
        System.out.println(Boolean.toString(false)); //false
        System.out.println(Boolean.hashCode(true)); //true 1231 false 1237
        System.out.println(Boolean.getBoolean("aaa")); //false;
    }
}
