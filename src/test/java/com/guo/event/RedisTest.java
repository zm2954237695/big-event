package com.guo.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTest {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    @Test
    public void testSet(){
        stringRedisTemplate.opsForValue().set("username","zhangsan");
        stringRedisTemplate.opsForValue().set("id","1",15, TimeUnit.SECONDS);
    }

    @Test
    public void testGet() {
        System.out.println(stringRedisTemplate.opsForValue().get("username"));
    }
}
