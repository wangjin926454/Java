package thread;

import permission.aotherpackage.Demo1;

public class Demo3 extends Demo1{
    private  int a;

    public Demo3() {
        this.a = 4;
    }

    public  int getA() {
        return a;
    }

    public  void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args){
        Demo1 demo1 = new Demo1();
        //demo1.test();
    }
}
