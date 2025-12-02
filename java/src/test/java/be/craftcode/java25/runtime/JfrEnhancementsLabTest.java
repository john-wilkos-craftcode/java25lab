package be.craftcode.java25.runtime;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JfrEnhancementsLabTest {

    private final JfrEnhancementsLab lab = new JfrEnhancementsLab();

    @Test
    void demoListsNewEvents() {
        List<String> bullets = lab.highlightNewEvents();
        assertEquals(3, bullets.size());
    }

    @Test
    void todoPlansRecordingCommand() {
        String command = lab.planRecording("demo", Duration.ofSeconds(30), List.of("method-timing", "virtual-threads"));
        assertEquals("jcmd JFR.start name=demo duration=30s settings=profile delay=0s events=method-timing,virtual-threads", command);
    }
}
