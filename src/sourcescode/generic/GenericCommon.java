package sourcescode.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型中通配符?的使用
 * */
public class GenericCommon {
    public static void main(String[] args){
        List<?> list3 = null;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<4;i++){
            list.add(i);
        }
        print(list);
        List<String> list1 = new ArrayList<>();
        for(int i=0;i<4;i++){
            list1.add(i+"");
        }
        print(list1);
        list3 = list;
        //list3.add("3");   //通配符的不能添加
        list3.add(null);        //无论list是什么类型都可以添加null
    }

    public static void print(List<?> list){
        for(Object o : list){
            System.out.println(o);
        }
    }
//报错。方法中list参数通配符只能用?
/*    public static void print1(List<E> list){
        for(Object o : list){
            System.out.println(o);
        }
    }*/
}
