package sourcescode.collection.mapandset;

import java.util.*;

/**
 * TreeMap And TreeSet Source Demo
 * */
public class TreeMapAndTreeSetSourceDemo {
    public static void main(String[] args){
        TreeMap<String,Integer> treeMap = new TreeMap<>();    //key value auto sort as desc
        TreeSet treeSet = new TreeSet();    // value auto sort as desc
        Random r = new Random();
        for(int i=0;i<10;i++){
            int n = r.nextInt(100);
            System.out.print(n+"");
            treeMap.put(""+n,n);
            treeSet.add(n);
        }
        Iterator it = treeMap.entrySet().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        Iterator it1 = treeSet.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }
    }
}
