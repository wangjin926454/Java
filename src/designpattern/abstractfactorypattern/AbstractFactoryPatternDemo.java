package designpattern.abstractfactorypattern;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args){
        AbstractFactory af = FactoryProducer.getFactory("Color");
        IColor iColor = af.getColor("White");
        iColor.fill();
        IColor iColor1 = af.getColor("Black");
        iColor1.fill();
        IColor iColor2 = af.getColor("Blue");
        iColor2.fill();
        AbstractFactory af1 = FactoryProducer.getFactory("Sharp");
        ISharp iSharp = af1.getSharp("Square");
        iSharp.draw();
        ISharp iSharp1 = af1.getSharp("Circle");
        iSharp1.draw();
        ISharp iSharp2 = af1.getSharp("Rectangle");
        iSharp2.draw();

    }

}
