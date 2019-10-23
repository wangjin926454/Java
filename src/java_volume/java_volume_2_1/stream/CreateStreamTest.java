package java_volume.java_volume_2_1.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * StreamAPI
 * 创建stream的几种方式
 * */
public class CreateStreamTest {
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


class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                this.name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Student o) {
        return o.age-this.age;
    }
}