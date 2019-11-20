package sourcescode.collection.mapandset;
import java.util.Iterator;
import java.util.TreeMap;
/**
 * TreeMap API以及源码分析
 * 为何有序？put时compare对当前元素key与parent元素的key进行排序，知道元素没有上一个元素或者下一个元素，类似冒泡排序
 */
public class TreeMapSourceTest {
    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<String, String>();
        treeMap.put("a","b");
        treeMap.put("z","y");
        treeMap.put("c","e");
        //遍历所有节点
        Iterator it = treeMap.entrySet().iterator();
        while(it.hasNext()){
            //自动排序 a c z
            System.out.println(it.next());
        }
        //key升序排列
        Iterator it1 = treeMap.navigableKeySet().iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }
        //key降序排列
        Iterator it2 = treeMap.navigableKeySet().descendingIterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
    }
}
