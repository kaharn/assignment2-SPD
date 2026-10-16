# Assignment 4 — Facade Pattern

This Java 17 project demonstrates the Facade Pattern with a home theater. `HomeTheaterFacade` offers a small set of high-level movie and radio operations while coordinating the separate theater devices.

## Facade Pattern Roles

| Role | Project class |
|---|---|
| Facade | `HomeTheaterFacade` |
| Subsystem classes | `Amplifier`, `StreamingPlayer`, `Projector`, `TheaterLights`, `Screen`, `PopcornPopper`, `Tuner` |
| Client | `Main` |

The client can call `watchMovie(title)` and `endMovie()` without managing device startup and shutdown order. It can also call `listenToRadio(frequency)` and `endRadio()` to run the tuner and amplifier together.

## Project Structure

```text
src/
├── main/java/hometheater/
│   ├── HomeTheaterFacade.java
│   ├── Main.java
│   └── devices/
└── test/java/hometheater/
    └── HomeTheaterFacadeTest.java
UML.puml
UML.png
Assignment4_Report.md
```

## Build and Run

Requires JDK 17 or newer. Compile and run the demonstration:

```bash
mkdir -p out
javac --release 17 -d out $(find src/main/java -name '*.java')
java -cp out hometheater.Main
```

Run the automated tests:

```bash
./test.sh
```

The test runner compiles production and test sources with `--release 17` and runs the tests without third-party dependencies.

## Clean Code Principles

- **Meaningful names:** device and facade methods describe their theater actions.
- **Single responsibility:** each device represents and logs its own operations; the facade coordinates workflows.
- **Encapsulation:** subsystem references are private and callers use the facade's movie and radio operations.
- **Dependency injection:** the facade receives its devices through its constructor, and devices receive an output consumer.
- **DRY:** shared output handling is implemented in `TheaterDevice` instead of repeated in every device.
- **Input validation:** movie titles and radio frequencies are checked before the devices are operated.
- **Separation of concerns:** the demonstration, orchestration, subsystem actions, and automated tests are kept in separate classes.

## UML

`UML.puml` contains the editable PlantUML class diagram. `UML.png` is its rendered class diagram.
