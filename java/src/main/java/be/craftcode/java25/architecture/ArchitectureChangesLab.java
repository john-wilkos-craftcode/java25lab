package be.craftcode.java25.architecture;

import java.util.Locale;

/**
 * +------------------------------+
 * |   JEP 503: Bye-bye x86-32    |
 * +------------------------------+
 * HotSpot's 32-bit x86 port has been retired, so Java 25 runs only on 64-bit
 * architectures (x64, AArch64, RISC-V 64, ...).
 */
public class ArchitectureChangesLab {

    public String warnIfUnsupported(String architectureName) {
        var normalized = architectureName.toLowerCase(Locale.ROOT);
        String message = switch (normalized) {
            case "x86", "i386", "i486", "i586" -> "Unsupported: upgrade to 64-bit";
            default -> "Architecture accepted for Java 25";
        };
        System.out.println(message);
        return message;
    }

    /**
     * TODO 1: Return true only for supported architectures (x64, aarch64,
     * riscv64). Reject everything else.
     */
    public boolean isSupportedArch(String architectureName) {
        throw new UnsupportedOperationException("TODO: whitelist the supported 64-bit arch names.");
    }
}
