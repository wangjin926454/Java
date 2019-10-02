package java_volume.java_volume_2_1.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * Stream中间操作
 * */
public class StreamMidOperation{
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("wangjin",23));
        list.add(new Student("wangjin1",231));
        list.add(new Student("wangjin2",232));
        list.add(new Student("wangjin2",232));
        
        
        Stream<Student> studentStream = list.stream();
        //过滤
        studentStream.filter(e->e.getAge()==23).forEach(System.out::println);
        System.out.println();
        //截取
        list.stream().limit(2).forEach(System.out::println);
        System.out.println();
        //跳过
        list.stream().skip(2).forEach(System.out::println);
        System.out.println();
        //筛选，通过流中元素ha'shCode()和equals()方法比较是否相同
        list.stream().distinct().forEach(System.out::println);
        System.out.println();

        //映射
        //list的元素中name转换成大写输出，map是遍历操作，不过滤元素
        list.stream().map(e->e.getName().toUpperCase()).forEach(System.out::println);
        System.out.println();
        //获取名字长度大于3的元素，filter是过滤操作
        list.stream().filter(e->e.getName().length()>7).forEach(System.out::println);
        System.out.println();
        /*
        List list = new ArrayList();
        list.add(1);
        List list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list.add(list1);//结果[1,[1,2]]
        list.addAll(list1)//结果[1,1,2]
        * */
        //flatMap(Function f) 接收一个函数作为参数，将流中每一个值转换成另一个流中参数
        //每一个Student经过addStudent()方法后都是一个新的Stream<Student>
        Stream<Stream<String>> streamStream1 = list.stream().map(StreamMidOperation::addStudent);
        streamStream1.forEach(s->
                s.forEach(System.out::println));
        System.out.println();
        //将每次addStudent后的所有stream合并为一个stream
        Stream<String> stringStream = list.stream().flatMap(StreamMidOperation::addStudent);
        stringStream.forEach(System.out::println);
        System.out.println();

        //排序
        //Student类中实现排序
        //list.stream().distinct().sorted().forEach(System.out::println);
        //lambda表达式实现排序
        list.stream().distinct().sorted((o1,o2)->o2.getAge()-o1.getAge()).forEach(System.out::println);
        System.out.println();
        //匹配查找
        boolean b = list.stream().anyMatch(e -> e.getAge() == 231);
        System.out.println(b);
        boolean b1 = list.stream().noneMatch(e -> e.getAge() == 233);
        System.out.println(b1);
        Optional<Student> first = list.stream().findFirst();
        System.out.println(first);
        Optional<Student> any = list.parallelStream().findAny();
        Optional<Student> first1 = list.parallelStream().findFirst();
        System.out.println(any+""+ first1);
        long count = list.stream().filter(e -> e.getAge() > 30).count();
        System.out.println(count);
        Stream<Integer> integerStream = list.stream().map(Student::getAge);
        Optional<Integer> max = integerStream.max(Integer::compare);
        System.out.println(max);
        Optional<Student> max1 = list.stream().max(Comparator.comparingInt(Student::getAge));
        System.out.println(max1);
        Optional<Student> min = list.stream().min(Comparator.comparingInt(Student::getAge));
        System.out.println(min);

        //归约（reduce对结果中进行计算）
        List<Integer> listInteger = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = listInteger.stream().reduce(0, Integer::sum);
        System.out.println(reduce);//55
        Integer reduce1 = list.stream().map(Student::getAge).reduce(0,Integer::sum);
        System.out.println(reduce1);
    }

    public static Stream<String> addStudent(Student student){
        ArrayList<String> list1 = new ArrayList<>();
        list1.add(student.getName());
        return list1.stream();
    }
}
