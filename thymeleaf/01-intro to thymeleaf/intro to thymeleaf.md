# 01. Introduction to Thymeleaf

## What Is Thymeleaf?
Thymeleaf is a **server-side Java template engine** for building dynamic web pages using Spring Boot.  
It allows you to use **HTML files as templates** that can be both viewed directly in the browser and processed dynamically by the Spring backend.

---

### Why Use Thymeleaf with Spring Boot?

| Advantage | Description |
|------------|-------------|
| Seamless Integration | Works naturally with Spring MVC and model attributes |
| Natural Templates | Templates are valid HTML and can open directly in browsers |
| Data Binding | Easily access and display data from the controller |
| Template Features | Supports loops, conditionals, fragments, and layouts |
| Built-in Support | Included automatically in Spring Boot starter dependencies |

### How It Fits in the Spring MVC Flow
1. Controller method returns a **view name** (e.g., `"index"`).  
2. Spring Boot finds the template file from `src/main/resources/templates/`.  
3. Thymeleaf replaces dynamic expressions with data from the `Model`.  
4. The final rendered HTML is sent to the client.

### Comparison: Thymeleaf vs JSP

| Feature | JSP | Thymeleaf |
|----------|-----|-----------|
| Template Readability | Requires servlet container | Opens directly in browser |
| Syntax | Java-like script tags | Pure HTML syntax |
| Spring Integration | Manual setup | Auto-configured in Spring Boot |
| Learning Curve | Moderate | Beginner-friendly |

### Quick Start Example
**Add Dependency in `pom.xml`:**

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
