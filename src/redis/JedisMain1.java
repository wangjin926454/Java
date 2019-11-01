package redis;

import redis.clients.jedis.Jedis;

public class JedisMain1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        String value = jedis.get("key");
        System.out.println(value);
    }
}
