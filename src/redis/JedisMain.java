package redis;

import redis.clients.jedis.Jedis;

public class JedisMain {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.set("key","value");
        System.out.println(jedis.ping());
    }
}
