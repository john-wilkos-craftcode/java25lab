# Java 25 Preview Lab

> A hands-on tour of the Java 25 language previews with a sprinkling of older warm-up exercises.

## Status at a Glance

- Focus on the Java 25 preview labs (primitive patterns, flexible constructors, compact source files).
- Java 22 / 24 refreshers are here for context and can be used as stretch material.
- Legacy Java 21 exercises (and their tests) still live under `src/.../java21`; we'll skip them unless there is spare time.
- JUnit tests exist for everything, so expect some red runs until you finish each TODO.
- You can choose to run this inside the GitHub Codespaces devcontainer, or clone it and run the Maven project locally.

## Repository Layout

```bash
.
├── pom.xml                         # Maven build targeting JDK 25 with --enable-preview
├── src/main/java/be/craftcode/java25
│   ├── Java22UnnamedVariables.java
│   ├── Java24Gatherers.java
│   ├── Java25CompactSourceFilesLab.java
│   ├── Java25FlexibleConstructorsLab.java
│   ├── Java25PreviewPrimitivePatternsLab.java
│   └── java21/                      # optional (collections, switches, jwebserver)
├── src/test/java/be/craftcode/java25
│   ├── ...Test.java                # matching tests for every lab (Java 21 tests included)
│   └── java21/...                  # legacy exercises, not part of the core agenda
└── .devcontainer/                  # Codespaces setup (installs JDK 25 + Maven)
```

## Working on the Labs

1. Open any `*Lab` class (start with the Java 25 ones) and read the narrative comment that references the JEP.
2. Replace each `UnsupportedOperationException` or placeholder code with your implementation of the feature.
3. Run `mvn test` at the repo root to verify your work. Tests already using the new preview features pass once the TODOs are complete.
4. Commit or share your solutions so the rest of the group can compare approaches.

### Recommended Order

| File | JEP # | Notes |
| --- | --- | --- |
| `Java25FlexibleConstructorsLab.java` | JEP 513 | Demonstrates validation before `super()` in constructors. |
| `Java25CompactSourceFilesLab.java` | JEP 512 | Compact files + top-level `void main`. |
| `Java24Gatherers.java` | JEP 485 | Optional refresher if you want more stream exercises. |
| `Java22UnnamedVariables.java` | JEP 456 | Warm-up on unnamed variables and patterns. |
| `Java25PreviewPrimitivePatternsLab.java` | JEP 507 | (Preview) Switch on primitives, pattern matching guards. |
| `java21/*` | Historical | Do these only if we run out of lab time. |

## Running the Project

### GitHub Codespaces (default setup)

1. Open the repository in Codespaces; the `.devcontainer` installs JDK 25 and Maven with preview flags configured.
2. Use the integrated terminal to run `mvn test` or `mvn -Dtest=... test` for a specific lab.
3. VS Code Tasks and Java extensions inside the container know about preview features, so you can run individual classes as needed.

### Local Machine

1. Install an OpenJDK 25 build (termurin, maybe?) and ensure `java --version` points to it.
2. Install Maven 3.9+ (or use the one bundled with your IDE).
3. Clone the repo and run `mvn test`. The `pom.xml` already adds `--enable-preview` for both compilation and tests.
4. When running code directly from your IDE, remember to enable preview features there as well.

## Legacy / Optional Content

- `src/main/java/be/craftcode/java25/java21/...` keeps earlier Java 21 labs (collections, switch pattern matching, embedded jwebserver).
- Matching tests live under `src/test/java/be/craftcode/java25/java21/...` and may fail until you decide to finish them.
- These files stay in the repo for historical context. Ignore them during the core workshop unless you want some bonus material.

## Links to Language JEPs

- [JEP 456: Unnamed Variables & Patterns](https://openjdk.org/jeps/456)
- [JEP 467: Markdown Documentation Comments](https://openjdk.org/jeps/467)
- [JEP 485: Stream Gatherers](https://openjdk.org/jeps/485)
- [JEP 506: Scoped Values](https://openjdk.org/jeps/506)
- [JEP 507: Primitive Types in Patterns, instanceof, and switch (Third Preview)](https://openjdk.org/jeps/507)
- [JEP 511: Module Import Declarations](https://openjdk.org/jeps/511)
- [JEP 512: Compact Source Files and Instance Main Methods](https://openjdk.org/jeps/512)
- [JEP 513: Flexible Constructor Bodies](https://openjdk.org/jeps/513)
