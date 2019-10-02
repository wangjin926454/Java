package java_volume.java_volume_2_2;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * unix和windows中路径分隔符
 * */
public class UnixAndWindowsPathTest {

    public static void main(String[] args){
        String separator = File.separator;
        //自动使用不同系统分隔符
        File f = new File("src"+separator+"java_volume"+separator+"java_volume_2_2"+separator+"student1.txt");
        Path path = Paths.get("src","java_volume","java_volume_2_2","student1.txt");
        System.out.println(f.toString());
        System.out.println(path.toString());

        Path path1 = Paths.get("src","java_volume","java_volume_2_2");
        File file = new File(path1.toString());

        //a.txt  只输出最后文件名
        String[] strings =  file.list();
        for(String string:strings){
            System.out.println(string);
        }
        //输出相对路径   src\java_volume\java_volume_2_2\a.txt
        File[] files = file.listFiles();
        for(File file1:files){
            System.out.println(file1);
        }

        //a.renameTo(b)  把a路径的文件复制到b路径。b不存在时才返回true
    }
}
