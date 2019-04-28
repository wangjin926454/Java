package redis;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import redis.clients.jedis.Jedis;

import java.util.*;

public class RedisDemo {
    public static void main(String[] args) throws Exception{
        //连接本地redis
        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis+"连接成功");
        //ping测试
        System.out.println(jedis.ping());
        //设置一个key value
        jedis.set("key","value");
        //获取
        System.out.println(jedis.get("key"));
        //push操作，先进后出
        jedis.lpush("list","a");
        jedis.lpush("list","b");
        jedis.lpush("list","c");
        jedis.lpush("list","d");
        //取出，与进的顺序相反
        List list = jedis.lrange("list",0,2);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        //读取所有key并且迭代输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
        //redis储存map对象
        Map<String,String> map = new HashMap();
        map.put("a","a");
        map.put("b","b");
        map.put("c","c");
        jedis.hmset("map",map);
        System.out.println(jedis.hgetAll("map"));

        Info info = new Info("wangjin","wangjin");
        Info info1 = new Info("wangjin1","wangjin1");
        Map<String,Info> map1 = new HashMap<String,Info>();
        map1.put("info",info);
        map1.put("info1",info1);
        ObjectMapper mapper = new ObjectMapper();
        //list转map然后转json
        String json = mapper.writeValueAsString(map1);
        jedis.set("map1",json);
        System.out.println(jedis.get("map1"));
        //list 转json对象
        List<Info> list2 = new ArrayList<Info>();
        list2.add(info);
        list2.add(info1);
        //list转json
        String json1 = mapper.writeValueAsString(list2);
        System.out.println(json1);
        //json转ArrayList
        /*JavaType jt = mapper.getTypeFactory().constructParametricType(ArrayList.class,Info.class);
        List<Info> list3 = mapper.readValue(json1,jt);
        System.out.println(list3);*/
        //Hyper LogLog类似于set但是不存储值
        jedis.pfadd("pf","a");
        jedis.pfadd("pf","a");
        jedis.pfadd("pf","a");
        jedis.pfadd("pf","a");
        jedis.pfadd("pf","b");
        jedis.pfadd("pf","c");
        jedis.pfadd("pf","d");
        System.out.println(jedis.pfcount("pf"));
    }
}
