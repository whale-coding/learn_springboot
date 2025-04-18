package com.star;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * @Classname: RedisTest
 * @Date: 2025/1/5 14:08
 * @Author: 聂建强
 * @Description: 用于测试redis
 */
@SpringBootTest  // 如果在测试类上添加了这个注解，那么将来单元测试方法执行之前，会先初始化Spring容器
public class RedisTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void insertRedis(){
        // 往redis中存储一个键值对
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

        operations.set("username", "zhangsan");

        // 存储键值对的时候设置过期时间
        operations.set("id","1",15, TimeUnit.SECONDS);
    }

    @Test
    public void getRedis(){
        // 从redis中获取一个键值对
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

        String username = operations.get("id");
        System.out.println(username);
    }
}
