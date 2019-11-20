package redis;

import redis.clients.jedis.Jedis;
/**
 * redis中String类型的存储以及各种操作
 * */
public class RedisString {
    public static void main(String[] args) throws Exception {
        Jedis jedis = new Jedis("localhost");  //连接redis
        System.out.println(jedis.ping());
        System.out.println("获取key名称为key: "+jedis.get("key"));
        jedis.select(1);  //切换redis库
        System.out.println("切换redis库为1之后获取key名称为key: "+jedis.get("key"));
        jedis.select(0);
        System.out.println("切换redis库为0之后获取key名称为key: "+jedis.get("key"));
        jedis.set("test","test");
        System.out.println("redis库的数量为: "+jedis.dbSize());  //reids 库数量
        System.out.println("redis库中所有key: "+jedis.keys("*"));//reids 显示redis所有库
        jedis.move("key",1); //把所在库中的key移到dbindex中
        System.out.println("redis 0 库中key名称为key移到1库之后是否还存在key: "+jedis.get("key"));
        System.out.println("获取对应key的生命周期 -1为永久 -2为不可访问: "+jedis.ttl("wangjin"));
        jedis.expire("key",1);//10秒后过期 过期后状态为-2  在内存中删除
        Thread.sleep(1500);
        System.out.println("key生命周期结束之后查看是否存在: "+jedis.exists("key"));
        System.out.println("获取key的对应数据类型: "+jedis.type("wangjin"));
        System.out.println("map 在redis中已删除");
        jedis.del("map");
        System.out.println("获取key为wangjin的对应长度: "+jedis.strlen("wangjin"));
        jedis.set("len","5");//设置一个value类型为可加减的数字
        System.out.println("len 这个key的value为数字可以进行加减，减1后的值为: "+jedis.decr("len"));
        System.out.println("len 这个key的value为数字可以进行加减，减5后的值为: "+jedis.decrBy("len",5));
        System.out.println("len 这个key的value为数字可以进行加减，加1后的值为: "+jedis.incr("len"));
        System.out.println("len 这个key的value为数字可以进行加减，加1后的值为: "+jedis.incrBy("len",5));
        jedis.set("range","range");
        System.out.println("getrange 等于substr获取对应key从startOffset到endOffset: "+jedis.getrange("range",0,2));
        System.out.println("setrange 等于replace替换对应key从startOffset开始一个字符一个下标: "+jedis.setrange("range",0,"x"));
        System.out.println("setrange 替换之后: "+jedis.get("range"));
        jedis.setex("setex",1,"setex"); //设置值并设置过期时间
        Thread.sleep(1500);
        System.out.println("setex过期时间结束之后是否存在: "+jedis.get("setex"));
        jedis.setnx("wangjin","wangjin");//如果值不存在则设置，否则不设置,返回成功的数量
        System.out.println("set String 返回值?: "+jedis.set("return","return"));
        jedis.mset("mkey","mvalue","mkey1","mvalue1");
        System.out.println(jedis.mget("mkey","mkey1"));
        System.out.println("不存在时设置key如果有存在返回？: "+jedis.msetnx("mkey2","mvalue2","mkey1","mvalue3"));

        /*
        mset(more set)key value key1 value1.....多个key value
        mget key key1 ....获取该部分所有key
        msetnx 不存在则设置key，如果有一个失败则全部失败
        * */
    }
}
