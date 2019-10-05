package java_volume.java_volume_2_1.optional;
/**
 * 如果catch中推出程序，则finally不会执行
 * */
public class OptionalInfo {
    public static void main(String[] args) {
        OptionalInfo inc = new OptionalInfo();
        int i = 0;
        inc.fermin(i);
        i ++;
        System.out.println(i);
        try {
            throw new RuntimeException();
        }catch(RuntimeException e){
            System.exit(0);
        }finally {
            System.out.println("finally test");
        }
    }
    void fermin(int i){
        i++;
    }
}
