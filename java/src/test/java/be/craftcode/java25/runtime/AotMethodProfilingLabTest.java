package be.craftcode.java25.runtime;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AotMethodProfilingLabTest {

    private final AotMethodProfilingLab lab = new AotMethodProfilingLab();

    @Test
    void demoProvidesTrainingCommands() {
        var commands = lab.trainingWorkflow("orders");
        assertEquals(2, commands.size());
        assertTrue(commands.getFirst().contains("CollectAOTProfile"));
    }

    @Test
    void todoReplayCommandConcatenatesFlags() {
        String command = lab.buildReplayCommand("orders.jar", "profiles/orders.aprof", List.of("-Xms512m", "-Xmx512m"));
        assertEquals("java -XX:LoadAOTProfile=profiles/orders.aprof -Xms512m -Xmx512m -jar orders.jar", command);
    }
}
