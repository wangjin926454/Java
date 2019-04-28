package designpattern.abstractfactorypattern;

public class FactoryProducer {
    public static AbstractFactory getFactory(String factory){
        if(factory.equalsIgnoreCase("Sharp")){
            return new SharpFactory();
        } else if(factory.equalsIgnoreCase("Color")){
            return new ColorFactory();
        }
        return null;
    }
}
