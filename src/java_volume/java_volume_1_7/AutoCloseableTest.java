package java_volume.java_volume_1_7;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AutoCloseableTest{
    public static void main(String[] args){
        List<String>  list = new ArrayList<>();
        List list2 = Collections.unmodifiableList(list);   //list2为不可更改
        list.add("wangjin");
        System.out.println(list.get(0).toString());
        //list2.add("wangjin1");                              //list2为不可更改、list2.add("wangjin1")会报错
       // System.out.println(list.get(1).toString());
        List list3 = list;
        list3.add(new Date());//不会报错
        System.out.println(list3.get(1));
        List<String> list4 = Collections.checkedList(list,String.class);
        //list4.add(new Date());   受检查的list。检查报错
    }
}
