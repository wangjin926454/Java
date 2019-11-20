package java_volume.java_volume_2_1.optional;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

/**
 * 如果想要将流的结果约简为总和、平均值、最大值或最小值,如果约简没有任何元素，产生对应类型MAX_VALUE,MIN_VALUE
 * */
public class OptionalMaxAvgMinTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list.stream().max(Integer::compareTo));
        IntSummaryStatistics  sum = list.stream().collect(Collectors.summarizingInt(Integer::new));
        System.out.println("max: "+sum.getMax());
        System.out.println("avg " +sum.getAverage());
    }
}