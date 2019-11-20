package java_volume.java_volume_2_1.optional;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * 群组和分区
 * */
public class GroupingByTest {
    public static void main(String[] args){
        Stream<Locale> stream = Stream.of(Locale.getAvailableLocales());            //获取所有国家转换为stream
                                                                //Collectors.groupingByConcurrent()与toConcurrent方法完全类似
        Map<String, List<Locale>> countyToLocales = stream.collect(Collectors.groupingBy(Locale::getCountry));  //按照国家分组
        List<Locale> list = countyToLocales.get("CH");
        list.forEach(System.out::println);

        //当分类函数是断言函数(即返回boolean值的函数时)
        Stream<Locale> stream1 = Stream.of(Locale.getAvailableLocales());
        Map<Boolean,List<Locale>> list1 = stream1.collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
        List<Locale> list2 = list1.get(true);
        list2.forEach(System.out::println);

        //groupingBy会产生一个映射表,它的每一个值都是一个列表,如果想要以某种方式来处理这些列表
        //就需要提供一个下游收集器，例如想要获得set而不是map。那么可以使用Collections.toSet收集器
        Stream<Locale> stream2 = Stream.of(Locale.getAvailableLocales());
        //Map<String, Set<Locale>> map = stream2.collect(Collectors.groupingBy(Locale::getCountry,toSet()));

        //产生收集到的个数
        Map<String, Long> collect = stream2.collect(groupingBy(Locale::getCountry, counting()));
        for(String str:collect.keySet()){
            System.out.print(str+"  ");
            System.out.println(collect.get(str));
        }
        //summing(Int|Long|Double)接收一个函数作为引元。将该函数应用到下游元素中,并产生他们的和
        //maxBy和minBy接收一个比较器。产生下游元素中最大值以及最小值

        //mapping方法会产生将函数应用到下游结果上的收集器
        //Map<String,Set<String>> map2 = stream2.collect(Collectors.groupingBy(Locale::getDisplayCountry,mapping(Locale::getDisplayLanguage,toSet())));
        //如果群组和映射函数的返回值为int，long或double那么可以将元素收集汇总到统计对象中
        //Map<String, IntSummaryStatistics> map3 = stream.collect(Collectors.groupingBy(Locale::getDisplayCountry,summarizingInt(Locale::getDisplayLanguage)));

    }
}
