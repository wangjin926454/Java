package java_volume.java_volume_2_1.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Optional终结操作
 * */
public class NewOptionalTest {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("wangjin",23));
        list.add(new Student("wangjin1",231));
        list.add(new Student("wangjin2",232));
        list.add(new Student("wangjin2",232));

        List<Student> studentStream = list.stream().distinct().collect(Collectors.toList());
        for(Student student:studentStream){
            System.out.println(student);
        }
    }
}
