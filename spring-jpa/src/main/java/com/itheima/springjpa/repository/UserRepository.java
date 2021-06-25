package com.itheima.springjpa.repository;

import com.itheima.springjpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    public List<User> findAll();
}
