package be.craftcode.java25.runtime;

import java.util.List;

/**
 * Highlights several HotSpot and JIT optimizations introduced between Java 21
 * and 25: faster hashing, improved tiered compilation, and virtual-thread-aware
 * safepoints.
 */
public class HotSpotOptimizationsLab {

    public List<String> highlightOptimizations() {
        return List.of(
                "String::hashCode caches results in shared maps",
                "Tiered compilation can ingest AOT profiles immediately",
                "Virtual-thread aware safepoints reduce monitor inflation"
        );
    }

    /**
     * TODO 1: Given a baseline startup time and an improvement percentage (e.g.
     * 0.15 for 15%), compute the improved startup time rounded down to millis.
     */
    public long estimateStartupMillis(long baselineMillis, double improvementFraction) {
        throw new UnsupportedOperationException("TODO: apply the fraction to the baseline and round down.");
    }
}
