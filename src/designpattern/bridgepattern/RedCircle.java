package designpattern.bridgepattern;

public class RedCircle implements IBrige {
    @Override
    public void draw(int x, int y, int radius) {
        System.out.println("x:"+x+"y:"+y+"radius:"+radius);
    }
}
