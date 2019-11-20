package java_volume.java_volume_2_2.inetaddress;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerTest {
    public static void main(String[] args)throws Exception{
        DatagramSocket socket = new DatagramSocket(8080);
        byte[] b = new byte[100];
        DatagramPacket dp = new DatagramPacket(b,0,b.length);
        socket.receive(dp);
        System.out.println(new String(dp.getData(),0,dp.getLength()));
        socket.close();
    }
}
