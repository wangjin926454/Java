package java_volume.java_volume_2_1.optional;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 收集约简结果集映射到映射表中
 * */
public class CollectOptionalResultToMap {
    public static void main(String[] args){
        ArrayList<People> list = new ArrayList<>();
        list.add(new People("aaa","bbb"));
        list.add(new People("aaa","bbb1"));
        list.add(new People("ccc","ddd"));

        //将Peoper.getName()，People.getPwd()结果映射到Map中
        //获取name,pwd属性值
        //Map<String,String> map = list.stream().collect(Collectors.toMap(People::getName,People::getPwd));

        //获取name值，以及实际元素(例如bean或list中的bean,此处获取People)
        //Map<String,People> map = list.stream().collect(Collectors.toMap(People::getName, Function.identity()));

        //处理多个元素具有相同的键，否则抛出IllegalStateException
        Map<String,String> map =
                list.stream().collect(Collectors.toMap(People::getName,People::getPwd,(exitingValue,newValue)->newValue));//覆盖前一个值
        System.out.println(map.toString());
        ConcurrentHashMap<String,String> map1 =
                list.stream().collect(
                        Collectors.toConcurrentMap(People::getName,People::getPwd,
                                (exitingValue,newValue)->newValue,ConcurrentHashMap::new));//覆盖前一个值
        System.out.println(map1.toString());
        //不关心重复出现的数据，只记录第一次
        /*Stream<Locale> local = Stream.of(Locale.getAvailableLocales());
        Map<String,Set<String>> counLanguageSets =
                local.collect(Collectors.toMap(
                        Locale::getDisplayCountry,
                        l->Collectors.singleton(l.getDisplayLanguage()),
                (a,b)->
                {
                    Set<String> union = new HashSet<>(a);
                    union.addAll(b);
                    return union;
                }));*/
        Set<String> set = map.keySet();
        //forEach遍历输出
        set.forEach(x->System.out.println(map.get(x)));
    }
}
class People{
    private String name;
    private String pwd;
    People(String name,String pwd){
        this.name=name;
        this.pwd=pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}