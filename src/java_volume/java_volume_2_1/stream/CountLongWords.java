package java_volume_2_1.stream;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountLongWords {
    public static void main(String[] args) throws Exception{
        String strs = new String(Files.readAllBytes(Paths.get("C:\\Users\\Administrator\\a.txt")), StandardCharsets.UTF_8);
        List<String> list  = Arrays.asList(strs.split("\\PL+"));
        long count = 0;
        for(String w:list){
            if(w.length()>12){
                count++;
            }
        }
        System.out.println(count);

        count = list.stream().filter(a -> a.length()>12).count();
        System.out.println(count);

        count = list.parallelStream().filter(a -> a.length()>12).count();
        System.out.println(count);
    }
}
