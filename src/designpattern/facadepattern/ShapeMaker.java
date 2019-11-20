package designpattern.facadepattern;

public class ShapeMaker {
    private Circle circle;
    private Rectangle rectangle;
    private Square square;
    public ShapeMaker(){
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }
    public void circleDraw(){
        circle.draw();
    }
    public void rectangleDraw(){
        rectangle.draw();
    }
    public void squareDraw(){
        square.draw();
    }
}
