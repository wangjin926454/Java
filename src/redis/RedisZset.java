package redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;

/**
 * Zset操作  zset即是set的不重复与hash的key value即Java中HashMap
 * */
public class RedisZset {
    public static void main(String[] args) {
        Jedis redis = new Jedis("localhost");
        System.out.println(redis.del("wnagjin"));
        HashMap<String,Double> hashMap = new HashMap<>();
        hashMap.put("age",21d);
        System.out.println(redis.zadd("zset",hashMap));
        System.out.println("redis 获取zset中score值，即map中的key"+redis.zrange("zset",0,-1));
        //[[[97, 103, 101],21.0]]  97==a 103==g 101==e
        System.out.println(redis.zrangeWithScores("zset",0,-1));
        System.out.println(redis.zremrangeByScore("zset",0,21));
        System.out.println(redis.zrangeByScoreWithScores("zset",0,21,0,1));//分页
    }

}
