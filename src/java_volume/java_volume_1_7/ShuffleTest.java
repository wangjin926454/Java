package java_volume.java_volume_1_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 随机打乱排序
 * */
public class ShuffleTest {
    public static void main(String[] args){
        List<Integer>  list = new ArrayList<>();
        for(int i=0;i<50;i++){
            list.add(i);
        }
        Collections.shuffle(list);
        List<Integer> list1 = list.subList(0,5);
        for(Integer i: list1){
            System.out.println(i);
        }
    }
}
