package java_volume.java_volume_1_7;

import java.util.BitSet;
import java.util.Iterator;

/**
 * BitSet位集 比使用Boolean的ArrayList更加高效
 * */
public class BitSetTest {
    public static void main(String[] args){
        BitSet bitSet = new BitSet(100);
        for(int i=0;i<bitSet.size();i++){
            bitSet.set(i);
        }
        for(int i=0;i<bitSet.size();i++){
            System.out.println(bitSet.get(i));
        }
    }
}
