package com.itheima.springjpa;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.springjpa.domain.User;
import com.itheima.springjpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest
public class JpaTets {

    @Autowired
     RedisTemplate<String,String> redisTemplate;

    @Autowired
    UserRepository userRepository;

    @Test
    void test1(){
//        从redis中获得数据 数据形式json的字符串
        String userListJson = redisTemplate.boundValueOps ("user.findAll").get ();
//        判断redis中是否存在数据
        if (null == userListJson){
//            不存在数据，从数据库里面查
            List<User> all = userRepository.findAll ();

//            将list集合转换为json格式的字符串，使用Jackson进行转换
            ObjectMapper objectMapper = new ObjectMapper ();
            try {
                userListJson = objectMapper.writeValueAsString (all);
            } catch (JsonProcessingException e) {
                e.printStackTrace ();
            }
//            将数据存在redis中
            redisTemplate.boundValueOps ("user.findAll").set (userListJson);
            System.out.println ("从数据库中获得");
        }else {
            System.out.println ("从redis中获得");
        }

        System.out.println (userListJson);


    }
}
