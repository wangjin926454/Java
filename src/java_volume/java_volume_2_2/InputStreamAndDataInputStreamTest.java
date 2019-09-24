package java_volume.java_volume_2_2;

import java.io.*;

/**
 *读写java对象中的数据。类似序列化
 * */
public class InputStreamAndDataInputStreamTest implements AutoCloseable {
    public static void main(String[] args)throws Exception {
        try (
                FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Documents\\GitHub\\Java\\src\\java_volume\\java_volume_2_2\\a.txt");
                DataInputStream dis = new DataInputStream(fis);
        )
 /*            DataOutputStream dos = new DataOutputStream(
                             new FileOutputStream("C:\\Users\\Administrator\\Documents\\GitHub\\Java\\src\\java_volume\\java_volume_2_2\\a.txt")
                     ))*/ {
            /*dos.writeInt(1);
            dos.flush();
            dos.writeUTF("wangjin");
            dos.flush();*/
            int a = dis.readInt();
            String s = dis.readUTF();
            System.out.println(s + "  "+a);

        }
    }

    @Override
    public void close() throws Exception {

    }
}
