package com.test.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @ClassName RedisConfig
 * @Description TODO
 * @Author lcx
 * @Date 2024/2/25 19:35
 * @Version 1.0
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

        // 注入连接共享
        // 实例化
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        // 配置序列化的方式（数据转换的方式）
        // 设置key的序列化方式
        template.setKeySerializer(RedisSerializer.string());
        // 设置value的序列化方式
        template.setValueSerializer(RedisSerializer.json());
        // 设置哈希的key的序列化方式
        template.setHashKeySerializer(RedisSerializer.string());
        // 设置哈希的value的序列化方式
        template.setHashValueSerializer(RedisSerializer.json());

        // 做完设置后触发
        template.afterPropertiesSet();

        return template;
    }

}
