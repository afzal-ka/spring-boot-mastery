# Exercise — Building Reusable Layouts with Thymeleaf Fragments

## Objective

Learn how to:

- Create reusable layout components (header, footer, sidebar) using Thymeleaf fragments.
- Include and reuse these fragments in multiple pages.
- Understand the difference between `th:insert` and `th:replace`.

---

## Steps

### 1. Create a New Spring Boot Project

If you don’t have one already:

- Use Spring Initializr
- Dependencies: `Spring Web`, `Thymeleaf`

### 2. Project Structure

Your project should look like this:
```text
thymeleaf-fragments
└── src
    └── main
        └── resources
            └── templates
                ├── fragments/
                │   ├── header.html
                │   ├── footer.html
                └── home.html
```

### 3. Create Fragments
**header.html**

```html
<header th:fragment="header">
    <h1>My Blog</h1>
    <nav>
        <a href="/">Home</a> |
        <a href="/about">About</a>
    </nav>
</header>
```
**footer.html**
```html
<footer th:fragment="footer">
    <p>&copy; 2025 My Blog — All Rights Reserved</p>
</footer>
```

### 4. Create Main Page

**home.html**

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Home Page</title>
</head>
<body>
    <div th:replace="~{fragments/header :: header}"></div>

    <main>
        <h2>Welcome to the Home Page</h2>
        <p>This is an example of using reusable Thymeleaf fragments.</p>
    </main>

    <div th:replace="~{fragments/footer :: footer}"></div>
</body>
</html>
```
### 5. Create Controller
**HomeController.java**
```java
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "home";
    }
}
```
### 6. Run the Application

Run your Spring Boot application and open:

```text
http://localhost:8080/
```
You should see the header, main content, and footer loaded from separate fragment files.

### 7. Try This Variation

To practice, replace `th:replace` with `th:insert` in the `home.html` file and observe the difference:

```html
<div th:insert="~{fragments/header :: header}"></div>
```
> Notice how the layout nesting changes — this helps you understand when to use each.

---

## Expected Outcome

- The header and footer appear consistently across all pages.
- Updating a fragment automatically updates all pages that include it.
- You understand how to structure reusable layouts in Thymeleaf.