# Assignment 3 — Bridge Pattern

## Description

This project demonstrates the Bridge structural pattern by separating the shape abstraction hierarchy from the renderer implementation hierarchy. `Shape` contains a `Renderer` reference through composition, so either hierarchy can vary independently.

Abstraction hierarchy:

```text
Shape
├── Circle
└── Square
```

Implementation hierarchy:

```text
Renderer
├── VectorRenderer
└── RasterRenderer
```

## Bridge Pattern Roles

| Bridge Role | Project Class |
|---|---|
| Abstraction | `Shape` |
| Refined Abstraction | `Circle`, `Square` |
| Implementor | `Renderer` |
| Concrete Implementor | `VectorRenderer`, `RasterRenderer` |
| Client | `Main` |

## Project Structure

```text
src/main/java/bridge/
├── Renderer.java
├── VectorRenderer.java
├── RasterRenderer.java
├── Shape.java
├── Circle.java
├── Square.java
└── Main.java
BridgeDiagram.puml
```

## How to Run

From the project root, using JDK 17:

```bash
mkdir -p out
javac --release 17 -d out src/main/java/bridge/*.java
java -cp out main.java.bridge.Main
```

## Example Output

```text
Drawing circle as vectors with radius: 5.0
Drawing circle as pixels with radius: 5.0
Drawing square as vectors with side: 4.0
Drawing square as pixels with side: 4.0
```

`Main` also switches the same circle from vector to raster rendering at runtime.

## Clean Code

- **Meaningful Names:** classes, fields, and methods describe their purpose.
- **Single Responsibility:** shapes store shape data; renderers perform rendering.
- **Separation of Concerns:** shape classes contain no vector or raster logic.
- **DRY:** `Shape` holds the shared renderer reference and switching method.
- **Open/Closed Principle:** new shapes or renderers can be added through the existing abstractions.
