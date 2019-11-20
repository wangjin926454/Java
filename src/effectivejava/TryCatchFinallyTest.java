package effectivejava;

import java.io.*;

public class TryCatchFinallyTest {
    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream("C:\\Users\\Administrator\\a.txt");
        try {
            OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\a.txt");
            try {
                byte[] buf = new byte[1024];
                int n;
                while((n=in.read(buf))>=0)
                    out.write(buf,0,n);
            } finally {
                out.close();
            }
        }finally {
            in.close();
        }

    }
}
