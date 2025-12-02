# Java 25 Hands-on Lab

This lab goes over the Java Enhancement Proposals (JEP) that made it into the latest Long Term Support (LTS) version of Java: version 25

## Layout

```
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
