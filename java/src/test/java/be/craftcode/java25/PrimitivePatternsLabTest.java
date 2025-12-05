package be.craftcode.java25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimitivePatternsLabTest {

    private final PrimitivePatternsLab lab = new PrimitivePatternsLab();

    @Test
    void demoSwitchHandlesZero() {
        assertEquals("zero-ish int", lab.describePayload(0));
        assertEquals("positive int:7", lab.describePayload(7));
        assertEquals("null payload", lab.describePayload(null));
    }

    @Test
    void todoSummarizeDifferentNumbers() {
        assertEquals("tiny:7", lab.summarizeNumber((short) 7));
        assertEquals("tiny:8", lab.summarizeNumber((byte) 8));
        assertEquals("float:3.5", lab.summarizeNumber(3.5f));
        assertEquals("generic:42", lab.summarizeNumber(42L));
    }
}
