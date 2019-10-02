package java_volume.java_volume_2_2;

import java.io.*;
/**
 * 序列化实践。在序列化单例模式的时候需要实现readResolve()方法
 * 通过readResolve方法返回对象，否则序列化出来的对象实例不会等于类中现存对象，这就违反了单例的要求。
 *
 * 无法序列化static属性和transient属性，反序列化时会赋予默认值
 * 序列化时版本管理
 * 兼容版本时加入private static final long serialVersionUID = - xxxxxxxxxxxx;
 * 即可兼容类的不同版本
 * 对象输入流会将当前版本的数据域与序列化版本的数据域进行比较。对于类型和属性名都一样的会进行数据匹配赋值。
 * 如果对象输入流中具有在当前版本存在的数据域，会忽略这些数据。
 * 如果对象输入流中没有当前版本存在的数据域，则会赋予默认值（对象是null，数字是0，boolean默认false）
 * 防止读入对象为null时，需要考虑在序列化类中的readObject方法做一些特殊的处理。
 *
 * 序列化可以实现clone
 * */
public class ObjectStream implements AutoCloseable{
    public static void main(String[] args)throws Exception{
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("src\\java_volume\\java_volume_2_2\\bin1.bin"));
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("src\\java_volume\\java_volume_2_2\\bin1.bin"));
            Student student = new Student("wangjin",22);
            Student student1 = new Student("wangjing",22);
            TeacherSerializableTest test = new TeacherSerializableTest("wangjinT",22);
            student.setTest(test);
            student1.setTest(test);
            objectOutputStream.writeObject(student);
            objectOutputStream.writeObject(student1);
            Student student2 = (Student)objectInputStream.readObject();
            Student student3 = (Student)objectInputStream.readObject();
            System.out.println(student2.toString());//+" "+student2.getTest().toString()+" "+System.identityHashCode(student2.getTest().getClass()));
            System.out.println(student3.toString());//+" "+student3.getTest().toString()+" "+System.identityHashCode(student3.getTest().getClass()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void close() throws Exception {

    }
}
