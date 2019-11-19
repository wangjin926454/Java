package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis 连接池  为单例模式
 * */
public class JedisPoolUtil {
    private static volatile JedisPool jedisPool;
    private JedisPoolUtil(){

    }
    public static JedisPool getJedisPoolInstance(){
        if(jedisPool==null){
            synchronized (JedisPoolUtil.class){
                if(jedisPool==null){
                    JedisPoolConfig config = new JedisPoolConfig();
                    config.setMaxWaitMillis(1000*100);//最大空闲时间
                    config.setMaxTotal(1000);//最大jedis实例
                    config.setMaxIdle(50); //最大jedis空闲实例
                    config.setTestOnBorrow(true); //取得连接时判断是否可用
                    jedisPool = new JedisPool(config,"localhost",6380);
                    return jedisPool;
                }
            }
        }
        return jedisPool;
    }
}

