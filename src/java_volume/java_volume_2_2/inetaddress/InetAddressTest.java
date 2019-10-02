package java_volume.java_volume_2_2.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws Exception {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress);
        //获取主机名字和ip地址
        System.out.println(InetAddress.getLocalHost());
        //获取localhost/127.0.0.1
        System.out.println(InetAddress.getLoopbackAddress());

        //获取www.baidu.com的域名和ip
        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getHostAddress());
    }
}
