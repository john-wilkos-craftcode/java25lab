package be.craftcode.java25.runtime;

import java.nio.file.Path;
import java.util.List;

/**
 * +----------------------------------------------------------+
 * |   JEP 483 & 514: AOT Class Loading & CLI Ergonomics      |
 * +----------------------------------------------------------+
 * Creating CDS/AOT artifacts now takes fewer steps, and the runtime can reuse
 * the generated archives more directly.
 */
public class CliErgonomicsLab {

    public List<String> describeUpgrades() {
        return List.of(
                "AOT class loading can pre-link platform classes during training",
                "New ergonomic flags remove three shell commands from the CDS workflow",
                "Command-line defaults detect containers and tune class data sharing"
        );
    }

    /**
     * TODO 1: Build a command that archives classes on exit and reuses that same
     * archive for the next launch. The command should contain:
     *  - java -XX:ArchiveClassesAtExit=<archive>
     *  - -XX:SharedArchiveFile=<archive>
     *  - the jar path at the end
     */
    public String buildArchiveCommand(Path jar, Path archive) {
        throw new UnsupportedOperationException("TODO: render a CDS command that reuses the generated archive.");
    }
}
