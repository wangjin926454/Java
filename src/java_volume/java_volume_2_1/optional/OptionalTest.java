package java_volume.java_volume_2_1.optional;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class OptionalTest {
    public static void main(String[] args) throws Exception{
        String string = new String(Files.readAllBytes(Paths.get("C:\\Users\\Administrator\\a.txt")), StandardCharsets.UTF_8);
        Optional<String> optional = Stream.of(string.split("\\PL+")).max(String::compareToIgnoreCase);
        System.out.println("largest: "+optional.orElse(""));    //如果optional为空则返回""

        Stream<String> stream = Stream.of(string.split("\\PL+"));
        Optional<String> optional1 = stream.filter(s->s.startsWith("f")).findFirst();  //获得stream中以"f"开头的第一个单词的约简
        System.out.println(optional1);

        Stream<String> stream1 = Stream.of(string.split("\\PL+"));
        Optional<String> optional2 = stream1.filter(s->s.startsWith("f")).findAny();  //获得stream中以"f"开头的单词的约简不必要求是第一个
        System.out.println(optional2);
        //anyMatch()存在匹配则返回true
        //allMatch()都匹配则返回true
        //noneMatch()不存在匹配则返回true

        Stream<String> stream3 = Stream.of(string.split("\\PL+"));
        System.out.println(stream3.filter(s -> s.startsWith("F")).findFirst().orElse("5"));     //如果有以"F"开头的单词则返回第一个，没有则返回5

        Stream<String> stream4 = Stream.of(string.split("\\PL+"));
       // 如果有以"F"开头的单词则返回输出，没有则执行Locale.getDefault().getDisplayName()
        System.out.println(Thread.currentThread() + stream4.filter(s -> s.startsWith("F")).findFirst().orElseGet(()-> Locale.getDefault().getDisplayName()));  //


        Stream<String> stream6 = Stream.of(string.split("\\PL+"));
        // 如果有以"F"开头的单词则输出x+"5"
        stream6.filter(s -> s.startsWith("f")).findFirst().ifPresent( x ->System.out.println(x+"5"));

        Optional<String> optional3 = Stream.of(string.split("\\PL+")).filter(x->x.contains("F")).findFirst();
        // 如果有以"F"开头的单词则
        if(optional3.isPresent()){
            optional3.get().length();  //get获取类型，然后可以使用对应的类方法
        }
        List<String> list = new ArrayList<>();
        //如果optional3有返回值则added中增加一个元素true，否则返回一个Optional.empty;
        //如果optional3有返回值则list中增加optional3的toString()值
        Optional<Boolean> added = optional3.map(list::add);
        System.out.println(list);
        System.out.println(added);

        Stream<String> stream5 = Stream.of(string.split("\\PL+"));
        // 如果有以"F"开头的单词则返回输出，没有则抛出一个异常
        System.out.println(stream5.filter(s -> s.startsWith("F")).findFirst().orElseThrow(NumberFormatException::new));  //


    }
}
