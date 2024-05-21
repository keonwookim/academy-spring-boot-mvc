package com.nhnacademy.springbootmvc.domain;

import lombok.Value;

@Value
public class UserRegisterRequest2 {
    String id;
    String password;
    //TODO age를 없앤다면?
//    int age;

}
