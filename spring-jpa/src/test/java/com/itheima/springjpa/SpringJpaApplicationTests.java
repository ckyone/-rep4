package com.itheima.springjpa;

import com.itheima.springjpa.domain.User;
import com.itheima.springjpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class SpringJpaApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
        List<User> all = userRepository.findAll ();
        System.out.println (all);
    }

}
