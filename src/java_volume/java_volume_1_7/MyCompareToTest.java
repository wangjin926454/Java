package java_volume.java_volume_1_7;

import java.util.Arrays;
/**
 * comparable接口实现自定义排序
 * */
public class MyCompareToTest {
    public static void main(String[] args){
        Student[] students = new Student[]{
                new Student("wangjin",16),
                new Student("wangjin",15),
                new Student("wangjin",17),
        };
        Arrays.sort(students);
        for(Student student: students){
            System.out.println(student.toString());
        }
    }
}
class Student implements Comparable<Student>{
    private String userName;
    private int age;

    public Student(String userName, int age) {
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
    public int compareTo(Student student) {
        return age-student.age;
    }

}
