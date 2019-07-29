package java_volume.java_volume_1_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * CollectionToArrayTest
 * String[] = (String[]) list.toArray()是错的。
 * */
public class CollectionToArrayTest {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        for(int i=0;i<50;i++){
            list.add(Integer.toString(i));
        }
        //String[] strs = list.toArray(new String[0]);   //会创建一个新的数组
        //String[] strs = (String[]) list.toArray();  //java.lang.ClassCastException
        String[] strs = list.toArray(new String[list.size()]);  //不会创建新的数组
        for(String s: strs){
            System.out.println(s);
        }
    }
}
