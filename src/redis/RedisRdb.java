package redis;

import redis.clients.jedis.Jedis;

/**
 * Redis RDB
 * */
public class RedisRdb {
    public static void main(String[] args) {
        Jedis redis = new Jedis("localhost");
        redis.set("rdb","rdb");
        redis.set("rdb1","rdb1");
    }
}
