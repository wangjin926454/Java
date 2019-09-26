package java_volume.java_volume_2_1.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaTest1 {

    public static void main(String[] args){

        Consumer<Double> consumer = d -> System.out.println(d);
        happyTime(300.0,consumer);

        List<String> list = Arrays.asList("aaaaa","aaab","aaaac","dddd","eeeee");
        /*List<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("a");
            }
        });*/
        //List<String> list1 = filterString(list,s->s.contains("a"));
        List<String> list1 = filterString(list,s->s.contains("a"));
        System.out.println(list1);
    }
    public static void happyTime(Double d, Consumer<Double> consumer){
        consumer.accept(d);
    }

    public static List<String> filterString(List<String> list, Predicate<String> pre){
        List<String> list1 = new ArrayList<>();
        for(String s:list){
            if(pre.test(s)){//pre.test(s)在上面lambda表达式中已经实现
                list1.add(s);
            }
        }
        return list1;
    }
}
