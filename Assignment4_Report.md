# Assignment 4 Report: Facade Pattern

## Purpose

This project applies the Facade Pattern to a home theater. Starting a movie or tuning in to radio normally requires a client to know which devices to operate and in what order. `HomeTheaterFacade` provides a small, clear interface that coordinates those subsystem operations.

## Design

`HomeTheaterFacade` holds references to the amplifier, streaming player, projector, theater lights, screen, popcorn popper, and tuner. Its `watchMovie` operation prepares the room, configures the projector and audio system, and starts the selected title. `endMovie` shuts those components down in an orderly sequence. The radio methods coordinate the tuner and amplifier.

Each subsystem class is responsible for its own device actions. The `Main` client constructs the devices, supplies their output handler, and calls the facade methods. It does not configure each device itself.

## Pattern Participants

| Pattern participant | Implementation |
|---|---|
| Facade | `HomeTheaterFacade` |
| Subsystem | `Amplifier`, `StreamingPlayer`, `Projector`, `TheaterLights`, `Screen`, `PopcornPopper`, `Tuner` |
| Client | `Main` |

## Clean Code Principles

The implementation uses descriptive class and method names so the device operations are easy to follow. Each device handles its own actions, while `HomeTheaterFacade` owns only the orchestration workflow. Private fields encapsulate the facade's subsystem references, and constructor injection makes those dependencies explicit. Shared output handling lives in the `TheaterDevice` base class. Input validation rejects blank movie titles and nonpositive or nonfinite radio frequencies before any subsystem action occurs. Main, devices, facade workflows, and tests are separated into focused classes.

## Verification

The project compiles its production and test sources using the Java 17 language and API target. Automated tests assert the ordered commands for movie startup and shutdown, radio startup and shutdown, and invalid input behavior. Run them from the project root with `./test.sh`.

## Conclusion

The client now starts and ends common home theater activities through a single facade. Device details remain in their subsystem classes, and the UML diagram documents the facade's relationships to those classes.
