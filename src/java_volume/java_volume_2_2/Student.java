package java_volume.java_volume_2_2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**a
 * 序列化需要实现Serializable接口
 * Externalizable 接口继承自Serializable接口。
 * 对于Serializable接口来说更简单，但是会占用更多空间
 * Externalizalbe接口实现类必须提供readExternal和writeExternal方法，需要完全由程序员控制读写，更麻烦但是也更有效
 * */
public class Student implements Serializable {
    static final long serialVersionUID = 5543018147371537784L;
    private String name;
    private int age;
    //transient表示序列化时忽略
    private transient TeacherSerializableTest test;

    public TeacherSerializableTest getTest() {
        return test;
    }

    public void setTest(TeacherSerializableTest test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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


    /**
     * 自定义序列化需要实现此方法表示某一个参数不需要被序列化，但是可以做一些定制条件。
     * 例如：反序列化时做一些特殊操作(如下在返回时做特殊操作)
     * */
    private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
        in.defaultReadObject();
        TeacherSerializableTest test = new TeacherSerializableTest("TTTTT",222222);
        System.out.println(test.toString());
    }
    /**
     * 自定义序列化需要实现此方法表示某一个参数不需要被序列化，但是可以做一些定制条件。
     * 例如：反序列化时做一些特殊操作
     * */
    private void writeObject(ObjectOutputStream out) throws IOException{
        out.defaultWriteObject();
        out.writeObject(test);
    }
}
