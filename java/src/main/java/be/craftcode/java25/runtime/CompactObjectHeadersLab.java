package be.craftcode.java25.runtime;

/**
 * +--------------------------------------+
 * |   JEP 519: Compact Object Headers    |
 * +--------------------------------------+
 * HotSpot shrank object headers from 12-16 bytes down to ~8 bytes on 64-bit
 * platforms, which reduces memory pressure for allocation-heavy workloads.
 */
public class CompactObjectHeadersLab {

    /**
     * Demo: prints a quick before/after summary assuming a 12-byte legacy header.
     */
    public String describeMemorySavings(long objectCount) {
        long legacy = objectCount * 12L;
        long compact = objectCount * 8L;
        String summary = "%,d objects -> legacy %d bytes vs compact %d bytes".formatted(objectCount, legacy, compact);
        System.out.println(summary);
        return summary;
    }

    /**
     * TODO 1: Compute the number of bytes saved when headers shrink from
     * `legacyBytes` to `compactBytes`.
     */
    public long estimateSavedBytes(long objectCount, int legacyBytes, int compactBytes) {
        throw new UnsupportedOperationException("TODO: multiply the per-object delta by the object count.");
    }
}
