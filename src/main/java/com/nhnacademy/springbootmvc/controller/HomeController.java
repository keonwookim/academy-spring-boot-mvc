package com.nhnacademy.springbootmvc.controller;

import com.nhnacademy.springbootmvc.model.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/converter")
    public String converter(@RequestParam("role") Role role, Model model) {
        model.addAttribute("role", role);
        return "role";
    }

    @GetMapping("/formatter")
    public String formatter(@RequestParam("date") LocalDate date, Model model) {
        model.addAttribute("date", date);
        return "localdate";
    }
}
