# Java 25 Hands-on Lab

This lab goes over the Java Enhancement Proposals (JEP) that made it into the latest Long Term Support (LTS) version of Java: version 25

## Layout

```bash
java/
├── pom.xml                # build file targeting JDK 25 + preview flags
├── src/main/java          # feature demos + TODO stubs
└── src/test/java          # companion tests (fail until you finish the TODOs)
```

Code is grouped by theme:

- `language/` – JEP 512/513/511/506/507
- `runtime/` – JEP 519/515/518/520/521 + CLI ergonomics & misc HotSpot wins
- `security/` – JEP 510 (KDF API) and JEP 470 (PEM decoder/encoder)
- `architecture/` – JEP 503 (removal of the 32-bit x86 port)

## How to use this lab

1. Open any `*Lab` class and run the implemented `run*/describe*/demo*` method to
   see the feature in action (or a textual representation when it is flag-driven).
2. Replace each `UnsupportedOperationException` with a working solution that
   uses the new feature or mirrors its workflow.
3. Run `mvn test` from the `java` directory. Every test intentionally fails
   until its paired TODO is complete. When they pass, you know your code matches
   the reference behavior. (Demo-focused tests already pass to prove the setup.)

## Links to Language JEPs

- [JEP 456: Unnamed Variables & Patterns](https://openjdk.org/jeps/456)
- [JEP 467: Markdown Documentation Comments](https://openjdk.org/jeps/467)
- [JEP 485: Stream Gatherers](https://openjdk.org/jeps/485)
- [JEP 506: Scoped Values](https://openjdk.org/jeps/506)
- [JEP 507: Primitive Types in Patterns, instanceof, and switch (Third Preview)](https://openjdk.org/jeps/507)
- [JEP 511: Module Import Declarations](https://openjdk.org/jeps/511)
- [JEP 512: Compact Source Files and Instance Main Methods](https://openjdk.org/jeps/512)
- [JEP 513: Flexible Constructor Bodies](https://openjdk.org/jeps/513)
