package com.wang;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-04-10 15:16  by  王帅（wangshuai@cloud-young.com）创建
 */
public class LettuceTest {
    public static void main(String[] args) {
        // 连接串格式: redis://[password@]host[:port][/databaseNumber]
//        RedisClient redisClient = RedisClient.create("redis://password@localhost:6379/1");
        RedisClient redisClient = RedisClient.create("redis://127.0.0.1:6379/1");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        syncCommands.set("lettucekey", "Hello, Redis!");

        connection.close();
        redisClient.shutdown();
    }
}
