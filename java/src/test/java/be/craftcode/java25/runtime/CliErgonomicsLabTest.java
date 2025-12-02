package be.craftcode.java25.runtime;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CliErgonomicsLabTest {

    private final CliErgonomicsLab lab = new CliErgonomicsLab();

    @Test
    void demoDescribesUpgrades() {
        assertEquals(3, lab.describeUpgrades().size());
    }

    @Test
    void todoBuildArchiveCommand() {
        String command = lab.buildArchiveCommand(Path.of("service.jar"), Path.of("build/service.cds"));
        assertEquals("java -XX:ArchiveClassesAtExit=build/service.cds -XX:SharedArchiveFile=build/service.cds -jar service.jar", command);
    }
}
