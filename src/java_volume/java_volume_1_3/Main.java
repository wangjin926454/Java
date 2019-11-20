package java_volume.java_volume_1_3;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        System.out.println(StrictMath.sqrt(4));  //结果更加准确。失去一些性能
        System.out.println(Math.round(9.887));      //10 四舍五入 返回long
        System.out.println(Math.round(-11.887));     //-12
        short s1 = 1;
        //short s2 = s1 + 1;         // error
        System.out.println(s1 += 1);
        System.out.println(3>5 && 4>5); //左边为假则不继续判断
        System.out.println(3>5 & 4>5);  //左边不管真假右边都继续判断
        System.out.println(10>>2);  //10 == 1010  右移两位后为 0010==2
        System.out.println(Integer.toBinaryString(2));  //10
        System.out.println(Integer.toBinaryString(-2)); //11111111111111111111111111111101 取反末位+1 == 11111111111111111111111111111110
        System.out.println(Size.MEDIUM); // MEDIUM
        System.out.println(Size.MEDIUM.ordinal());  // 1
        System.out.println("WANGJIN".equalsIgnoreCase("wangjin"));  //不区分大小写的equals
        String str = null;
        System.out.println(str!=null && str.length()!=0);  //好处。短路判断不为空则可以进行后面判断，防止出现空指针异常
        String str1 = "HELLO";
        System.out.println(str1.codePointCount(0,str1.length())); //5个码点
        System.out.println(str1.charAt(0));         //H
        // 码点数为 76。码点和码点单元。即字符和字节。
        // 有的字符占一个字节，有的为两个字节。即有的码点有两个码点单元
        System.out.println(str1.codePointAt(3));
        System.out.println(Math.pow(16,4)); //65536
        //遍历特殊字符码点,Character.isSupplementaryCodePoint判断是否是辅助码点，即两个字节码点
        int i = 0;
        int cp = str1.codePointAt(i);
        if(Character.isSupplementaryCodePoint(cp)){
            i+=2;
        }else
            i+=1;
    }
    enum Size {SMALL,MEDIUM,LARGE,EXTRA_LARGE};

}
