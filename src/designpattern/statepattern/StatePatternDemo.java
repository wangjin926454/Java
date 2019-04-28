package designpattern.statepattern;

public class StatePatternDemo {
    public static void main(String[] args) {
        Context1 context = new Context1();
        StartState startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState().toString());
    }
}