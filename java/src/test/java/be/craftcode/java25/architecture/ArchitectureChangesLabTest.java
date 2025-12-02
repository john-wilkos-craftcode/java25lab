package be.craftcode.java25.architecture;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArchitectureChangesLabTest {

    private final ArchitectureChangesLab lab = new ArchitectureChangesLab();

    @Test
    void demoWarnsForLegacy32Bit() {
        assertEquals("Unsupported: upgrade to 64-bit", lab.warnIfUnsupported("x86"));
        assertEquals("Looks 64-bit enough for Java 25", lab.warnIfUnsupported("x86_64"));
    }

    @Test
    void todoSupportedArchWhitelist() {
        assertTrue(lab.isSupportedArch("x86_64"));
        assertTrue(lab.isSupportedArch("aarch64"));
        assertTrue(lab.isSupportedArch("riscv64"));
        assertFalse(lab.isSupportedArch("i586"));
    }
}
