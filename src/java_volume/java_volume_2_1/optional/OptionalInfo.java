package java_volume.java_volume_2_1.optional;
/**
 * stream处理结果为Optional(约简)类型
 * 本包是处理约简使其返回在程序中可用的结果
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
