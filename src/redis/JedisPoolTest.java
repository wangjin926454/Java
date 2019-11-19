package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisPoolTest {
    public static void main(String[] args) {
        JedisPool pool = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = pool.getResource();
        jedis.close();
        System.out.println(jedis.get("k2"));
    }
}
