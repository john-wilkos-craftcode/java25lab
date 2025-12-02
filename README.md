# java25lab

Lab for teaching the jump from Java 21 to Java 25.

## Structure

- `java/` – Maven project containing feature demos, TODO exercises, and matching
  JUnit tests. Each `*Lab` highlights a single JEP or marquee improvement
  (language, GC/runtime, security, or architecture).

## Running the lab

```bash
cd java
mvn test
```

The demo tests pass immediately to prove the setup works. Exercise tests fail
until you implement the corresponding TODOs, giving students instant feedback.
