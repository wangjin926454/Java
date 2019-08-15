package java_volume.java_volume_2_2.nio1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * nio与io转换
 * */
public class FilesAndFileStream {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src","java_volume","java_volume_2_2","a.txt");
        Path path1 = Paths.get("src","java_volume","java_volume_2_2");
        Files.exists(path);
        //Files与文件流转换
        //InputStream is = Files.newInputStream(path);
        //OutputStream os = Files.newOutputStream(path);
        //Reader reader = Files.newBufferedReader(path);
        //Writer writer = Files.newBufferedWriter(path);

    }
}
