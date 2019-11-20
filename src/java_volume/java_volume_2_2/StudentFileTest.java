package java_volume.java_volume_2_2;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *文件输出流必须写在try中才能成功写入。
 * */
public class StudentFileTest implements Closeable {
    public static void main(String[] args)throws Exception {
        Student[] students = new Student[2];
        students[0] = new Student("wangjin",22);
        students[1] = new Student("wangjin1",221);
       try(
               PrintWriter pw = new PrintWriter("src\\java_volume\\java_volume_2_2\\student.txt","UTF-8");){
           //System.out.println(pw);
           pw.write(students[0].getAge()+"|"+students[0].getName()+"\n");
           pw.write(students[1].getAge()+"|"+students[1].getName()+"\n");
       }catch (FileNotFoundException e){
           System.out.println("FileNotFoundException");
       }
    }

    @Override
    public void close() throws IOException {

    }
}
