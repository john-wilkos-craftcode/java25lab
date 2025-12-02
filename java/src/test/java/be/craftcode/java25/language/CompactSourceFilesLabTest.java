package be.craftcode.java25.language;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompactSourceFilesLabTest {

    private final CompactSourceFilesLab lab = new CompactSourceFilesLab();

    @Test
    void demoContainsCoderName() {
        String snippet = lab.runCompactHello("Ada");
        assertTrue(snippet.contains("Ada"));
        assertTrue(snippet.contains("void main"));
    }

    @Test
    void todoSnippetWrapsMessage() {
        String snippet = lab.buildCompactSnippet("Launch the probes");
        assertEquals("""
                // This file has no class declaration on purpose.
                void main() {
                    println("Launch the probes");
                }
                """.strip(), snippet);
    }
}
