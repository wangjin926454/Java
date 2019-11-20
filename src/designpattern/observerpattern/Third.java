package designpattern.observerpattern;

public class Third extends Observer {
    public Third(Subject subject){
        this.subject=subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println(subject.getState());
    }
}