package redis;

import redis.clients.jedis.Jedis;

/**
 * redis中set操作
 * */
public class RedisSet {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.sadd("set01","1","1","2","3","4");
        System.out.println("set01的元素为:"+jedis.smembers("set01"));//获取set中的值
        System.out.println(jedis.sadd("set01","1","1","2","3","4","5"));//会把没有的元素添加进去
        System.out.println("set01中的元素个数为:"+jedis.scard("set01"));
        System.out.println("set01中移除元素为4的："+jedis.srem("set01","4"));
        System.out.println("set01的元素为:"+jedis.smembers("set01"));//获取set中的值
        System.out.println("随机获取set01中的一个元素："+jedis.srandmember("set01",2));
        System.out.println(jedis.sadd("set01","6","7","8","9","10","11"));
        System.out.println("随机出栈:"+jedis.spop("set01"));
        jedis.sadd("set02","1","2","3","4");
        jedis.smove("set01","set02","11");//set01 中 11 move、 进 set02
        System.out.println("set02中smove进11后："+jedis.smembers("set02"));
        System.out.println("set01："+jedis.smembers("set01"));
        System.out.println("set02："+jedis.smembers("set02"));
        System.out.println("set02相对于set01的相对补集(在set01中不在set02中):"+jedis.sdiff("set01","set02"));
        System.out.println("set02相对于set01的并集:"+jedis.sunion("set01","set02"));//union
        System.out.println("set02相对于set01的交集:"+jedis.sinter("set01","set02"));//inter
    }
}
