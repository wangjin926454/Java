package designpattern.factorypattern;

public class Circle implements ISharp{
     Circle(){
        System.out.println("Circle test:");
    }

    @Override
    public void draw() {
        System.out.println("Circle draw");
    }
}
