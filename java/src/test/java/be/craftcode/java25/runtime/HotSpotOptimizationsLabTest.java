package be.craftcode.java25.runtime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotSpotOptimizationsLabTest {

    private final HotSpotOptimizationsLab lab = new HotSpotOptimizationsLab();

    @Test
    void demoListsOptimizations() {
        assertEquals(3, lab.highlightOptimizations().size());
    }

    @Test
    void todoEstimateStartupMillis() {
        assertEquals(800, lab.estimateStartupMillis(1000, 0.20));
        assertEquals(950, lab.estimateStartupMillis(1000, 0.05));
    }
}
