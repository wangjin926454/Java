package java_volume.java_volume_2_2;

import java.io.*;

/**
 * 测试FileInputStream和DataInputStream组合
 * */
public class InputStreamAndDataInputStreamTest implements AutoCloseable {
    public static void main(String[] args)throws Exception {
        try (PushbackInputStream phin = new PushbackInputStream(
                new BufferedInputStream(
                        new FileInputStream("C:\\Users\\Administrator\\a.txt")));
             DataInputStream dis = new DataInputStream(phin);
             DataOutputStream dos = new DataOutputStream(
                     new BufferedOutputStream(
                             new FileOutputStream("C:\\Users\\Administrator\\Documents\\GitHub\\Java\\src\\java_volume\\java_volume_2_2\\a.txt")
                     ))) {
             
        }
    }

    @Override
    public void close() throws Exception {

    }
}
