package java_volume.java_volume_2_2.inetaddress;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPServerTest {
    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(8080);
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[10];
            int len;
            while((len=is.read(b)) != -1){
                bos.write(b,0,len);
            }
            System.out.println(bos.toString());
            System.out.println("传输完毕");
            //获取客户端ip地址
            System.out.println(socket.getInetAddress());
            OutputStream os = socket.getOutputStream();
            os.write("我收到了".getBytes());
            socket.shutdownOutput();
        }catch (UnknownHostException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
