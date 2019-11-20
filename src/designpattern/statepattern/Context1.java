package designpattern.statepattern;

public class Context1 {
    private IState state;

    public Context1(){
        state = null;
    }

    public void setState(IState state){
        this.state = state;
    }

    public IState getState(){
        return state;
    }
}
