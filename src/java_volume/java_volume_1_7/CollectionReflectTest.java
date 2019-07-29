package java_volume_1_7;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 利用类型擦除在List<Integer>中插入String值
 * */
public class CollectionReflectTest {
    public static void main(String[] args) throws Exception{
        List<Integer>  list = new ArrayList<>();
        list.add(1);
        Method method = list.getClass().getDeclaredMethod("add",Object.class);
        method.invoke(list,"add");
        method.invoke(list,234.5);
        for(Object o: list){
            System.out.println(o);
        }
    }
}
