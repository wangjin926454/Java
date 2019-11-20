package java_volume.java_volume_2_2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 证明InputStream是阻塞式IO
 * */
public class InputStreamBlockingTest {
    public static void main(String[] args)throws Exception{
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(new File("C:\\Users\\Administrator\\Documents\\GitHub\\Java\\src\\java_volume\\java_volume_2_2\\a.txt"))
        );
        int str = bis.read();
        while(str!=-1){
            str = bis.read();
            System.out.println(str);
        }
    }
}
