package designpattern.observerpattern;

public class Second extends Observer {
    public Second(Subject subject){
        this.subject=subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println(subject.getState());
    }
}
