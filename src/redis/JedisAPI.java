package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;


/**
 * Redis API
 * */
public class JedisAPI {
    static Jedis redis_M = new Jedis("localhost",6380);
    static Jedis redis_S = new Jedis("localhost",6379);
    static {
        redis_S.slaveof("localhost",6380);
    }

    public static boolean redisMulti()throws Exception{
        int sales = 30;
        redis_M.watch("balance");
        //redis.set("balance","200");
        Thread.sleep(5000);
        int balance = Integer.parseInt(redis_S.get("balance"));
        if(balance<sales){
            redis_M.unwatch();
            System.out.println("钱不够");
            return false;
        }else{
            Transaction multi = redis_M.multi();
            multi.decrBy("balance",sales);
            multi.incrBy("modify",sales);
            List<Object> exec = multi.exec();
            exec.forEach(System.out::println);
            redis_M.unwatch();
            System.out.println("success");
            return true;
        }
    }


    public static void main(String[] args) throws Exception{
        //boolean b = redisMulti();
        redis_M.set("k2","2");
        String k2 = redis_S.get("k2");
        System.out.println(k2);
    }
}
