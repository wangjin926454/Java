package effectivejava;

import java.util.Arrays;

/**
 * 深克隆与浅克隆以及克隆结果区别
 * */
public class CloneTest{
    public static void main(String[] args){
        Test t = new Test(10);
        Test t1 =(Test) t.clone();
        t1.elements[5]=10;
        t.size = 10;
        t1.size = 20;
        System.out.println(t.toString()+" "+t.size);
        System.out.println(t1.toString()+" "+t1.size);
        /*
        Test{elements=[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]} 10
        Test{elements=[0, 1, 2, 3, 4, 10, 6, 7, 8, 9]} 20
        此时克隆结果
        * */
    }
}

class Test implements Cloneable{
    public int size = 0;
    public String str = "wangjin";
    Object[] elements;

    public Test(){

    }

    Test(int size){
        this.elements = new Object[10];
        for(int i=0;i<10;i++){
            elements[i] = i;
        }
    }

    void test(){
        System.out.println("test");
    }
    public Object clone(){
        try{
            /*
            Test{elements=[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]} 10
            Test{elements=[0, 1, 2, 3, 4, 10, 6, 7, 8, 9]} 20
            此时克隆结果
            * */
            Test test = (Test)super.clone();
            test.elements = elements.clone(); //原对象中存在可变对象时需要对可变对象进行递归clone
            return test;
            /*
            Test{elements=[0, 1, 2, 3, 4, 10, 6, 7, 8, 9]} 10
            Test{elements=[0, 1, 2, 3, 4, 10, 6, 7, 8, 9]} 20
            * */
            //return super.clone();   //在try中直接return此语句。在原对象中不存在可变对象则无影响。
            //如果原对象中存在可变对象则会导致clone的对象实例也指向同一地址会产生错误的结果
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Test{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}