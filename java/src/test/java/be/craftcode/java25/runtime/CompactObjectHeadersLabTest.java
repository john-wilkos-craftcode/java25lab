package be.craftcode.java25.runtime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompactObjectHeadersLabTest {

    private final CompactObjectHeadersLab lab = new CompactObjectHeadersLab();

    @Test
    void demoMentionsCounts() {
        String summary = lab.describeMemorySavings(1_000);
        assertTrue(summary.contains("1,000 objects"));
        assertTrue(summary.contains("legacy"));
    }

    @Test
    void todoEstimatesSavedBytes() {
        assertEquals(8_000_000L, lab.estimateSavedBytes(1_000_000L, 16, 8));
    }
}
