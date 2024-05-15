package com.nhnacademy.springbootmvc.repository;

import com.nhnacademy.springbootmvc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<String, User> userMap = new HashMap<>();

    public UserRepositoryImpl() {
        userMap.put("tome", User.create("tom", "1234"));
        userMap.put("jake", User.create("jake", "5678"));
        userMap.put("ethan", User.create("ethan", "1010"));
    }

    @Override
    public List<User> getUsers() {
        return userMap.values().stream().toList();
    }


}
