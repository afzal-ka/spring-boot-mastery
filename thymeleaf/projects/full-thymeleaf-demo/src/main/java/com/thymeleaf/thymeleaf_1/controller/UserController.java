package com.thymeleaf.thymeleaf_1.controller;

import com.thymeleaf.thymeleaf_1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class UserController {
    @GetMapping("/variable-expression")
    public String variableExpression(Model model){
        User user = new User("Admin","admin@gmail.com",23,"male");
        model.addAttribute("user",user);
        return "variable-expression";
    }

    @GetMapping("/selection-expression")
    public String selectionExpression(Model model){
        User user = new User("User","user@gmail.com",23,"male");
        model.addAttribute("user",user);
        return "selection-expression";
    }

    @GetMapping("/message-expression")
    public String messageExpression(){
        return "message-expression";
    }

    @GetMapping("/link-expression")
    public String linkExpression(Model model){
        model.addAttribute("id",1);
        return "link-expression";
    }

    @GetMapping("/fragment-expression")
    public String fragmentExpression(){
        return "fragment-expression";
    }

    @GetMapping("/users")
    public String users(Model model){
        User admin = new User("Admin","admin@gmail.com",23,"male");
        User user = new User("User","user@gmail.com",23,"male");
        ArrayList<User> users = new ArrayList<>();
        users.add(admin);
        users.add(user);
        model.addAttribute("users",users);
        return "users";
    }

    @GetMapping("/if-unless")
    public String ifUnlessL(Model model){
        User u1 = new User("Admin","admin@gmail.com",23,"male");
        User u2 = new User("User","user@gmail.com",23,"male");
        ArrayList<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        model.addAttribute("users",users);
        return "if-unless";
    }

    @GetMapping("/switch-case")
    public String switchCase(Model model){
        User u1=new User("afzal","afzal@gmail.com",23,"Admin","male");
        model.addAttribute("user",u1);
        return "switch-case";
    }
}
