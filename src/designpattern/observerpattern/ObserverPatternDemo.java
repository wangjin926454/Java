package designpattern.observerpattern;

public class ObserverPatternDemo {
    public static void main(String[] args){
        Subject su = new Subject();
        new First(su);
        new Second(su);
        new Third(su);
        System.out.println("setSate()");
        su.setState(1);
        su.getState();
        su.setState(2);
        su.getState();
    }
}
