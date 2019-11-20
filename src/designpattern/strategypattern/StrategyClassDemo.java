package designpattern.strategypattern;

/**
 * IStrategyClass创建接口
 * 三个实现类实现接口
 * 通过创建实例时指定实例对象类
 * 调用接口方法即可
 * 动态地去替换 Context 使用的算法
 * */
public class StrategyClassDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
