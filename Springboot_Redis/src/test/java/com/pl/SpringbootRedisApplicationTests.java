package com.pl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.Serializable;

@SpringBootTest
class SpringbootRedisApplicationTests {

    @Autowired
    RedisConnectionFactory connectionFactory;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate<String, Serializable> redisCacheTemplate;

    @Test
    void contextLoads() {

        RedisConnection connection = connectionFactory.getConnection();
        connection.set("Hello Redis!".getBytes(), "Hello Redis!".getBytes());
        System.out.println(new String(connection.get("Hello Redis!".getBytes())));

        stringRedisTemplate.opsForSet().add("heheda", "李飘");
        System.out.println(stringRedisTemplate.opsForSet().pop("heheda"));

    }

}
