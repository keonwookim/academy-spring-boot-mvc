package com.nhnacademy.springbootmvc.controller;

import com.nhnacademy.springbootmvc.domain.User;
import com.nhnacademy.springbootmvc.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user3")
public class ModelAttributeController3 {
    private final UserRepository userRepository;

    public ModelAttributeController3(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ModelAttribute("commonData")
    public String getCommonData() {
        return "common data";
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable("userId") String userId,
                          Model model) {
        User user = userRepository.getUser(userId);
        model.addAttribute("user", user);
        return "user2";
    }
}
