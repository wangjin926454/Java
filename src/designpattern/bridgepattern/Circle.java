package designpattern.bridgepattern;

public class Circle extends Shape {
    private int x;
    private int y;
    private int radius;
    public Circle(int x,int y,int radius,IBrige iBrige){
        super(iBrige);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    @Override
    public void draw() {
        iBrige.draw(x,y,radius);
    }
}
