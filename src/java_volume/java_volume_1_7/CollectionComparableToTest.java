package java_volume_1_7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 对集合类实现自定义排序
 * */
public class CollectionComparableToTest {
    public static void main(String[] args){
        List<Student1> list = new ArrayList<>();
        list.add(new Student1("wangjin",16));
        list.add(new Student1("wangjin",15));
        list.add(new Student1("wangjin",17));
        list.sort(Comparator.reverseOrder());
        for(Student1 student1 : list){
            System.out.println(student1.toString());
        }
    }
}
class Student1 implements Comparable<Student1>{
    private String userName;
    private int age;

    public Student1(String userName, int age) {
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
    public int compareTo(Student1 student) {
        return student.age - age;
    }

}

