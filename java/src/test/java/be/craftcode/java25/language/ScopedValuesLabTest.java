package be.craftcode.java25.language;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScopedValuesLabTest {

    private final ScopedValuesLab lab = new ScopedValuesLab();

    @Test
    void demoEchoesRequestId() throws Exception {
        String output = lab.describeRequest("req-42");
        assertTrue(output.contains("req-42"));
    }

    @Test
    void todoCapturesChildScope() throws Exception {
        String output = lab.captureChildSpan("req-99", "serialize-response");
        String expected = "req-99 -> child:serialize-response (on %s)".formatted(Thread.currentThread().getName());
        assertEquals(expected, output);
    }
}
