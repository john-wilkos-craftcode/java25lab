package be.craftcode.java25.language;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlexibleConstructorsLabTest {

    private final FlexibleConstructorsLab lab = new FlexibleConstructorsLab();

    @Test
    void demoValidatesAndPadsWidth() {
        FlexibleConstructorsLab.LegacyPanel panel = lab.buildValidatedPanel("  Dashboard  ", 50);
        assertEquals("Dashboard", panel.title());
        assertEquals(100, panel.width());
        assertEquals(List.of("validated:Dashboard"), panel.auditTrail());
    }

    @Test
    void todoAuditedPanelAddsNotesBeforeSuper() {
        FlexibleConstructorsLab.LegacyPanel panel = lab.buildAuditedPanel("Metrics", 160, List.of("rotate-keys", "ping-cache"));
        assertEquals("Metrics", panel.title());
        assertEquals(160, panel.width());
        assertEquals(List.of("preflight:Metrics", "note:rotate-keys", "note:ping-cache"), panel.auditTrail());
    }
}
