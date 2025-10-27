# 04. Forms and Data Binding in Thymeleaf

**Overview**

Thymeleaf provides a powerful and convenient way to create and bind HTML forms to backend model objects in a Spring Boot application.
It allows form fields to be automatically populated with data and maps user input back to objects on submission.

## 1. Setting Up a Form

In Thymeleaf, forms are built using two main attributes:
- `th:object` — binds the entire form to a model object.
- `th:field` — binds individual input fields to object properties.

**Example: Basic Form Setup**
```html
<form th:action="@{/register}" th:object="${user}" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" th:field="*{name}" />

    <label for="email">Email:</label>
    <input type="email" id="email" th:field="*{email}" />

    <button type="submit">Submit</button>
</form>
```

**Explanation**
| Attribute   | Description                                                     |
| ----------- | --------------------------------------------------------------- |
| `th:action` | Specifies the URL endpoint for form submission.                 |
| `th:object` | Declares the form’s bound object from the model.                |
| `th:field`  | Connects an input element to a specific property of the object. |

---

## Creating the Model Class

Define a model class that holds the form data.

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
---

## 3. Controller Setup

The controller manages both form display and data submission.

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

---

## 4. Creating the Result Template

File: `result.html`

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Registration Result</title>
</head>
<body>
<h2 th:text="${message}"></h2>
<p th:text="'Name: ' + ${user.name}"></p>
<p th:text="'Email: ' + ${user.email}"></p>
</body>
</html>
```

---

## 5. Common Attributes Used in Form Binding

| Attribute   | Description                                      | Example                           |
| ----------- | ------------------------------------------------ | --------------------------------- |
| `th:field`  | Binds an input field to a property in the model. | `th:field="*{email}"`             |
| `th:value`  | Displays a default or pre-filled value.          | `th:value="${user.name}"`         |
| `th:object` | Declares the bound object for the form.          | `th:object="${user}"`             |
| `th:action` | Sets the form submission endpoint.               | `th:action="@{/submit}"`          |
| `th:errors` | Displays validation errors for a field.          | `<div th:errors="*{name}"></div>` |

---

## 6. Understanding `th:field`

`th:field` provides two-way data binding, unlike `th:text`, which only displays data.
It both displays existing values and binds the submitted data back to the model object.

```html
<input type="text" th:field="*{name}" />
```
- On rendering: Displays the current value of `user.name`.
- On submission: Sends the updated value back to populate `user.name` in the controller.

---

## Summary

| Concept           | Purpose                                               |
| ----------------- | ----------------------------------------------------- |
| `th:object`       | Binds the form to a backend object.                   |
| `th:field`        | Connects individual inputs to object properties.      |
| `@ModelAttribute` | Maps submitted form data to the backend model object. |
| `th:action`       | Defines the form submission URL.                      |
| `th:errors`       | Displays field-specific validation messages.          |
