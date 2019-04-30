package sourcescode.collection.mapandset;


import java.util.*;

/**
 * LinkedHashMap And LinkedHashSet Source Demo
 * */
public class LinkedHashMapAndLinkedHashSetSourceDemo {
    public static void main(String[] args){
        LinkedHashMap hashMap = new LinkedHashMap();    //wuxu
        LinkedHashSet hashSet = new LinkedHashSet();    //wuxu
        //HashMap hashMap = new HashMap();      //youxu
        //HashSet hashSet = new HashSet();      //youxu
        Random r = new Random();
        for(int i=0;i<10;i++){
            int n = r.nextInt(100);
            //System.out.println(n);
            hashMap.put(""+n,n);
            hashSet.add(n);
        }
        Iterator it = hashMap.entrySet().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        Iterator it1 = hashSet.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }
    }
}
