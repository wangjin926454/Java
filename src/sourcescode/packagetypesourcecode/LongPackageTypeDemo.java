package sourcescode.packagetypesourcecode;

/**
 * long package type demo
 * */
public class LongPackageTypeDemo {
    public static void main(String[] args){
        System.out.println(Long.SIZE);      //64 bit
        System.out.println(Long.BYTES);     //8bytes
        System.out.println(System.currentTimeMillis());
        System.out.println(Long.getLong("wangjin",System.currentTimeMillis()));
    }
}
