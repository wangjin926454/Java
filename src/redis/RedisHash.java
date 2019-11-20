package redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;

/**
 * redis Hash类型的操作
 * */
public class RedisHash {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.del("hash");
        jedis.hset("hash","age","22");
        System.out.println(jedis.hget("hash","age"));
        jedis.del("mhash");
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("name","wangjin");
        hashMap.put("age","22");
        hashMap.put("sex","nan");
        jedis.hmset("mhash",hashMap);System.out.println("redis 中 hmset:"+ jedis.hgetAll("mhash"));
        System.out.println("redis 中 hmset:"+ jedis.hgetAll("mhash"));
        System.out.println("redis 的Hash中是否存在某个key："+jedis.hexists("mhash","ss"));
        System.out.println("获取redis hash中所有key"+jedis.hkeys("mhash"));
        System.out.println("获取redis hash中所有value"+jedis.hvals("mhash"));
        System.out.println("对redis中 hash中某个属性进行加减"+jedis.hincrBy("mhash","age",2));
        System.out.println("redis 中 hmset:"+ jedis.hgetAll("mhash"));
        System.out.println("对redis中 hash中某个属性进行加减"+jedis.hincrByFloat("mhash","age",0.5));
        System.out.println("redis 中 hmset:"+ jedis.hgetAll("mhash"));
        System.out.println(jedis.hsetnx("hash","age","2"));

    }
}
