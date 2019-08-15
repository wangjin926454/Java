package java_volume.java_volume_2_2.nio1;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Stream;

/**
 * nio中Files类学习
 * StandardOpenOption与newBufferedWriter,newInputStream,newOutputStream,write一起使用
 * 用于操作文件的选项如追加，只读等等选项。
 * 详情见：java核心卷二 p88-p89
 * */
public class FilesTest {
    public static void main(String[] args)throws IOException {
        Path path = Paths.get("src","java_volume","java_volume_2_2","nio1","a.txt");
        Path path1 = Paths.get("src","java_volume","java_volume_2_2","nio1","b.txt");
        Path path2 = Paths.get("src","java_volume","java_volume_2_2","nio1","c.txt");
        //目录不存在创建目录
        if(Files.notExists(path2)){
            Files.createFile(path2);
        }
        //写入文件
        Files.write(path1,"我是一个未来的大佬".getBytes(StandardCharsets.UTF_8));
        //追加
        Files.write(path1,"我是第二个未来的大佬".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        //读入文件为byte[]流
        byte[] bytes  = Files.readAllBytes(path);
        String string = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(string);
        //读入所有行，按行存入list中
        List<String> list = Files.readAllLines(path);
        //按照list中元素按行写入
        Files.write(path2,list);
        list.forEach(System.out::println);

        //复制文件时原子性，复制文件所有属性，如果文件存在就覆盖，ATOMIC_MOVE指的是移动文件，在这里不能一起用。会报错
       // Files.copy(path,path1, StandardCopyOption.ATOMIC_MOVE,StandardCopyOption.COPY_ATTRIBUTES,StandardCopyOption.REPLACE_EXISTING);
        Path path3 = Paths.get("src","java_volume","java_volume_2_2","noExists.txt");
        //path3不存在则会创建,只能用于输出文件流。因为输出文件流才会在最后用到文件
        OutputStream fis = Files.newOutputStream(path3,StandardOpenOption.CREATE);
        //不存在会报错
        //Files.delete(path3);
        //如果存在删除
        Files.deleteIfExists(path3);
        Stream<Path>  stream = Files.
        //Files.copy(inputStream,path); //复制文件流到path
        //Files.copy(path,outputStream); //输出流到文件

    }
}
