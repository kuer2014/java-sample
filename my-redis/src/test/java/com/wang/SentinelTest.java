package com.wang;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-04-09 10:03  by  王帅（wangshuai@cloud-young.com）创建
 */
public class SentinelTest {
    private RedissonClient redissonClient() {
        Config config = new Config();
        config.useSentinelServers()
                //.addSentinelAddress("192.168.50.50:46379","192.168.50.51:46380","192.168.50.52:46381") //dev
                .addSentinelAddress("192.168.50.40:46379","192.168.50.41:46380","192.168.50.42:46381") //uat
                .setMasterName("mysentinel")
                .setDatabase(1)
                .setPassword("myredis");
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }
    @Test
    public void test1(){
        RedissonClient client=redissonClient();
        //set
        RBucket str = redissonClient().getBucket("WMEC_HOME_LAYER_CACHE_KEY_123");
        str.set("true"); //redis 中 str ="\"bbb\""
        //get
        String strVal = client.getBucket("WMEC_HOME_LAYER_CACHE_KEY_123").get() + "";//redis 中key str ="\"bbb\""
       // client
        System.out.println("str = " + strVal);// out str = bbb
    }
}
