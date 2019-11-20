package designpattern.abstractfactorypattern;

public class Black implements  IColor {
    @Override
    public void fill() {
        System.out.println("Black");
    }
}
