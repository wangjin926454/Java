package java_volume.java_volume_2_1.optional;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 基本类型流
 * byte short char boolean int 直接使用IntStream float使用DoubleStream，Long使用LongStream
 *
 * 基本类型流与对象流差异:
 * 1.toArray返回的是基本类型
 * 2.产生可选结果的方法会返回一个OptionalInt、OptionalLong、OptionalDouble,具有getAsInt、getAsLong、getAsDouble方法
 *      而不是get方法
 * 3.具有返回综合、平均值、最大值、最小值的sum、avg、max、min方法、对象流没有定义这些方法
 * 4.summaryStatistics方法会产生一个类型为IntSummaryStatistics、LongSummaryStatistics、DoubleSummaryStatistics
 *      它们可以同时报告流的综合、平均值、最大值、最小值。
 * */
public class BasicStreamlTest {
    public static void main(String[] args) throws IOException {
        IntStream intStream = IntStream.of(1,2,3,45,6,7,89,10);                 //创建一个基本类型流
        //Stream stream = Arrays.stream(values,from,to);  //values是一个数组
        IntStream intStream1 = IntStream.range(0,100);      //产生一个0-99的流
        IntStream intStream2 = IntStream.rangeClosed(0,100);//产生一个0-100的流
        intStream1.forEach(System.out::println);
        intStream2.forEach(System.out::println);
        Path path = Paths.get("C:\\Users\\Administrator\\a.txt");
        String[] strs = new String(Files.readAllBytes(path), StandardCharsets.UTF_8).split("\\PL");
        //mapToInt mapToLong mapToDouble 将对象流转为基本类型流
        IntStream s  = Stream.of(strs).mapToInt(String::length);
        s.forEach(System.out::println);
        //boxed方法将基本流转换为对象流
        Stream stream = s.boxed();
    }
}
