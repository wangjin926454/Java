package java_volume.java_volume_2_2;

import java.io.RandomAccessFile;

public class RandomAccessFileInsertTest {
    public static void main(String[] args)throws Exception{
        RandomAccessFile rf = new RandomAccessFile("src\\java_volume\\java_volume_2_2\\af.txt","rw");
        rf.seek(3);
        StringBuilder sb = new StringBuilder("test");
        byte[] b = new byte[20];
        int len = 0;
        while((len = rf.read(b)) != -1){
            sb.append(new String(b,0,len));
        }
        System.out.println(sb.toString());
        rf.seek(3);
        rf.write(sb.toString().getBytes());
        rf.close();
    }
}
