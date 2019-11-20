package java_volume.java_volume_2_2.inetaddress;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientTest {
    public static void main(String[] args)throws Exception{
        DatagramSocket socket = new DatagramSocket();
        byte[] b = "我是udp发送的导弹".getBytes();
        InetAddress i = InetAddress.getLocalHost();
        DatagramPacket dp = new DatagramPacket(b,0,b.length,i,8080);
        socket.send(dp);
        socket.close();
    }
}
