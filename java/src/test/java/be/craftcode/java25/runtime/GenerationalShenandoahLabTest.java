package be.craftcode.java25.runtime;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerationalShenandoahLabTest {

    private final GenerationalShenandoahLab lab = new GenerationalShenandoahLab();

    @Test
    void demoFlagsIncludeGenerational() {
        List<String> flags = lab.defaultFlags();
        assertTrue(flags.stream().anyMatch(f -> f.contains("Generational")));
    }

    @Test
    void todoLatencyTuningAddsPauseFlag() {
        List<String> aggressive = lab.tuneForLatency(4);
        assertTrue(aggressive.contains("-XX:MaxPauseMillis=4"));
        assertTrue(aggressive.contains("-XX:ShenandoahGCHeuristics=aggressive"));

        List<String> compact = lab.tuneForLatency(15);
        assertTrue(compact.contains("-XX:MaxPauseMillis=15"));
        assertTrue(compact.contains("-XX:ShenandoahGCHeuristics=compact"));
    }
}
