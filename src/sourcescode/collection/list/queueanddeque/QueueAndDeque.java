package sourcescode.collection.list.queueanddeque;

import java.util.*;
import java.util.concurrent.*;

public class QueueAndDeque {
    public static void main(String[] args){
        //data1:12 94 59 62 48 14 55 20 14 89
        //data2:12 94 59 62 a48 z14 fdsfsafsa55 jkljkni20 fdsf14 fjsijf89

        //Queue<Object> queue = new PriorityQueue<>(); //own sort wuxu 12 14 14 20 62 59 55 94 48 89

        //youxu  12 94 59 62 a48 z14 fdsfsafsa55 jkljkni20 fdsf14 fjsijf89
        //Queue<Object> queue = new ConcurrentLinkedDeque<>();

        //youxu  array 12 94 59 62 a48 z14 fdsfsafsa55 jkljkni20 fdsf14 fjsijf89
        //must Initialization capacity.where true,The sooner  time, the first you go out
        //ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(20,true);

        //youxu linked 12 94 59 62 a48 z14 fdsfsafsa55 jkljkni20 fdsf14 fjsijf89
        //base Linked
        //Queue<Object> queue = new LinkedBlockingQueue<>();

        //the higher  priority,the first you go out
        Queue<Object> queue = new PriorityBlockingQueue<>();    //12 48 55 62 62 59 59 94 94 89

        //Queue<Object> queue = new DelayQueue<>();
        queue.add(12);
        queue.add(94);
        queue.add(59);
        queue.add(62);
        queue.add(62);
        queue.add(59);
        queue.add(55);
        queue.add(94);
        queue.add(48);
        queue.add(89);
        /*queue.add("a48");
        queue.add("z14");
        queue.add("fdsfsafsa55");
        queue.add("jkljkni20");
        queue.add("fdsf14");
        queue.add("fjsijf89");*/
        Iterator it = queue.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }

    }
}
