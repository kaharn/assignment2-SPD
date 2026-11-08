# Assignment 6: Visitor Pattern

This Java 17 project models a small file system using `File` and `Directory` elements. It demonstrates the Visitor pattern with two operations: calculating the size of all files in a tree and finding files by extension.

## Project structure

```text
src/main/java/filesystem/
├── Element.java
├── File.java
├── Directory.java
├── Visitor.java
├── SizeCalculatorVisitor.java
├── SearchVisitor.java
└── Main.java
README.md
Assignment6_Report.md
UML.puml
UML.png
run.sh
```

## Compile and run

Install JDK 17 or newer. From the repository root, run:

```sh
./run.sh
```

The script compiles the sources with the Java 17 language and API target into a temporary directory, runs the demo, and removes the temporary build output. The equivalent manual commands are:

```sh
mkdir -p out
javac --release 17 -d out $(find src/main/java -name '*.java')
java -cp out filesystem.Main
```

## Example output

```text
Total size of 'project': 10256 bytes
Files matching .txt:
- notes.txt (512 bytes)
```

`UML.puml` is the editable class diagram source; `UML.png` is its rendered image. The report explains the design and its Clean Code choices.
