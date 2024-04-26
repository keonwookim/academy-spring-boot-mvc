package com.nhnacademy.springbootmvc.domain;

import lombok.Getter;

@Getter
public class User {
    private final String id;
    private final String name;

    private User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static User create(String id, String name) {
        return new User(id, name);
    }
}

