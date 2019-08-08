package java_volume.java_volume_2_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 输入输出流FileInputStream和FileOutputStream
 *
 * 当new byte[1]时每1MB文件20*0.34==6.8s左右
 * 当new byte[1024]时每1MB文件0ms左右
 * */
public class InputOutputStream implements AutoCloseable{
    public static void main(String[] args)throws Exception{
       try( FileInputStream fis = new FileInputStream("C:\\Users\\Public\\Music\\Sample Music\\Kalimba.mp3");
            FileOutputStream fos = new FileOutputStream(
                    "C:\\Users\\Administrator\\Documents\\GitHub\\Java\\src\\java_volume\\java_volume_2_2\\Kalimba.mp3")){
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
