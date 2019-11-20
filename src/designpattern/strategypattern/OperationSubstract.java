package designpattern.strategypattern;

public class OperationSubstract implements  IStrategyClass {
    @Override
    public int doOperation(int num1, int num2) {
        return num1-num2;
    }
}
