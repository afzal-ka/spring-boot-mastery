# 02. Thymeleaf Basic Syntax

## Introduction
This topic covers the **basic syntax of Thymeleaf templates** and how to use them in a Spring Boot application.  
You will learn how to display data, use expressions, and control content rendering dynamically.

---

## 1. Expressions

### 1.1 Variable Expressions (`${}`)

Used to access variables passed from the controller to the view.

- Syntax: `${variable}`
- Example:
```html
<p th:text="${name}">Name goes here</p>
```

- Replaces the text content with the value of the `name` variable from the model.

### 1.2 Selection Expressions (`*{}`)

Used inside forms with `th:object`to bind input fields to model properties.

- Syntax: `*{property}`


- Example:
```html
<form th:object="${user}">
    <input type="text" th:field="*{username}" />
</form>
```
- Explanation:
- `th:object="${user}"` binds the form to a `user` object from the model.
- `th:field="*{username}"` → Connects the input field to the `username` property.
- On form submission, the `username` value is automatically mapped back to the `user` object in the controller.

### 1.3 Link Expressions (`@{}`)

Used to generate dynamic URLs.

- Syntax: `@{url}`
- Example:

```html
<a th:href="@{/home}">Home</a>
```
### 1.4 Fragment Expressions (`~{}`)

Used to include reusable template fragments.

- Syntax: `~{fragment}`
- Example:

```html
<div th:replace="fragments/header :: header"></div>
```

---

## 2. Attributes

| Attribute   | Description                                        |
| ----------- | -------------------------------------------------- |
| `th:text`   | Replaces the content of a tag with a value         |
| `th:if`     | Renders the element only if the condition is true  |
| `th:unless` | Renders the element only if the condition is false |
| `th:each`   | Loops over a collection                            |
| `th:href`   | Sets dynamic URLs                                  |
| `th:src`    | Sets dynamic resources (images, scripts)           |

---

## 3. Loops and Conditionals
Loop 
```html
<ul>
    <li th:each="item : ${items}" th:text="${item}">Item</li>
</ul>
```

Conditional Example
```html
<p th:if="${isActive}">Active</p>
<p th:unless="${isActive}">Inactive</p>
```
---

## 4. Summary

- Thymeleaf uses HTML5-compliant attributes to render dynamic content.
- Four main expression types:
  - `${}` → Variable
  - `*{}` → Selection
  - `@{}` → Link
  - `~{}` → Fragment
- Use attributes like `th:text`, `th:if`, `th:unless`, `th:each`, `th:href`, and `th:src` for dynamic rendering.
- Use `th:object` with `th:field` for form data binding.
- These basics form the foundation for building interactive Thymeleaf pages with Spring Boot.



