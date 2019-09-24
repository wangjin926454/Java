package java_volume.java_volume_2_2;

import java.io.*;

/**
 * PrintWriter
 * */
public class InputStreamAndDataInputStreamTest implements AutoCloseable {
    public static void main(String[] args)throws Exception {
        try (
                FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\a.txt");
                DataInputStream dis = new DataInputStream(fis);

             DataOutputStream dos = new DataOutputStream(
                     new BufferedOutputStream(
                             new FileOutputStream("C:\\Users\\Administrator\\Documents\\GitHub\\Java\\src\\java_volume\\java_volume_2_2\\a.txt")
                     ))) {
             int len = -1;
             byte[] b = new byte[1024];
             while((len=dis.read(b)) != -1){
                 System.out.println(len);
                 dos.write(b,0,len);
             }
             dos.flush();
        }
    }

    @Override
    public void close() throws Exception {

    }
}
