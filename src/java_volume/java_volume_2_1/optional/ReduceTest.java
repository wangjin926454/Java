package java_volume.java_volume_2_1.optional;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
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
        if(sum.isPresent()){
            System.out.println(sum.get());
        }
        //如果流为空， 返回reduce中第一个参数的值
        Integer sum1 = list.stream().reduce(0,(x,y)->x+y);

        Path path = Paths.get("C:\\Users\\Administrator\\a.txt");
        String str = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        String[] strs = str.split("\\PL");
        //总的加上第一个单词的长度，再加上第二个单词的长度一直相加
        int result = Stream.of(strs).reduce(0,(total,word)->total+word.length(),(total,total1)->total+total1);
        System.out.println(result);
    }
}
