package com.nhnacademy.springbootmvc.controller;

import com.nhnacademy.springbootmvc.domain.User;
import com.nhnacademy.springbootmvc.domain.UserRegisterRequest2;
import com.nhnacademy.springbootmvc.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user2/register")
public class ModelAttributeController2 {
    private final UserRepository userRepository;

    public ModelAttributeController2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String viewRegisterForm() {
        return "userRegister2";
    }

    @PostMapping
    public String registerUser(@ModelAttribute UserRegisterRequest2 request,
                               Model model) {
        System.out.println("id: " + request.getId() + "pwd: " + request.getPassword());
        User user = userRepository.addUser(request.getId(), request.getPassword());
        model.addAttribute("user", user);
        return "user";
    }
}
