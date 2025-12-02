package be.craftcode.java25.language;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModuleImportLabTest {

    private final ModuleImportLab lab = new ModuleImportLab();

    @Test
    void demoIncludesImportModule() {
        String snippet = lab.showDesktopSnippet();
        assertTrue(snippet.startsWith("import module"));
        assertTrue(snippet.contains("java.desktop"));
    }

    @Test
    void todoCreateImportBlockSortsModules() {
        String block = lab.createImportBlock(List.of("java.sql", "java.desktop", "jdk.jfr"));
        assertEquals("""
                import module java.desktop;
                import module java.sql;
                import module jdk.jfr;
                """.strip(), block);
    }
}
