package com.nhnacademy.springbootmvc.controller;

import com.nhnacademy.springbootmvc.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/post/register")
public class PostRegisterController {
    private final PostRepository postRepository;

    public PostRegisterController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public String userRegisterForm() {
        return "postRegister";
    }

    // TODO #1: 게시물 등록 처리 구현
    @PostMapping
    public ModelAndView registerPost() {
        return null;
    }

}
