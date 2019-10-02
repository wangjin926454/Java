package sourcescode.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型方法测试
 * */
public class GenericMethodTest {

    /**
     * 泛型方法。共用只能用A-Z
     * */
    public  <T> List<T> fromArrayToList(T[] t){
        List<T> list = new ArrayList<>();
        for(T t1:t){
            list.add(t1);
        }
        return list;
    }

    public static void main(String[] args){
        GenericMethodTest test = new GenericMethodTest();
        List<Integer> integers = test.fromArrayToList(new Integer[]{1, 2, 3, 4});
        List<String> integers1 = test.fromArrayToList(new String[]{"A","b","C","d"});
        System.out.println(integers);
        System.out.println(integers1);
    }
}
