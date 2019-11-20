package designpattern.strategypattern;

public class OperationMultiply implements IStrategyClass {
    @Override
    public int doOperation(int num1, int num2) {
        return num1*num2;
    }
}
