package com.nhnacademy.springbootmvc.controller;

import com.nhnacademy.springbootmvc.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // TODO #2: 게시물 조회 구현
    @GetMapping("/{postId}")
    public String viewPost() {
        // ...
        return "postView";
    }

    // TODO #3: 게시물 수정 form 구현
    @GetMapping("/{postId}/modify")
    public String postModifyForm() {
        // ...
        return "postModify";
    }
}
