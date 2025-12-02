package be.craftcode.java25.runtime;

import java.util.List;

/**
 * +-------------------------------------------+
 * |   JEP 521: Generational Shenandoah GC     |
 * +-------------------------------------------+
 * Shenandoah now splits the heap into young and old regions, delivering shorter
 * minor pauses while concurrent compaction cleans up the rest.
 */
public class GenerationalShenandoahLab {

    public List<String> defaultFlags() {
        var flags = List.of(
                "-XX:+UseShenandoahGC",
                "-XX:+UseShenandoahGCGenerational",
                "-XX:ShenandoahGCMode=generational"
        );
        flags.forEach(System.out::println);
        return flags;
    }

    /**
     * TODO 1: Return Shenandoah tuning flags for the provided pause budget in ms.
     * Include:
     *  - All defaults above.
     *  - `-XX:MaxPauseMillis=<pauseBudgetMs>`
     *  - `-XX:ShenandoahGCHeuristics=aggressive` when pauseBudget <= 5
     *    otherwise `-XX:ShenandoahGCHeuristics=compact`.
     */
    public List<String> tuneForLatency(int pauseBudgetMs) {
        throw new UnsupportedOperationException("TODO: adjust Shenandoah heuristics based on pause budget.");
    }
}
