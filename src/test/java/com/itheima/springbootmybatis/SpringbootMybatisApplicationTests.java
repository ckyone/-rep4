package com.itheima.springbootmybatis;

import com.itheima.springbootmybatis.domain.User;
import com.itheima.springbootmybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
   UserMapper userMapper ;
    @Test
    void contextLoads() {
        List<User> users = userMapper.queryUserList ();
        System.out.println (users);
    }

    @Test
    void test(){
        System.out.println ("这是第二次尝试");
    }

}
