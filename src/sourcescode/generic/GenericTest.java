package sourcescode.generic;

/**
 * 泛型，E和T可以在初始化该对象实例时手动指定
 *
 * 泛型参数作为类参数使用，只能用A-Z不能用?
 * */
public class GenericTest<E,T> {
    private String a;
    private T t;
    private E e;
    @Override
    public String toString() {
        return "GenericTest{" +
                "a='" + a + '\'' +
                ", t=" + t +
                ", e=" + e +
                '}';
    }

    public GenericTest(String a, T t, E e) {
        this.a = a;
        this.t = t;
        this.e = e;
    }

    public static void main(String[] args){
        GenericTest<Integer,Integer> g = new GenericTest<>("wangin",1,2);
        System.out.println(g.toString());

    }
}
