package designpattern.statepattern;

public class StopState implements IState {

    public void doAction(Context1 context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString(){
        return "Stop State";
    }
}