package java_volume.java_volume_2_2;

import java.io.Serializable;

public class TeacherSerializableTest implements Serializable {
    static  final long serialVersionUID = -7454082727995310841L;
    private String name;
    private int age;
    public TeacherSerializableTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "TeacherSerializableTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

}
