package sourcescode.packagetype;

import java.util.Scanner;

/**
 * int package type source code 
 * */
public class IntegerPackageTypeDemo {
    //String to String[], each field is binaryString
    static String[] toBinaryString(String str){
        String[] strings = new String[str.length()];
        for(int i=0;i<str.length();i++){
            strings[i] = Integer.toBinaryString(str.charAt(i));     //result to binaryString
        }
        return strings;
    }
    //each binaryString field to char
    static String binStrToChar(String[] strings){
        StringBuffer res = new StringBuffer("");
        for(String str1:strings){
            if(str1.length()==6){
                str1 = Integer.toString(Integer.parseUnsignedInt(str1,2)-48);
                res = res.append(str1);
            }
            if(str1.length()==7){
                //char ch = Character.forDigit(Integer.parseInt(str1),2);
                int a = Integer.parseUnsignedInt(str1,2);
                char ch;
                ch = (char) a;
                res = res.append(Character.toString(ch));
            }
        }
        return res.toString();
    }

    public static void main(String[] args){
        System.out.println(Integer.MIN_VALUE);  //-2147483648
        System.out.println(Integer.MAX_VALUE);  //2147483647
        System.out.println(Integer.TYPE);       //int
        System.out.println(Integer.toString(4,55));
        System.out.println("enter string:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //toBinaryString  char equals int  int-48 == char
        //System.out.println(Integer.toBinaryString(str.charAt(0)));
        //System.out.println(Integer.parseUnsignedInt(strs[0],2)-48);     //-48 equals str
        //System.out.println(Integer.parseInt("1100001",2));      //radix 2 to 10
        //System.out.println(toBinaryString(str));
        String[] ss = toBinaryString(str);
        System.out.println(binStrToChar(ss));
        /*
        Integer.toBinaryString('a')==1100001  length more than 6,
        but Integer.toBinaryString(0-9).length == 6
        * */
        //System.out.println(Integer.toBinaryString('a'));      
        //System.out.println(Integer.toBinaryString('z'));
        //System.out.println(Integer.toBinaryString(""));
        System.out.println(Integer.SIZE);       //32bit
        System.out.println(Integer.BYTES);      //4bytes
        //System.out.println(i.hashCode());
        //System.out.println(Integer.hashCode(4));
    }
}
