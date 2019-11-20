package java_volume.java_volume_2_2;

import java.io.*;

/**
 *
 * */
public class InputStreamReadUnicode implements AutoCloseable{
    public static void main(String[] args)throws Exception{
        try(DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("src\\java_volume\\java_volume_2_2\\student.txt")));
            DataOutputStream dataOutputStream = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("src\\java_volume\\java_volume_2_2\\student1.txt")
                    ));){
            byte[] b = new byte[1024];
            int len = -1;
            while((len = dataInputStream.read(b)) != -1){
                dataOutputStream.write(b,0,len);
            }
        }
    }

    @Override
    public void close() throws Exception {

    }
}
