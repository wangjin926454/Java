package redis.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PublishMsg extends Thread{

    private final JedisPool jedisPool;

    public PublishMsg(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Override
    public void run() {
        System.out.println("Enter:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Jedis jedis = jedisPool.getResource();  //连接池中取出一个连接
        while (true) {
            String line = null;
            try {
                line = reader.readLine();
                if (!"quit".equals(line)) {
                    jedis.publish("channel", line);  //从 channel 的频道上推送消息
                } else {
                    break;
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }
}