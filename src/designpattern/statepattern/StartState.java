package designpattern.statepattern;

public class StartState implements IState {

    public void doAction(Context1 context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    public String toString(){
        return "Start State";
    }
}