package com.nhnacademy.springbootmvc.domain;

import lombok.Value;

@Value
public class UserRegisterRequest {
    String id;
    String password;
    int age;

    // TODO #3: 이름 필드 추가
    String name;
}
