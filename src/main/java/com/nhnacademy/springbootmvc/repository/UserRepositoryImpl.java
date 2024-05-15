package com.nhnacademy.springbootmvc.repository;

import com.nhnacademy.springbootmvc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<String, User> userMap = new HashMap<>();

    public UserRepositoryImpl() {
        userMap.put("1", User.create("tom", "1234"));
        userMap.put("2", User.create("jake", "5678"));
        userMap.put("3", User.create("ethan", "1010"));
    }

    @Override
    public List<User> getUsers() {
        return userMap.values().stream().toList();
    }

    @Override
    public User getUser(String id) {
        return userMap.get(id);
    }
}
