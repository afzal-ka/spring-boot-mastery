# 5. Fragments and Layouts in Thymeleaf

## 1. What Are Fragments?

Fragments in Thymeleaf are reusable parts of an HTML template — similar to “components” in modern frontend frameworks.
They allow you to extract repeating sections (like headers, footers, menus) into separate files, so you can include or replace them across multiple pages.

---

## 2. Why Use Fragments?
| Problem                                                            | Solution with Fragments                         |
| ------------------------------------------------------------------ | ----------------------------------------------- |
| Duplicating common HTML parts (header, footer, etc.) in every file | Define once and reuse using `th:fragment`       |
| Hard to update shared UI (e.g., navbar)                            | Change in one fragment file reflects everywhere |
| Code becomes long and unorganized                                  | Cleaner separation of layout and page content   |

---

## 3. Declaring a Fragment

Use the `th:fragment` attribute inside a tag to define a fragment.

```html
<!-- header.html -->
<header th:fragment="siteHeader">
    <h1>My Blog</h1>
    <nav>
        <a href="/">Home</a> |
        <a href="/posts">Posts</a> |
        <a href="/about">About</a>
    </nav>
</header>
```
Here, `th:fragment="siteHeader"` defines a reusable section called `siteHeader`.

---

## 4. Including a Fragment

You can include a fragment in another template using `th:insert` or `th:replace`.

**Using** `th:insert`

Adds the fragment inside the current tag.

```html
<div th:insert="~{fragments/header :: siteHeader}"></div>
```
**Using** `th:replace`

Replaces the current tag entirely with the fragment.

```html
<div th:replace="~{fragments/header :: siteHeader}"></div>
```

> Tip:
> - Use `th:replace` when the tag structure matches exactly (e.g., header or footer).
> - Use `th:insert` if you want to wrap the fragment in an extra container.

---

## 5. Passing Parameters to Fragments

You can pass data to fragments, similar to function parameters.
```html
<!-- fragment -->
<div th:fragment="greeting(name)">
    <p>Hello, <span th:text="${name}">User</span>!</p>
</div>

<!-- usage -->
<div th:replace="~{fragments/common :: greeting('John')}"></div>
```
---

## 6. Layout Example (Header + Content + Footer)

**header.html**
```html
<header th:fragment="header">
    <h1>Welcome to My Site</h1>
</header>
```

**footer.html**

```html
<footer th:fragment="footer">
    <p>&copy; 2025 MySite</p>
</footer>
```

**main.html**

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Home Page</title>
</head>
<body>
    <div th:replace="~{fragments/header :: header}"></div>

    <main>
        <h2>Content Goes Here</h2>
    </main>

    <div th:replace="~{fragments/footer :: footer}"></div>
</body>
</html>
```
---

## 7. Directory Structure Example

A clean project structure with fragments might look like this:

```text
src/
 └── main/
     └── resources/
         └── templates/
             ├── fragments/
             │   ├── header.html
             │   ├── footer.html
             │   └── sidebar.html
             ├── home.html
             └── about.html

```
---

## 8. Using the Layout Dialect (Optional)

Thymeleaf’s Layout Dialect is an additional library that makes layout management easier.

It allows you to define master templates with placeholders for content, similar to templating in JSP or Blade.

Example:

**layout.html**
```html
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
    <title layout:title-pattern="$CONTENT_TITLE - MySite">MySite</title>
</head>
<body>
    <header layout:fragment="header">Header Content</header>

    <main layout:fragment="content">
        <!-- Dynamic content -->
    </main>

    <footer layout:fragment="footer">Footer Content</footer>
</body>
</html>
```
**child.html**

```html
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate="~{layout}">
<body>
    <div layout:fragment="content">
        <h2>Welcome to the Homepage!</h2>
    </div>
</body>
</html>
```
> Layout Dialect is optional but useful for large applications with multiple layouts.

---

## 9. Key Attributes Summary

| Attribute         | Purpose                                                 |
| ----------------- | ------------------------------------------------------- |
| `th:fragment`     | Defines a reusable fragment                             |
| `th:insert`       | Inserts fragment content inside a tag                   |
| `th:replace`      | Replaces a tag with a fragment                          |
| `layout:decorate` | Extends a base layout (Layout Dialect)                  |
| `layout:fragment` | Defines replaceable sections in layout (Layout Dialect) |

---

## 10. Best Practices

- Keep fragments inside a dedicated `fragments/` folder.
- Use `th:replace` for clean structural replacement.
- Avoid deeply nested fragment calls.
- Keep fragment names descriptive (e.g., `navBar`, `footerLinks`, `sidebarMenu`).
- For large apps, prefer the Layout Dialect approach.