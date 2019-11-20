package java_volume.java_volume_1_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 对集合类实现自定义排序
 * */
public class BinarySearchTest {
    public static void main(String[] args){
        List<Student2> list = new ArrayList<>();
        list.add(new Student2("wangjin",16));
        list.add(new Student2("wangjin",15));
        list.add(new Student2("wangjin",17));
        int index = Collections.binarySearch(list,new Student2("wangjin",15));   //集合类中实现comparable接口
        System.out.println(index);

        int index1 = Collections.binarySearch(list,new Student2("wangjin",17),new MyComparator());  //传入一个比较器
        System.out.println(index1);

    }
}
class Student2 implements Comparable<Student2>{
    private String userName;
    private int age;

    public Student2(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student2 student) {
        return student.age - age;
    }

}
class MyComparator implements Comparator<Student2>{

    @Override
    public int compare(Student2 o1, Student2 o2) {
        return o1.getAge()-o2.getAge();
    }
}

