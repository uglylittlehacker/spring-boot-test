package com.uglylittle.boot_11;

import com.uglylittle.boot_11.entity.Student;
import com.uglylittle.boot_11.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

@SpringBootTest
class Boot11ApplicationTests {

    @Autowired
    private RedisTemplate<String,String> stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
//        stringRedisTemplate.opsForHash().put("kk","k1","v1");
//        System.out.println(stringRedisTemplate.opsForHash().entries("kk"));
        Student student = new Student();
        student.setSex("男");
        student.setName("卡萨丁");
        student.setAddress("湖南长沙");
        student.setAge("20");
        mongoTemplate.insert(student);
    }


}
