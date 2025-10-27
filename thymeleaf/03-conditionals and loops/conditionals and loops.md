# 03. Thymeleaf Conditionals and Loops

## Introduction
In this topic, you’ll learn how to control content rendering dynamically in Thymeleaf using **conditionals** (`th:if`, `th:unless`, `th:switch`) and **loops** (`th:each`).  
These tools make your templates interactive and responsive to your backend data.

---

## 1. Conditional Rendering

### 1.1 `th:if` and `th:unless`
- `th:if` displays an element only if the condition is **true**.  
- `th:unless` displays an element only if the condition is **false**.

**Example:**
```html
<p th:if="${isLoggedIn}">Welcome back!</p>
<p th:unless="${isLoggedIn}">Please log in to continue.</p>
```

**How it works:**
- If `isLoggedIn = true`, only the first`<p>` will render.
- If `isLoggedIn = false`, only the second `<p>` will render.

### 1.2 Using Logical and Comparison Operators

- Thymeleaf supports standard operators inside conditions:

| Operator             | Description           | Example                      |
| -------------------- | --------------------- | ----------------------------- |
| `==`, `!=`           | Equality / Inequality | `th:if="${age == 18}"`        |
| `>`, `<`, `>=`, `<=` | Comparison            | `th:if="${score > 80}"`       |
| `&&`, `\|\|`, `!`    | Logical AND, OR, NOT  | `th:if="${isAdmin && isActive}"` |

```html
<p th:if="${user.age >= 18}">Adult</p>
<p th:if="${user.age < 18}">Minor</p>
```
### 1.3 Switch Statements with `th:switch` and `th:case`

**Example:**
```html
<div th:switch="${role}">
    <p th:case="'ADMIN'">Welcome, Admin!</p>
    <p th:case="'USER'">Welcome, User!</p>
    <p th:case="*">Guest Access</p>
</div>
```
- `th:switch` evaluates an expression.
- Each `th:case` represents a possible value.
- The `*` case acts as a default (similar to `default` in Java’s switch).

---
## 2. Iteration (Loops)

### 2.1 Basic Loop

Use `th:each` to iterate over a collection.

```html
<ul>
    <li th:each="item : ${items}" th:text="${item}">Item</li>
</ul>
```

**Explanation:**

- `items` is a list or array passed from the controller.
- For each element, Thymeleaf creates a new `<li>` element with its text.

### 2.2 Loop Variables

Thymeleaf provides loop status variables to access metadata about the iteration.

**Syntax:**

```html
th:each="item, iterStat : ${items}"
```

**Available Properties:**

| Property         | Description                             |
| ---------------- | --------------------------------------- |
| `iterStat.index` | Zero-based index                        |
| `iterStat.count` | One-based index                         |
| `iterStat.size`  | Total size of the list                  |
| `iterStat.even`  | `true` if the current iteration is even |
| `iterStat.odd`   | `true` if the current iteration is odd  |
| `iterStat.first` | `true` for the first iteration          |
| `iterStat.last`  | `true` for the last iteration           |

**Example:**

```html
<ul>
    <li th:each="item, iter : ${items}">
        <span th:text="${iter.count} + '. ' + ${item}"></span>
        <span th:if="${iter.first}">(First)</span>
    </li>
</ul>
```

### 2.3 Nested Loops

You can also nest loops to iterate through nested collections.

**Example:**
```html
<ul>
    <li th:each="category : ${categories}">
        <b th:text="${category.name}"></b>
        <ul>
            <li th:each="product : ${category.products}" th:text="${product}"></li>
        </ul>
    </li>
</ul>
```

---
## 3. Combining Conditionals and Loops

You can combine conditionals with loops for more dynamic logic.

**Example:**

```html
<ul>
    <li th:each="user : ${users}" th:if="${user.active}" th:text="${user.name}"></li>
</ul>
```

- Loops through `users` list.
- Displays only active users.

---

## 4. Summary

- Use `th:if` / `th:unless` for simple conditions.
- Use `th:switch` / `th:case` for multiple possible outcomes.
- Use `th:each` to loop through collections.
- Loop status variables (`index`, `count`, `first`, `last`, etc.) help in formatting and debugging.
- You can combine loops and conditionals for fine-grained rendering control.
