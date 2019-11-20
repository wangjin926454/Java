package java_volume.java_volume_2_2;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 利用PrintWriter写文件
 * */
public class PringWriterTest implements Closeable {
    public static void main(String[] args) throws Exception{
        //Reader in = new InputStreamReader(System.in);
        try(//Reader in1 = new InputStreamReader(
                //new FileInputStream("C:\\Users\\Administrator\\a.txt"), StandardCharsets.UTF_8);
            PrintWriter pw = new PrintWriter("C:\\Users\\Administrator\\Documents\\GitHub\\Java\\src\\java_volume\\java_volume_2_2\\a.txt","UTF-8");){
            pw.write("test");

        }

    }

    @Override
    public void close() throws IOException {

    }
}
