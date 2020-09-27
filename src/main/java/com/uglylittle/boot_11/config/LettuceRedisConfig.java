package com.uglylittle.boot_11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

//@Configuration
public class LettuceRedisConfig {

    /**
     * 默认情况下的模板只能支持 RedisTemplate<String,String>，只能存入字符串，很多时候，我们需要自定义 RedisTemplate ，
     * 设置序列化器，这样我们可以很方便的操作实例对象
     * @param connectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String,Serializable> redisTemplate = new RedisTemplate<>();
        //设置key序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置value序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        redisTemplate.setConnectionFactory(connectionFactory);

        return redisTemplate;
    }
 }
