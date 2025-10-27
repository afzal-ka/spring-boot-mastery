# Exercise — Forms and Data Binding in Thymeleaf

## Objective

**Learn how to:**

- Create an HTML form in Thymeleaf.
- Bind form fields to a backend model object.
- Handle form submissions in a Spring Boot controller.
- Display the submitted data on a result page.

---

## Project Overview

In this exercise, you will build a simple User Registration Form using Thymeleaf and Spring Boot.
The form will collect a user’s name and email, bind them to a `User` model, and display the submitted information after form submission.

---

## Steps

### 1. Create the Model Class

File: `src/main/java/com/example/demo/model/User.java`

```java
package com.example.demo.model;

public class User {
    private String name;
    private String email;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```
### 2. Create the Controller

File: `src/main/java/com/example/demo/controller/RegistrationController.java`

```java
package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("message", "Registration successful for " + user.getName());
        return "result";
    }
}
```

### 3. Create the Registration Form Template

File: `src/main/resources/templates/register.html`

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
</head>
<body>
<h2>User Registration Form</h2>

<form th:action="@{/register}" th:object="${user}" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" th:field="*{name}" required />

    <br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" th:field="*{email}" required />

    <br><br>

    <button type="submit">Register</button>
</form>

</body>
</html>
```

### 4. Create the Result Template

File: `src/main/resources/templates/result.html`

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Registration Result</title>
</head>
<body>
<h2 th:text="${message}"></h2>

<p><strong>Name:</strong> <span th:text="${user.name}"></span></p>
<p><strong>Email:</strong> <span th:text="${user.email}"></span></p>
</body>
</html>
```
---

## Test the Application

1. Run your Spring Boot application.
2. Navigate to http://localhost:8080/register
.
3. Fill out the form and submit it.
4. The result page should display:
- A success message.
- The submitted user name and email.

---
