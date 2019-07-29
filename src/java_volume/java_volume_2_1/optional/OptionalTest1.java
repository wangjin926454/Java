package java_volume.java_volume_2_1.optional;

public class OptionalTest1 {
    public static void main(String[] args){
        /**
         * Optional<T> of（T value)产生一个具有value值类型的Optional,如果value为空，出现NullPointerException
         * Optional<T> ofNullable(T value)产生一个具有value值类型的Optional,如果value为null返回一个空的Optional
         * Optional<T> empty();产生一个空的Optional
         * flatMap(Function<? super T,Optional<U>> mapper) 将mapper方法应用于Optional值所产生的结果。如果Optional<U>为空。返回一个空的Optional
         *
         * forEach遍历流但是会以任意顺序遍历各个元素。如果想要保持顺序可以使用forEachOrdered
         * */
    }
}
