package java_volume.java_volume_2_2.inetaddress;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 统一资源定位符
 * */
public class URLTest {
    public static void main(String[] args)throws Exception{
        URL url = new URL("https://pics6.baidu.com/feed/95eef01f3a292df5ff3d41169e94226535a87365.jpeg?" +
                "token=9beec3dea1f2cdd660933e5d21d35a17&s=6F104D80CAE31A8E7398FCB30300E091");
        HttpURLConnection huc = (HttpURLConnection)url.openConnection();
        InputStream is = huc.getInputStream();
        OutputStream os = new FileOutputStream("src\\java_volume\\java_volume_2_2\\inetaddress\\baidu.avi");
        byte[] b = new byte[1024*10];
        int len;
        while((len=is.read(b)) != -1){
            os.write(b,0,len);
        }
        os.close();
        is.close();
    }
}
