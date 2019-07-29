package java_volume_2_1.stream;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterMapFlatMap {
    public static void main(String[] args) throws Exception{
        String string = new String(Files.readAllBytes(Paths.get("C:\\Users\\Administrator\\a.txt")),StandardCharsets.UTF_8);
        Stream.of(string.split("\\PL+")).map(String::toUpperCase).forEach(x -> System.out.print(x+" "));        //每一个单词都转换为大写并返回一个流
        System.out.println();

        Stream.of(string.split("\\PL+")).limit(5).forEach(x ->System.out.print(x + " "));       //选择前五个元素返回一个新的流
        System.out.println();

        Stream.of(string.split("\\PL+")).skip(5).forEach(x ->System.out.print(x+" "));      //跳过前5个元素返回剩下的元素组成的流
        System.out.println();

        Stream.of(string.split("\\PL+")).map(a -> a.length()>10).forEach(x -> System.out.print(x+" "));     //遍历长度大于10的返回true，否则false
        System.out.println();

        List<String> list  = Stream.of(string.split("\\PL+")).map(String::toUpperCase).collect(Collectors.toList());        //转换为大写并返回一个list
        list.forEach(a ->System.out.print(a+" "));
        System.out.println();

        Stream<String> distinctStream = Stream.of("bj","shanghai","tianjin","bj","shanghai").distinct();
        distinctStream = distinctStream.sorted(Comparator.comparing(String::length));   //排序并去重  默认升序
        distinctStream.forEach(a -> System.out.print(a + " "));
        System.out.println();

        Stream<String> distinctStream1 = Stream.of("bj","shanghai","tianjin","bj","shanghai").distinct();
        distinctStream1 = distinctStream1.sorted(Comparator.comparing(String::length).reversed());   //排序并去重  默认升序
        distinctStream1.forEach(a -> System.out.print(a + " "));
        System.out.println();

        String[] strings = {"wang"};
        String[] strings1 = {"jin"};
        Stream<String> stream  = Stream.concat(Arrays.stream(strings),Arrays.stream(strings1));     //两个流相加
        stream.forEach(x -> System.out.print(x+" "));
        System.out.println();

        /*Object[] powers = */Stream.iterate(1.0, p -> p*2).peek( e -> System.out.println("Fetching"+ e)).limit(20).forEach(x -> System.out.print(x+" "));

    }
}
