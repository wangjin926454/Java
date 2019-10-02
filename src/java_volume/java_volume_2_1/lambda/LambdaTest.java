package java_volume.java_volume_2_1.lambda;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaTest {
    public static void main(String[] args){

        /*Runnable接口中只有一个实现方法，实现方法没有形参所以直接()-> */
        Runnable r = () -> System.out.println("test");
        new Thread(r).start();

        Consumer<String> con = new Consumer<String>(){
            @Override
            public void accept(String o) {
                System.out.println(o);
            }
        };
        con.accept("Consumer test");
        //若只有一个参数，参数类型可以不写，括号可以不写。这些都可以自动类型推断
        Consumer<String> con1 = (String s) -> System.out.println(s);
        con1.accept("lambda consumer test");

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        Comparator<Integer> comparator1 = (o1,o2)->{
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1,o2);
        };
        System.out.println(comparator1.compare(4,3));

        //简写->只有一天return语句可以不写大括号跟return 默认 return值
        //Comparator<Integer> comparator2 = (o1,o2) -> o1.compareTo(o2);
        Comparator<Integer> comparator2 = Integer::compare;//直接使用已经实现的方法
        System.out.println(comparator2.compare(4,3));

        Function<Double,Long> function = Math::round;   //调用静态方法
        System.out.println(function.apply(20.3));

        Comparator<String> comparator3 = String::compareTo;
        System.out.println(comparator3.compare("a","b"));

    }
}
