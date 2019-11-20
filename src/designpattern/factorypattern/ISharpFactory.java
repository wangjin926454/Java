package designpattern.factorypattern;
/**
 *理论上每一个接口适合只有一种功能<br>
 * 此接口多个接口方法适用于每个接口方法不共用<br>
 *     优点是实现方法只需要一个实现此接口即可
 * */
public interface ISharpFactory {
    Circle createCircle();
    Square createSquare();
    Rectangle createRectangle();
}
