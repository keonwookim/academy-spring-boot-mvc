package com.nhnacademy.springbootmvc.controller;

import com.nhnacademy.springbootmvc.domain.User;
import com.nhnacademy.springbootmvc.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user2")
public class ModelAttributeController {
    private final UserRepository userRepository;

    public ModelAttributeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ModelAttribute("user")
    public User getUser(@PathVariable("userId") String userId) {
        return userRepository.getUser(userId);
    }
    @GetMapping("/{userId}")
    public String viewUser() {
        return "user";
    }

    @GetMapping("/{userId}/modify")
    public String modifyUser() {
        return "userModify";
    }

    // TODO: userId를 받지 않아 User를 조회하지 않은 메서들 추가하면?
//    @PostMapping("/register")
//    public String regiterFrom() {
//        return "userRegister";
//    }


}
