package designpattern.abstractfactorypattern;

public class White implements  IColor {
    @Override
    public void fill() {
        System.out.println("White");
    }
}
