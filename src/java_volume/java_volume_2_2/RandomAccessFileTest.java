package java_volume.java_volume_2_2;

import java.io.RandomAccessFile;

/**
 * 随机存取文件RandomAccessFile
 *
 * r表示读，rw表示可以读也可以写  rwd表示立即写到硬盘，如果发生异常rwd里已经写的数据会被存到硬盘，rw则不会
 * RandomAccessFile既可以表示输入流又可以表示输出流
 * 文件不存在自动创建，存在默认覆盖
 * */
public class RandomAccessFileTest {
    public static void main(String[] args) throws Exception {
        RandomAccessFile rf = new RandomAccessFile("src\\java_volume\\java_volume_2_2\\af.txt","rw");
        //需要追加时
        long len = rf.length();
        rf.seek(len);
        rf.write("abc".getBytes());
        rf.close();
    }
}
