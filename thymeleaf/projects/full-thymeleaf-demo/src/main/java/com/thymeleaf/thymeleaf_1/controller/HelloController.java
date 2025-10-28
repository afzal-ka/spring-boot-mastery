package com.thymeleaf.thymeleaf_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello-world")
    public String helloWorld(Model model){
        model.addAttribute("message","Hello World");
        return "hello-world";
    }
}
