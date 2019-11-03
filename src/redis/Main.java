package redis;

import redis.Person;
import redis.clients.jedis.Jedis;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");  //连接redis
        System.out.println(jedis.ping());
        System.out.println(jedis.get("key"));
        jedis.select(1);  //切换redis库
        System.out.println(jedis.get("key"));
        jedis.select(0);
        System.out.println(jedis.get("key"));
        System.out.println(jedis.dbSize());  //reids 库数量
        System.out.println(jedis.keys("*"));//reids 显示redis所有库
        List<Person> list = new ArrayList<>();
        list.add(new Person("wangjin", 33, "nan"));
        jedis.set("wangjin", list.toString());
        HashMap<String,String> map = new HashMap<>();
        map.put("a","a");
        map.put("b","b");
        jedis.set("map",map.toString());
        System.out.println(jedis.get("wangjin"));
        System.out.println(jedis.get("map"));
    }
}
