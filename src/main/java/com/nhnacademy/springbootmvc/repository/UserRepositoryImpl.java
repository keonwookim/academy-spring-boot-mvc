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
        userMap.put("1", User.create("1", "Tom"));
        userMap.put("2", User.create("2", "Jake"));
        userMap.put("3", User.create("3", "Ethan"));
    }

    @Override
    public List<User> getUsers() {
        return userMap.values().stream().toList();
    }

}
