package sourcescode.collection.list.linkedlistimplementsqueueandstack;

import java.util.*;

/**
 * 
 * */
public class LinkedListImplementsQueueAndStack  {
    public static void main(String[] args){
        LinkedList<Integer> queue1 = new LinkedList<>();   //LinkedList add() == queue
        LinkedList<Integer> queue = new LinkedList<>();    //LinkedList push() == Stack.push()
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5); // push == stack
        Random r = new Random();
        for(int i=0;i<5;i++){
            int n = r.nextInt(100);
            queue1.add(n);
        }
        for(int i:queue){
            System.out.println(i); //  5 4 3 2 1
        }
        while(queue.size()>0){
            System.out.println(queue.pop());       //  5 4 3 2 1
        }
        for(int i:queue1){
            System.out.println(i);  //6 7 8 9
        }
        while(queue1.size()>0){
            System.out.println(queue1.pop());   //6 7 8 9
        }
    }
}
