# Exercise — Conditionals and Loops in Thymeleaf

## Objective

- Learn to control content rendering in Thymeleaf templates using conditional statements and loops.
- This exercise demonstrates how to:
- Display lists dynamically with th:each.
- Conditionally show or hide content using th:if and th:unless.
- Handle multiple cases using th:switch and th:case.

---

## Project Overview

- Enhance a Spring Boot + Thymeleaf project to:
- Render a list of users dynamically
- Display conditional messages for admin vs. regular users
- Show role-based content using a switch-case structure

---

## Steps

### 1. Create Controller

File: `src/main/java/com/example/demo/controller/UserController.java`

```java
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/users")
    public String showUsers(Model model) {

        List<String> users = Arrays.asList("Alice", "Bob", "Charlie");

        model.addAttribute("users", users);
        model.addAttribute("isAdmin", true);
        model.addAttribute("role", "ADMIN");

        return "user-list";
    }
}
```

### 2. Create Thymeleaf Template

File: `src/main/resources/templates/user-list.html`
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>
<h2>User List</h2>

<!-- Loop Example -->
<ul>
    <li th:each="user : ${users}" th:text="${user}"></li>
</ul>

<!-- Conditional Example -->
<p th:if="${isAdmin}">You have admin privileges.</p>
<p th:unless="${isAdmin}">You are a regular user.</p>

<!-- Switch Example -->
<div th:switch="${role}">
    <p th:case="'ADMIN'">Welcome, Administrator!</p>
    <p th:case="'USER'">Welcome, User!</p>
    <p th:case="*">Welcome, Guest!</p>
</div>

</body>
</html>
```

---

## Test the Application

1. Run your Spring Boot application.
2. Open http://localhost:8080/users
.
3. Verify:
- The list of users is displayed.
- Admin message appears if `isAdmin` is true.
- Role-based message is shown according to `role` value.

---

