package com.nhnacademy.springbootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/mustache")
    public String mustacheIndex(Model model) {
        model.addAttribute("message", "Hello World!");
        return "mustache/index";
    }
}
