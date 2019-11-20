package sourcescode.collection.list.stacksourcecode;

import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

/**
 * Stack Source Code Demo,stack all are youxu.Stack class is extends Vector
 * */
public class StackSourceDemo {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        Random r = new Random();
        for(int i=0;i<10;i++){
            int n = r.nextInt(100);
            System.out.print(n+" "); //46 46 47 35 25 8 4 5 99 78
            stack.add(n);
            stack1.push(n);
        }
        System.out.println();
        Iterator it = stack.iterator();
        Iterator it1 = stack1.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");    //46 46 47 35 25 8 4 5 99 78
        }
        System.out.println();
        while(it1.hasNext()){
            System.out.print(it1.next()+" ");   //46 46 47 35 25 8 4 5 99 78
        }
        System.out.println();
        for(int i:stack){
            System.out.print(i+" ");    //46 46 47 35 25 8 4 5 99 78
        }
        System.out.println();
        for(int i:stack1){
            System.out.print(i+" ");    //46 46 47 35 25 8 4 5 99 78
        }
    }
}
