# Exercise — Display a Dynamic Message Using Thymeleaf
---

## Objective

This project demonstrates how to:

- Set up Thymeleaf in a Spring Boot project.
- Pass dynamic data from a controller to an HTML template.
- Display dynamic content using `th:text`.
- Render content conditionally using `th:if`.

**Why this matters:**  
Thymeleaf allows your HTML pages to be dynamic while remaining valid HTML, making it easy to integrate Spring Boot data into your web pages.

---

### Project Structure
```text
thymeleaf-intro
├─ src
│  ├─ main
│  │  ├─ java
│  │  │  └─ com
│  │  │      └─ example
│  │  │          └─ thymeleafintro
│  │  │              └─ controller
│  │  │                  └─ GreetingController.java
│  │  └─ resources
│  │      └─ templates
│  │          └─ greeting.html
├─ pom.xml
└─ README.md
```
## Steps

---

## 1. Create a Spring Boot Application

If you haven’t already, initialize a Spring Boot project using [Spring Initializr](https://start.spring.io/):

**Dependencies:**
- Spring Web
- Thymeleaf

## 2. Create the Controller

Create a controller to handle HTTP requests and pass data to the Thymeleaf template:

```java
package com.example.thymeleafintro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/")  // Maps to http://localhost:8080/
    public String showGreeting(Model model){
        // Add dynamic data to the model
        model.addAttribute("name", "Explorer");
        model.addAttribute("message", "Welcome to Thymeleaf Basics");
        model.addAttribute("showSpecialMessage", true);
        
        return "greeting";  // Return the name of the Thymeleaf template (greeting.html)
    }
}
```
> 💡 Note:
> - `Model` object is used to pass data from the controller to the view.
> - `@GetMapping("/")` maps the root URL to this method.

## 3. Create the Thymeleaf Template
Create a greeting.html file under src/main/resources/templates:

```html
<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Greeting Page</title>
</head>
<body>
    <!-- Dynamic greeting -->
    <h1 th:text="'Hello ' + ${name} + '!'"></h1>
    
    <!-- Dynamic message -->
    <p th:text="${message}"></p>
    
    <!-- Conditional message -->
    <p th:if="${showSpecialMessage}" th:text="'You are a special user!'"></p>
</body>
</html>
```
> 💡 Tips:
> - `th:text` safely escapes HTML by default.
> - `th:if` allows content to be displayed conditionally.

## 4. Run the Application
Run your Spring Boot application.

Open a browser and navigate to: http://localhost:8080

You should see:

```text
Hello Explorer!
Welcome to Thymeleaf Basics
You are a special user!
```
Try changing showSpecialMessage to false in the controller to see how conditional rendering works.

---

## Learning Outcomes
- Pass dynamic data from Spring Boot controller to Thymeleaf template.
- Use ${} and th:text to display variables.
- Render content conditionally with th:if.
- Understand basic server-side template rendering workflow.


