package designpattern.factorypattern;
/**
 * 工厂模式
 * */
public class SharpFactoryImpl implements ISharpFactory{

    @Override
    public Circle createCircle() {
        System.out.println("Circle Test");
        return new Circle();
    }

    @Override
    public Square createSquare() {
        System.out.println("Square Test");
        return new Square();
    }

    @Override
    public Rectangle createRectangle() {
        System.out.println("Rectangle Test");
        return new Rectangle();
    }
}
