package java_volume.java_volume_2_2;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * 读入一个文件
 * */
public class ReadAFilleTest implements AutoCloseable{
    public static void main(String[] args)throws IOException{
        //读入一个小文件
        String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\Administrator\\a.txt")),StandardCharsets.UTF_8);
        System.out.println(content);
        //一行一行得读入
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Administrator\\a.txt"),StandardCharsets.UTF_8);
        lines.forEach(System.out::println);
        //如果文件太大
        Stream<String> stream = Files.lines(Paths.get("C:\\Users\\Administrator\\a.txt"),StandardCharsets.UTF_8);

    }

    @Override
    public void close() throws Exception {

    }
}
