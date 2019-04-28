package designpattern.bridgepattern;

public abstract class Shape {
    IBrige iBrige;
    public Shape(IBrige iBrige){
        this.iBrige =iBrige;
    }
    public abstract void draw();
}
