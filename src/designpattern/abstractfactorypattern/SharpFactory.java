package designpattern.abstractfactorypattern;

/**
 * Sharp工厂
 * */
public class SharpFactory extends AbstractFactory{
    @Override
    public IColor getColor(String color) {
        return null;
    }
    @Override
    public ISharp getSharp(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("Circle")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("Rectangle")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("Square")){
            return new Square();
        }
        return null;
    }
}
