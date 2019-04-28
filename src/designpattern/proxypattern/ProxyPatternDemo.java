package designpattern.proxypattern;

public class ProxyPatternDemo {

    public static void main(String[] args) {
        IImage image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
    }
}