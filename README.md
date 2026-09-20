# Assignment #2 — Factory Method & Abstract Factory

**Course:** ShP-2216 — Software Design Patterns  
**Institution:** Astana IT University — School of Computer Engineering  
**Assignment:** #2 — Factory Method & Abstract Factory  
**Option:** A — Logistics / Transport  
**Language:** Java  
**JDK:** 17

---

## Technology Stack

<p align="center">
  <img src="https://skillicons.dev/icons?i=java,idea,git,github" alt="Technology Stack">
</p>

| Technology | Purpose |
|---|---|
| Java 17 | Main programming language |
| IntelliJ IDEA | Development environment |
| Git | Version control |
| GitHub | Source code repository |
| PlantUML | UML class diagrams |

---

## 1. Project Overview

This project demonstrates two creational design patterns:

- **Factory Method**
- **Abstract Factory**

The project uses the **Logistics / Transport** domain for the Factory Method and a cross-platform **GUI toolkit** for the Abstract Factory.

The main goal is to demonstrate how object creation can be separated from client code using polymorphism and factory abstractions.

---

# 2. Part A — Factory Method

The Factory Method pattern is used to create different types of transport.

The system supports:

- `Truck`
- `Ship`

The client does not directly decide which concrete transport object should be created. Instead, concrete creator classes provide the appropriate implementation.

### Pattern Structure

| Pattern Role | Implementation |
|---|---|
| Product | `Transport` |
| Concrete Product | `Truck` |
| Concrete Product | `Ship` |
| Creator | `Logistics` |
| Concrete Creator | `RoadLogistics` |
| Concrete Creator | `SeaLogistics` |

### Factory Method

The `Logistics` class declares the factory method:

```java
public abstract Transport createTransport();
