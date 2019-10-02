package java_volume.java_volume_2_1.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * StreamAPI
 * 创建stream的几种方式
 * */
public class StreamAPITest {
    public static void main(String[] args) {
        //通过list创建stream
        List<Student>  list = new ArrayList<>();
        list.add(new Student());
        Stream<Student> studentStream = list.stream();
        //通过数组创建stream
        Student[] a = new Student[]{new Student()};
        Stream<Student> studentStream1 = Arrays.stream(a);
        //通过Stream方法创建
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5,6);
        //创建无限流
        //public static<T> Stream<T> iterate(final T seed,final UnaryOperator<T> f)
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);
    }
}


class Student{

}