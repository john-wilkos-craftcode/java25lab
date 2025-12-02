package be.craftcode.java25.runtime;

import java.time.Duration;
import java.util.List;

/**
 * +---------------------------------------------+
 * |   JEP 518/520/509: JFR Enhancements         |
 * +---------------------------------------------+
 * Cooperative sampling, method-timing events, and CPU-time profiling allow JFR
 * to stay enabled in production environments without heavy overhead.
 */
public class JfrEnhancementsLab {

    public List<String> highlightNewEvents() {
        var bullets = List.of(
                "Cooperative sampling defers stack walks until safe points",
                "Method timing events show per-method latencies",
                "CPU-time profiling attributes hot threads on Linux"
        );
        bullets.forEach(System.out::println);
        return bullets;
    }

    /**
     * TODO 1: Given a recording name, duration, and a list of events, create a
     * single command string that could be used with `jcmd JFR.start`. Format:
     *   jcmd JFR.start name=<name> duration=<Xs> settings=profile delay=0s events=<comma list>
     */
    public String planRecording(String name, Duration duration, List<String> events) {
        throw new UnsupportedOperationException("TODO: build a command string for jcmd JFR.start");
    }
}
