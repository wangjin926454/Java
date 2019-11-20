package zookeeper;


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestZookeeper{

    private String connectString = "192.168.119.128:2181," +
            "192.168.119.131:2181," +
            "192.168.119.132:2181";
    private int sessionTimeout = 2000 * 10;

    private ZooKeeper zkCli;

    @Test
    public void test()throws Exception{
        zkCli = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                List<String> children = null;
                try {
                    children = zkCli.getChildren("/", true);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                children.forEach(System.out::println);
            }
        });
        Stat exists = zkCli.exists("/ideaCreate", false);
        if(exists!=null){
            System.out.println("/ideaCreate节点已存在!");
        }else{
            String s = zkCli.create("/ideaCreate", "ideaCreate".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(s);
        }
        Thread.sleep(Long.MAX_VALUE);
    }
}
