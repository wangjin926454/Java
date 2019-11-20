package designpattern.strategypattern;

public class Context {
    private IStrategyClass strategy;

    public Context(IStrategyClass strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}