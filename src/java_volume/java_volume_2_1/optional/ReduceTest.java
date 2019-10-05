package java_volume.java_volume_2_1.optional;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * 约简操作
 * */
public class ReduceTest {
    public static void main(String[] args)throws Exception{
        //reduce方法
        List<Integer> list = Arrays.asList(1,2,3,4,5,67,8,900,10);
        //List<Integer> list1 = Arrays.asList(0);
        //reduce方法会接收一个二元函数,并从前两个元素中持续应用它.例如下面这个行数将会对list中元素进行sum操作
        Optional<Integer> sum = list.stream().reduce(Integer::sum);
        Integer integer = sum.orElse(-1);
        System.out.println(integer);

        List<String> list1 = new ArrayList<>();
        list1.add("wangjin");
        list1.add("wangjin1");
        Optional<String> optional3 = list1.stream().filter(s -> s.contains("w")).findFirst();
        List<String> list2 = new ArrayList<>();
        //如果optional3有返回值则added中增加一个元素true，否则返回一个Optional.empty;
        //如果optional3有返回值则list中增加optional3的toString()值
        Optional<Boolean> added = optional3.map(list2::add);
        System.out.println(list2);
        System.out.println(added);

        List<String> list3 = Arrays.asList("wangjin");
        //使用orElse时不管Optional中是否为空都会执行后面的方法
        String s1 = list3.stream().findAny().orElse(b());
        System.out.println("orElse "+s1);
        //使用orElseGet时只有Optional中为空才会执行后面的方法
        String s = list3.stream().findAny().orElseGet(ReduceTest::b);
        System.out.println("orElseGet "+s);
        //如果流为空， 返回reduce中初始化的值
        /*Integer sum1 = list.stream().reduce(0,(x,y)-> x+y);
        System.out.println(sum1);
        Path path = Paths.get("C:\\用户\\Administrator\\a.txt");
        String str = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        String[] strs = str.split("\\PL");
        //总的加上第一个单词的长度，再加上第二个单词的长度一直相加
        int result = Stream.of(strs).reduce(0,(total,word)->total+word.length(),(total,total1)->total+total1);
        System.out.println(result);*/
    }

    public static String b(){
        System.out.println("b()......");
        return "b";
    }
}
