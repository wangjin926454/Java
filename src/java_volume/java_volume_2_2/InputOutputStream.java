package java_volume.java_volume_2_2;

import java.io.*;

/**
 * 输入输出流FileInputStream和FileOutputStream
 *
 * 当new byte[1]时每1MB文件20*0.34==6.8s左右
 * 当new byte[1024]时每1MB文件0ms左右
 *
 * 不存在文件会自动新增文件。创建输出流时，new对象时有true参数表示追加。false表示覆盖。
 * */
public class InputOutputStream implements AutoCloseable{
    public static void main(String[] args)throws Exception{
       try( FileInputStream fis = new FileInputStream("C:\\Users\\Public\\Music\\Sample Music\\Kalimba.mp3");
            FileOutputStream fos = new FileOutputStream(
                    "C:\\Users\\Administrator\\Documents\\GitHub\\Java\\src\\java_volume\\java_volume_2_2\\Kalimba.mp3")){

           /*在《Java网络编程》中，有这样一段话：
            ”Reader和Writer最重要的子类是InputStreamReader和OutputStreamWriter类。
            InputStreamReader类包含了一个底层输入流，可以从中读取原始字节。它根据指定的编码方式，将这些字节转换为Unicode字符。
            OutputStreamWriter从运行的程序中接收Unicode字符，然后使用指定的编码方式将这些字符转换为字节，再将这些字节写入底层输出流中。“
            */
           //虽然isr.read()和osw.write()都是操作char或String，但是底层会字节与字符之间转换
           InputStreamReader isr = new InputStreamReader(fis); //字节流到字符流
           OutputStreamWriter osw = new OutputStreamWriter(fos);  //字符流到字节流
           int len = -1;
           byte[] b = new byte[1024*20];
           long  s = System.currentTimeMillis();
           while( (len = fis.read(b)) != -1){
               //在使用FileInputStream和FileOutputStream时读写最好使用
               //write (byte[] b,int off,int len)保证每一个字节都被正确写入
               //使用write(byte[] b)可能产生字节错乱或丢失
               fos.write(b,0,len);
               //String str = new String(b,0, len);
               //System.out.println(str);
           }
           System.out.println(System.currentTimeMillis()-s+"ms");
           System.out.println(File.separator);
       }

    }

    @Override
    public void close() throws Exception {

    }
}
