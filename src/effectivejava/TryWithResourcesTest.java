package effectivejava;

import java.io.*;
/**
 * try-with-resources
 * */
public class TryWithResourcesTest implements AutoCloseable {  //实现Closeable接口

        public static void main(String[] args)throws Exception{
            try  (BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\Administrator\\a.txt"))){

            }//catch(){}//也可以捕获异常
    }

    @Override
    public void close() throws IOException {

    }
}
