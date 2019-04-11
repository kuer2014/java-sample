package com.wang.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * Description:Redis 配置类
 * All Rights Reserved.
 *
 * @version 1.0  2019-04-10 17:13  by  王帅（wangshuai@cloud-young.com）创建
 */
@Configuration
@ComponentScan(value = "com.wang.spring")
@EnableRedisRepositories(basePackages = "com.wang.spring.dao")//（默认值,redisTemplateRef = "redisTemplate",redisTemplateRef = "redisTemplate"）
// @EnableRedisRepositories()参数说明：见 https://blog.csdn.net/pengdandezhi/article/details/78983451
public class RedisConfig {
    @Bean
    public RedisConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration standaloneConfig = new RedisStandaloneConfiguration();
        standaloneConfig.setDatabase(1);
        RedisConnectionFactory   connectionFactory =new JedisConnectionFactory(standaloneConfig);
        return connectionFactory;
    }
    @Bean
    public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
