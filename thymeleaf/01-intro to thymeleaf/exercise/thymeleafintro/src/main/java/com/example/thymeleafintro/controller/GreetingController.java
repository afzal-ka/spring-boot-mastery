package com.example.thymeleafintro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping
    public String showGreeting(Model model){
        model.addAttribute("name","Explorer");
        model.addAttribute("message","Welcome to Thymeleaf Basics");
        model.addAttribute("showSpecialMessage",true);
        return "greeting";
    }
}
