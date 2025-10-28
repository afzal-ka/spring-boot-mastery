# Full Thymeleaf Demo

This project is a **complete demonstration of Thymeleaf** integrated with **Spring Boot**, designed to cover all major template engine features — from expressions and conditionals to loops, fragments, and form binding.

---

## Overview

This demo helps understand how Thymeleaf works in a real Spring Boot project setup.  
Each controller method maps to a specific concept and template under `/templates`.

You can explore how data is passed from Java controllers to the HTML views and how dynamic rendering is handled using various Thymeleaf attributes.

---

## Project Structure

```text
full_thymeleaf_demo/
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  └─ com/
│  │  │     └─ thymeleaf/
│  │  │        └─ thymeleaf_1/
│  │  │           ├─ controller/
│  │  │           │  ├─ HelloController.java
│  │  │           │  ├─ UserController.java
│  │  │           │  └─ FormController.java
│  │  │           └─ model/
│  │  │              ├─ User.java
│  │  │              └─ UserForm.java
│  │  └─ resources/
│  │     ├─ templates/
│  │     │  ├─ common/
│  │     │  │  ├─ header.html
│  │     │  │  └─ footer.html
│  │     │  ├─ hello-world.html
│  │     │  ├─ variable-expression.html
│  │     │  ├─ selection-expression.html
│  │     │  ├─ message-expression.html
│  │     │  ├─ link-expression.html
│  │     │  ├─ fragment-expression.html
│  │     │  ├─ users.html
│  │     │  ├─ if-unless.html
│  │     │  ├─ switch-case.html
│  │     │  └─ register-form.html
│  │     └─ application.properties
│  └─ test/ ...
└─ pom.xml
```
---

## Controllers and Purpose
### HelloController

**Endpoint:** `/hello-world`

Demonstrates passing a simple string value to a template using the Model.

### UserController
Contains several endpoints covering multiple Thymeleaf concepts:

| Endpoint                | Template                    | Concept                                              |
| ----------------------- | --------------------------- | ---------------------------------------------------- |
| `/variable-expression`  | `variable-expression.html`  | Basic variable expressions (`th:text`)               |
| `/selection-expression` | `selection-expression.html` | Using `*{}` expressions with selected objects        |
| `/message-expression`   | `message-expression.html`   | Internationalization (messages.properties)           |
| `/link-expression`      | `link-expression.html`      | Generating dynamic links with `@{}`                  |
| `/fragment-expression`  | `fragment-expression.html`  | Using and including fragments                        |
| `/users`                | `users.html`                | Iteration with `th:each`                             |
| `/if-unless`            | `if-unless.html`            | Conditional rendering with `th:if` and `th:unless`   |
| `/switch-case`          | `switch-case.html`          | Conditional branching with `th:switch` and `th:case` |

### FormController

- **Endpoint:** `/register`
- Demonstrates form handling, data binding, and dynamic dropdown lists using:
- `th:object`
- `th:field`
- `th:each`

---

## Models

`User.java`

Represents user data for demonstration of variables, iterations, and conditionals.

`UserForm.java`

Used for form binding and data submission in `register-form.html.`

---

## Common Fragments

The `common/` folder holds reusable fragments used across templates.

| File          | Purpose                                                         |
| ------------- | --------------------------------------------------------------- |
| `header.html` | Contains the reusable header section (logo, title, navigation). |
| `footer.html` | Contains the reusable footer section (copyright, links).        |

Include these fragments in other templates using:

```html
<div th:replace="common/header :: header"></div>

<!-- Page content here -->

<div th:replace="common/footer :: footer"></div>
```
---

## How to Run

1. Navigate to the project folder:
```text
cd full_thymeleaf_demo
```
2. Run the application:
```text
mvn spring-boot:run
```
3. Open your browser and visit:
- http://localhost:8080/hello-world
- http://localhost:8080/variable-expression
- http://localhost:8080/register
- and other endpoints listed above.

---

## Learning Goals

- Understand how Thymeleaf interacts with Spring Boot models and views.
- Practice passing dynamic data using the Model interface.
- **Learn how to apply:**
- `th:text`, `th:if`, `th:each`, `th:switch`, and `th:case`
- `th:object` and `th:field` for forms
- `th:replace` and `th:fragment` for layouts

---

## Summary

This project acts as a comprehensive Thymeleaf reference — showing the connection between:

- Controller ➝ Model ➝ Template
- Logic ➝ Data ➝ Dynamic Rendering