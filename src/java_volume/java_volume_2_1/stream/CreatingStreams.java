package java_volume.java_volume_2_1.stream;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreatingStreams  {

    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        //System.out.println(stream.count());
        List<T> firstElements = stream.limit(SIZE+1).collect(Collectors.toList());  //limit()方法截取一个不超过max长度的流  .collect(Collectors.toList())将流转换为list
        System.out.print(firstElements.size()+" "+ title+":");
        for(int i=0;i<firstElements.size();i++){
            if(i>0){
                System.out.print(", ");
            }
            if(i<SIZE) {
                System.out.print(firstElements.get(i));
            }
            else System.out.print("...");
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception{
        //对于得到结果的stream可以使用collect()方法收集
        Path path = Paths.get("C:\\Users\\Administrator\\a.txt");
        String con = new String(Files.readAllBytes(path), StandardCharsets.UTF_8); //nio以utf-8形式读取文件
        Stream<String> stream  = Stream.of(con.split("\\PL+"));       //切割读取的文件返回数组然后转换为一个流
        show("streams",stream);

        Stream<String> stream1 = Stream.of("gently","down","the","stream");   //创建一个自定义长度的流
        show("stream1",stream1);

        Stream<String> stream2 = Stream.empty();                               //创建一个空的流
        show("stream2",stream2);

        Stream<String> stream3 = Stream.generate(() -> "stream");       //创建一个无限流且值都是"stream"
        show("stream3",stream3);

        Stream<Double> stream4 = Stream.generate(Math::random);        //创建一个无限流且值都是Math.random();
        show("stream4",stream4);

        Stream<BigInteger> stream5 = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));   //创建一个无限流且值都是在前一个值基础上+1
        show("stream5",stream5);

        Stream<String> stream6 = Pattern.compile("\\PL+").splitAsStream(con);   // //Pattern.compile(regex)返回一个regex。con通过regex切割后返回为流
        show("stream6",stream6);

        Stream<String> stream7 = Files.lines(path,StandardCharsets.UTF_8);  //创建一个流长度为行数，每一个元素内容为对应行的内容
        show("stream7",stream7);

        String[] strings = {"aaaaa","bbbbbb","ccccc","dddddd","eeeeee","ffffff"};
        Stream<String> stream8 = Arrays.stream(strings,1,5);  //从数组中截取一部分返回一个流
        show("stream8",stream8);

        List<String> list = new ArrayList<>();
        Stream<Object> stream10 = Stream.of(list.toArray()); //list转stream

        Supplier<CreatingStreams> stream9 = CreatingStreams::new;
        System.out.println(stream9.get());   //相当于new一个CreatingStreams对象

        //java获取对象的几种方法
        //1.直接new
        //2.通过反射调用newInstance方法
        //3.运用反序列化手段，调用java.io.ObjectInputStream对象的 readObject()方法。 
        //bjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
        //4. Class类中newInstance方法 Student student2 = (Student)Class.forName("根路径.Student").newInstance();
        //Employee emp4 = (Employee) in.readObject();
        //5.clone()克隆方法。
        //Employee emp5 = (Employee) emp3.clone();
    }
}
