package designpattern.facadepattern;

public class FacadePatternDemo {
    public static void main(String[] args){
        ShapeMaker sm =  new ShapeMaker();
        sm.circleDraw();
        sm.squareDraw();
        sm.rectangleDraw();
    }
}
