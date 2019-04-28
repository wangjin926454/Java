package redis.transaction;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;


public class TransactionDemo {
    public static void main(String[] args){
        Jedis jedis = new Jedis("localhost");
        Transaction  t = jedis.multi();
        t.set("ssss","ssss");
        t.exec();
        System.out.println(jedis.get("ssss"));
        //jedis.del("sss");
    }
}
