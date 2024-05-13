package com.nhnacademy.springbootmvc.controller;

import com.nhnacademy.springbootmvc.domain.User;
import com.nhnacademy.springbootmvc.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// TODO #1: UserController
//          GET /users/{userId}          : 사용자 정보 조회
//          GET /users/{userId}/modify   : 사용자 정보 수정 form
@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = userRepository.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/{userId}")
    public String getUser(Model model,
                          @PathVariable("userId") String id) {
        User user = userRepository.getUser(id);
        model.addAttribute("user", user);
        return "user";
    }
}
