package designpattern.observerpattern;

public class First extends Observer {
    public First(Subject subject){
        this.subject=subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println(subject.getState());
    }
}
