package com.nhnacademy.springbootmvc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

// TODO #2: Java Config 파일 - @PropertySource 를 통해 properties 파일 가져오기
@Configuration
@PropertySource("classpath:some.properties")
public class PropertiesConfig {
    @Value("${key1}")
    private String key1;

    @Bean
    public List<String> keys(@Value("${key2}") String key2) {
        List<String> list = new ArrayList<>();
        list.add(key1);
        list.add(key2);

        return list;
    }

}
