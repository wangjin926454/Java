package designpattern.factorypattern;

public class Rectangle implements ISharp{
    Rectangle(){
        System.out.println("Rectangle test:");
    }

    @Override
    public void draw() {
        System.out.println("Rectangle draw");
    }
}
