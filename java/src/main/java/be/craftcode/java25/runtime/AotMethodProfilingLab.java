package be.craftcode.java25.runtime;

import java.util.List;

/**
 * +---------------------------------------+
 * |   JEP 515: AOT Method Profiling       |
 * +---------------------------------------+
 * Record execution profiles during a training run, store them, and feed the data
 * back into later JVM startups so tiered compilation can optimize immediately.
 */
public class AotMethodProfilingLab {

    /**
     * Demo: returns the two shell commands you'd typically run for training and
     * replaying the profile. Flag names may evolve, but the intent stays the same.
     */
    public List<String> trainingWorkflow(String jarName) {
        return List.of(
                "java -XX:CollectAOTProfile=profiles/%s.aprof -jar %s".formatted(jarName, jarName),
                "java -XX:LoadAOTProfile=profiles/%s.aprof -jar %s".formatted(jarName, jarName)
        );
    }

    /**
     * TODO 1: Build a replay command that injects the profile file and any extra
     * JVM flags before running the jar. Format:
     *   java -XX:LoadAOTProfile=<profile> <extraFlags...> -jar <jarName>
     */
    public String buildReplayCommand(String jarName, String profilePath, List<String> extraFlags) {
        throw new UnsupportedOperationException("TODO: join any extra flags between the profile and -jar arguments.");
    }
}
