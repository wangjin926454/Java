package effectivejava;


public class SingletonTest {
    public static final SingletonTest singleton = new SingletonTest();
    private SingletonTest(){}
    public void doSomething(){}
}
