package sourcescode.packagetype;

/**
 * 包装类源码分析
 * */
public class PackageTypeDemo {
    public static void main(String[] args){
        System.out.println(Boolean.TYPE);       //boolean
        //only true return true
        Boolean a =new Boolean("aaaa");     //false
        System.out.println(a);
    }
}
