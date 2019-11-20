package redis;

import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;

/**
 * redis中List数据类型的存储以及操作
 *
 * */
public class RedisList {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.del("lpush","rpush");
        jedis.lpush("lpush","1","2","3","4","5");
        jedis.rpush("rpush","1","2","3","4","5");
        jedis.lpush("lpush","6"); //如果已存在则添加进去
        //lrange操作影响原来的值
        System.out.println("lpush进行lrange结果："+jedis.lrange("lpush",0,-1));
        System.out.println("rpush进行lrange结果："+jedis.lrange("rpush",0,-1));
        System.out.println("lpop结果："+jedis.lpop("lpush"));//结果为5
        //pop影响原来的值
        System.out.println("pop操作影响原来的值:"+jedis.lrange("lpush",0,-1));
        System.out.println("lpush rpop:"+jedis.rpop("lpush"));//结果为1
        System.out.println("rpush lpop:"+jedis.lpop("rpush"));//结果为1
        System.out.println("rpush rpop:"+jedis.rpop("rpush"));//结果为1
        System.out.println("lpush lindex:"+jedis.lindex("lpush",0));
        System.out.println("rpush lindex:"+jedis.lindex("rpush",0));
        jedis.del("list");
        jedis.rpush("list","1","2","3","4","5","6","7");
        System.out.println("移除key中count个value："+jedis.lrem("list",1,"3"));
        System.out.println("移除key中count个value后的list："+jedis.lrange("list",0,-1));
        System.out.println("截取key中从start到end的字符然后赋给该key："+jedis.ltrim("list",2,5));
        System.out.println("截取key中从start到end的字符后的值："+jedis.lrange("list",0,-1));
        System.out.println("lpush："+jedis.lrange("lpush",0,-1));
        System.out.println("rpush："+jedis.lrange("rpush",0,-1));
        jedis.rpoplpush("lpush","rpush");
        System.out.println("rpoplpush rpush"+jedis.lrange("rpush",0,-1));
        System.out.println("lpush："+jedis.lrange("lpush",0,-1));
        System.out.println("rpush："+jedis.lrange("rpush",0,-1));
        jedis.brpoplpush("lpush","rpush",2);
        System.out.println("brpoplpush rpush"+jedis.lrange("rpush",0,-1));
        jedis.lset("rpush",0,"a");
        System.out.println("lset rpush 0 a -> rpush:"+jedis.lrange("rpush",0,-1));
        jedis.linsert("rpush", BinaryClient.LIST_POSITION.AFTER,"4","java");
        System.out.println("linsert rpush after 4  'java' -> rpush:"+jedis.lrange("rpush",0,-1));
        jedis.linsert("rpush", BinaryClient.LIST_POSITION.BEFORE,"a","Think in");
        System.out.println("linsert rpush before a  'Think in ' -> rpush:"+jedis.lrange("rpush",0,-1));
    }
}
