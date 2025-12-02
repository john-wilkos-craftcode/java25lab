package be.craftcode.java25.language;

import java.util.ArrayList;
import java.util.List;

/**
 * +----------------------------------------------+
 * |   JEP 513: Flexible Constructor Bodies       |
 * +----------------------------------------------+
 * Constructors can now validate parameters, log, or compute derived values
 * before invoking `super(...)`. The runtime still enforces that the parent
 * constructor runs exactly once; it just stops insisting that it runs first.
 */
public class FlexibleConstructorsLab {

    public static final class LegacyPanel {
        private final String title;
        private final int width;
        private final List<String> auditTrail;

        public LegacyPanel(String title, int width, List<String> auditTrail) {
            this.title = title;
            this.width = width;
            this.auditTrail = List.copyOf(auditTrail);
        }

        public String title() {
            return title;
        }

        public int width() {
            return width;
        }

        public List<String> auditTrail() {
            return auditTrail;
        }

        @Override
        public String toString() {
            return "LegacyPanel[" + title + "," + width + "," + auditTrail + "]";
        }
    }

    /**
     * Demo method: validates the title before the `super(...)` call, a sequence
     * that used to require awkward helper methods.
     */
    public LegacyPanel buildValidatedPanel(String rawTitle, int width) {
        class ValidatedPanel extends LegacyPanel {
            ValidatedPanel(String incomingTitle, int incomingWidth) {
                var trimmed = incomingTitle.strip();
                if (trimmed.isBlank()) {
                    throw new IllegalArgumentException("Title must contain visible characters");
                }
                System.out.println("Pre-flight validation for '%s'".formatted(trimmed));
                super(trimmed, Math.max(100, incomingWidth), List.of("validated:" + trimmed));
            }
        }
        return new ValidatedPanel(rawTitle, width);
    }

    /**
     * TODO 1: Create another constructor exercise.
     * Requirements:
     *  - Define a local class `AuditedPanel` that extends {@link LegacyPanel}.
     *  - Before calling `super(...)`, add "preflight:<title>" and one entry per
     *    extra note (format: "note:<note>") to an {@link ArrayList}.
     *  - Pass that list to `super(...)` so the audit trail survives.
     *  - Return the new panel so tests can confirm the behavior.
     */
    public LegacyPanel buildAuditedPanel(String rawTitle, int width, List<String> extraNotes) {
        throw new UnsupportedOperationException("TODO: create a flexible constructor that records preflight data before calling super.");
    }
}
