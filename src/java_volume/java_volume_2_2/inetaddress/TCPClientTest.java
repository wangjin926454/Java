package java_volume.java_volume_2_2.inetaddress;

import org.junit.Test;

import java.io.*;
import java.net.Socket;

public class TCPClientTest implements Closeable {
    public static void main(String[] args)throws Exception{
        //这是客户端
       try(
               Socket socket  = new Socket("127.0.0.1",8080);
            OutputStream os = socket.getOutputStream();
       )
       {
           os.write("test".getBytes());
           socket.shutdownOutput();
           InputStream is = socket.getInputStream();
           ByteArrayOutputStream bos = new ByteArrayOutputStream();
           byte[] b = new byte[10];
           int len = 0;
           while((len=is.read(b)) != -1){
               bos.write(b,0,len);
           }
           System.out.println(bos.toString());
       }

    }

    @Override
    public void close() throws IOException {
    }
}
