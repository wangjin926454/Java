package designpattern.strategypattern;

public class OperationAdd implements IStrategyClass {
    @Override
    public int doOperation(int num1, int num2) {
        return num1+num2;
    }
}
