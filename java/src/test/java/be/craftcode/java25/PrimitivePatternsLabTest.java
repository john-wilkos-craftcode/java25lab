package be.craftcode.java25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimitivePatternsLabTest {

    private final PrimitivePatternsLab lab = new PrimitivePatternsLab();

    @Test
    void describePayloadUnderstandsPrimitivePatterns() {
        assertEquals("boolean:true", lab.describePayload(true));
        assertEquals("zero-ish int", lab.describePayload(0));
        assertEquals("positive int:7", lab.describePayload(7));
        assertEquals("negative int:-3", lab.describePayload(-3));
        assertEquals("huge long:10000000000", lab.describePayload(10_000_000_000L));
        assertEquals("long:5", lab.describePayload(5L));
        assertEquals("double:3.5", lab.describePayload(3.5d));
        assertEquals("double:NaN", lab.describePayload(Double.NaN));
        assertEquals("null payload", lab.describePayload(null));
    }

    @Test
    void resolveUserIdSwitchesOnBoolean() {
        assertEquals(42, lab.resolveUserId(true, 42));
        assertEquals(-1, lab.resolveUserId(false, 42));
    }

    @Test
    void todoDescribeCommandUsesLongSwitch() {
        assertEquals("dispatch:new-order", lab.describeCommand(1L));
        assertEquals("dispatch:status-check", lab.describeCommand(2L));
        assertEquals("dispatch:priority-escalation", lab.describeCommand(10_000_000_000L));
        assertEquals("dispatch:bulk-export", lab.describeCommand(20_000_000_000L));
        assertEquals("dispatch:fallback:123", lab.describeCommand(123L));
    }
}
