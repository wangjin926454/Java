package java_volume.java_volume_2_2;

import java.io.*;

public class BinaryOutputStreamTest {
    public static void main(String[] args)throws Exception{
        try{
            DataOutputStream dataOutputStream = new DataOutputStream(
                    new FileOutputStream("src\\java_volume\\java_volume_2_2\\bin.bin"));
            DataInputStream dataInputStream = new DataInputStream(
                    new FileInputStream("src\\java_volume\\java_volume_2_2\\student.txt"));
            byte[] b = new byte[1024];
            int len = -1;
            if((len = dataInputStream.readInt()) != -1){
                dataOutputStream.writeInt(len);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
