package java_volume.java_volume_1_7;

import java.lang.reflect.AccessibleObject;
import java.util.*;

public class ReflectTest {
    private String str = "private test";
    public String str1 = "public test1";
    protected  String str2 = "protected test";
    String str3 ="default test";
    public ReflectTest(){

    }

    public String getStr() {
        return str;
    }

    public ReflectTest(String str, String str1, String str2, String str3){
        this.str=str;
        this.str1=str1;
        this.str2=str2;
        this.str3=str3;
    }
    private void test(){
        System.out.println("private method");
    }
    public void test1(String test1){
        System.out.println("public method "+test1);
    }
    protected void test2(){
        System.out.println("protected method");
    }
    void test3(){
        System.out.println("default method");
    }
    public static void main(String[] args){
        Map<String,String> map = new TreeMap<String, String>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        for(String key: map.keySet()){
            System.out.println(key+" "+map.get(key));
        }
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().compareToIgnoreCase(o2.getKey());
            }
        });
        for(Map.Entry<String,String> list1:list){
            System.out.println(list1.toString());
        }

    }
}
