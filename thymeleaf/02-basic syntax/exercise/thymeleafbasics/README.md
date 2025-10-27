# Exercise — Thymeleaf Basic Syntax

## Folder Structure

```text
02_basic_syntax/
├── notes.md
└── exercise/
    ├── pom.xml
    ├── src/
    │   ├── main/java/com/example/thymeleafbasics/controller/BasicController.java
    │   └── main/resources/templates/syntax.html
    └── README.md
```

--- 

## Objective
Learn how to:
- Use basic Thymeleaf expressions (`${}`, `*{}`, `@{}`) in templates.
- Apply conditional rendering and looping.
- Pass data from a Spring Boot controller to a template.

---

## Steps

### 1. Create a Spring Boot Project
If you don’t already have one, generate it using **Spring Initializr**:

- Project: Maven
- Language: Java
- Spring Boot: 3.x.x
- Group: `com.example`
- Artifact: `thymeleafbasics`
- Dependencies: **Spring Web**, **Thymeleaf**

Once generated, import it into IntelliJ or your preferred IDE.

---

### 2. Create Controller

File: `src/main/java/com/example/thymeleafbasics/controller/BasicController.java`

```java
package com.example.thymeleafbasics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BasicController {

    @GetMapping("/syntax")
    public String showSyntax(Model model) {
        model.addAttribute("name", "Learner");
        model.addAttribute("isActive", true);
        model.addAttribute("items", List.of("Item 1", "Item 2", "Item 3"));
        return "syntax";
    }
}
```

### 3. Create Thymeleaf Template

File: `src/main/resources/templates/syntax.html`

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Basic Syntax</title>
</head>
<body>
    <h1 th:text="'Hello, ' + ${name} + '!'">Hello, User!</h1>

    <p th:if="${isActive}">Status: Active</p>
    <p th:unless="${isActive}">Status: Inactive</p>

    <ul>
        <li th:each="item : ${items}" th:text="${item}">Item</li>
    </ul>

    <a th:href="@{/}">Go to Home</a>
</body>
</html>
```

### 4. Run the Application

1. Start your Spring Boot application.
2. Open a browser and go to:
`http://localhost:8080/syntax`

You should see:
```text
Hello, Learner!
Status: Active
Item 1
Item 2
Item 3
```

### 5. Optional Challenge

1. Add a new boolean variable in the controller called `isAdmin`.
2. Conditionally display a message:
```html 
<p th:if="${isAdmin}">Welcome, Admin!</p>
```

3. Try toggling its value in the controller to test both cases.

---

## Summary

- `${}` is used to access variables passed from the controller.
- `th:text` dynamically replaces tag content.
- `th:if` / `th:unless` control conditional rendering.
- `th:each` iterates through lists or collections.
- `@{}` builds dynamic links within the app.
