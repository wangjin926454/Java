package java_volume.java_volume_2_1.stream.parallelStream;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.groupingByConcurrent;

/**
 * 并行流demo
 * 只要在终结方法执行时，流处于并行模式，那么中间的所有流操作都将被并行化
 * 不要将所有流都转换为并行流只有在对已经位于内存中的数执行大量计算操作时，才应该使用并行流
 * */
public class ParallslStreamTest {
    public static void main(String[] args) throws IOException {
        List<Integer> list = Arrays.asList(1,2,3,4,6,67,8,90);
        //将一个list转换为一个并行流
        Stream<Integer> stream = list.parallelStream();
        Path path = Paths.get("C:\\Users\\Administrator\\a.txt");
        String[] strs = new String(Files.readAllBytes(path), StandardCharsets.UTF_8).split("\\PL");
        int[] arr = new int[20];
        //将一个顺序流转换为并行流
        Stream<String> stream1 = Stream.of(strs).parallel();
        //传递给forEach的函数会在多个并发线程中运行.每个都会更新共享的数组,这是一个经典的竞争情况
        //如果多次运行每一次可能都会产生不同的结果
        stream1.forEach(s->{ if(s.length()<12) arr[s.length()]++;});
        System.out.println(Arrays.toString(arr));
        //如果用长度将字符串群组，然后分别对他们进行计数。那么就可以安全的并行计算
        Map<Integer,Long> map = Stream.of(strs).parallel().filter(s->s.length()<12).collect(groupingBy(String::length,counting()));
        System.out.println(map.toString());
        //默认情况下,从有序集合(数组和列表)、范围、生成器和迭代产生的流，或者通过调用Stream.sorted产生的流都是有序的。
        //计算steam.map(fun)时,流可以划分为n的部分，被并行处理，最后按照顺序重新组装
        //在stream上调用unordered方法明确表示我们对排序不感兴趣。Stream.distinct方法就是这其中之一
        //distinct方法会保留相同元素中的第一个。如果可以接受保留唯一元素中任意一个的做饭，那么所有部分
        //都可以并行地处理（使用共享的集来跟踪重复元素）

        //如果只想从流中任意取出n个元素不在意到底获取那些可以调用
        Stream<String> sample = Stream.of(strs).parallel().unordered().limit(10);

        //流处理合并为map时代价很高昂，正是因为这个原因，Collectors.groupByConcurrent方法使用了ConcurrentHashMap。
        //为了从并行化中收益，map中值得顺序与流中的顺序不会相同
        Map<Integer,List<String>> result = Arrays.asList(strs).parallelStream().collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(result.toString());

        //如果使用独立于排序的下游收集器,就不必在意
        Map<Integer,Long> map1 = Arrays.asList(strs).parallelStream().collect(groupingByConcurrent(String::length,counting()));
        System.out.println(map1.toString());
    }
}
