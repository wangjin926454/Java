package designpattern.abstractfactorypattern;

public class ColorFactory extends AbstractFactory{
    @Override
    public IColor getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("White")){
            return new White();
        } else if(color.equalsIgnoreCase("Black")){
            return new Black();
        } else if(color.equalsIgnoreCase("Blue")){
            return new Blue();
        }
        return null;
    }
    @Override
    public ISharp getSharp(String sharp) {
        return null;
    }
}
