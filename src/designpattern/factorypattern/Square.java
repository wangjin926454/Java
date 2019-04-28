package designpattern.factorypattern;

public class Square implements ISharp{
     Square(){
        System.out.println("Square test;");
    }

    @Override
    public void draw() {
        System.out.println("Square draw");
    }
}
