package designpattern.factorypattern;

public class SharpFactoryDemo{
    public static void main(String[] args){
        SharpFactoryImpl isf = SharpFactory.createInstance();
        isf.createCircle();
        isf.createRectangle();
        isf.createSquare();
        SharpFactory sf = new SharpFactory();
        ISharp iSharp = sf.getInstance("Circle");
        iSharp.draw();
    }
}
