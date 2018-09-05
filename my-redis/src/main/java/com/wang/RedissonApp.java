package com.wang;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/30 15:42  by  王帅（wangshuai@cloud-young.com）创建
 */
public class RedissonApp {
    public static void main(String[] args) {
        //单实例
//        Config config=new Config();
//        config.useSingleServer()
//                .setAddress("127.0.0.1:6379")
//                .setPassword("111")

        //集群 ,redis默认未启用  //修改配置  redis.conf  配置集群  修改redis.config，添加cluster-enabled yes
        Config config=new Config();
        //config.setTransportMode(TransportMode.EPOLL);
        config.useClusterServers()
                .setScanInterval(1000) //集群状态扫描间隔,以毫秒为单位
                .addNodeAddress("127.0.0.1:9001", "127.0.0.1:9002", "127.0.0.1:9003")//多个服务构成集群
                //.addNodeAddress("redis://127.0.0.1:6379")//redis:// 启用ssl连接
                .addNodeAddress("127.0.0.1:9004", "127.0.0.1:9005", "127.0.0.1:9006")//.setPassword("111")

        ;
        //**** cofnig from/to  file *****
        //1 json
        //Config config = Config.fromJSON(new File("config-file.json"));
        //String jsonFormat = config.toJSON();
        //2 yaml
        //Config config = Config.fromYAML(new File("config-file.yaml"));
        //String jsonFormat = config.toYAML();
        //3 Spring XML

        RedissonClient redissonClient = Redisson.create(config);
        //字符串
RBucket str =redissonClient.getBucket("str31");
str.set("abc31");
//str.set(999);
        System.out.println("str= "+str.get());

        //列表
        RList list1=redissonClient.getList("list2");
        list1.add(91);
        list1.add(92);
        list1.add(93);
        //流
//RBinaryStream stream =redissonClient.getBinaryStream("stream");
        //消息
//        RTopic<String> topic= redissonClient.getTopic("topic");
//        topic.addListener()
        redissonClient.shutdown();
    }
}
