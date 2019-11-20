package java_volume.java_volume_2_2;

import java.io.*;
import java.nio.file.Paths;

/**
 * 验证空格是否算文件末尾（结果：不算）
 * */
public class FileReaderTest implements Closeable {
    public static void main(String[] args) throws Exception {
        File file = new File(Paths.get("src","java_volume","java_volume_2_2","hello.txt").toString());
        FileReader fr = new FileReader(file);
        int data = fr.read();
        while(data != -1){
            System.out.print((char)data);
            data = fr.read();
        }
    }

    @Override
    public void close() throws IOException {

    }
}
