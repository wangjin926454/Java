package stringsourcecode;

import java.util.Arrays;

public class StringSourceCodeDemo {
    //数组拷贝用System.arraycopy而不用Arrays.copyOf();
    public static void main(String[] args){
        /*long be = System.currentTimeMillis();
        String  a = "wangjin";
        char[] aa = a.toCharArray();
        char[] result =new char[aa.length];
        System.arraycopy(aa,0,result,0,a.length());
        System.out.println(System.currentTimeMillis()-be);
        System.out.println(result);
*/
        String a = "tsst";
        //返回index的unicode码
        System.out.println(a.codePointAt(2));
        //返回index前一个字符的unicode码
        System.out.println(a.codePointBefore(2));
        //equals与equalsIgnoreCase区别:区分大小写与不区分大小写
        String a1 = "wangjin";
        String a2 = "WANGJIN";
        System.out.println(a1.equals(a2));          //false
        System.out.println(a1.equalsIgnoreCase(a2));//true
        //equals与contentEquals:equals()后面必须为String类型
        String s1="123";
        String s2=new String("123");
        StringBuilder sb=new StringBuilder("123");
        System.out.println(s1.equals(s2));			//true
        System.out.println(s1.contentEquals(s2));	//true
        System.out.println(s1.equals(sb));			//false
        System.out.println(s1.contentEquals(sb));	//true
        //重写equals时一定要重写hashcode的原因
        //<a href="https://blog.csdn.net/qq_35125495/article/details/89636757">原因</a>
        System.out.println("ssss".hashCode());
    }
}
