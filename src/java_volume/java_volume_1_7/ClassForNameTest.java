package java_volume.java_volume_1_7;

public class ClassForNameTest {
    public static void main(String[] args)throws Exception{
        Class c = Class.forName("java_volume.java_volume_1_7.C");
        B b = (B) c.newInstance();
        b.b();
        Class d = Class.forName("java_volume.java_volume_1_7.D");
        b = (B) d.newInstance();
        b.b();
    }
}
