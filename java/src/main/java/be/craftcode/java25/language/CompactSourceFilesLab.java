package be.craftcode.java25.language;

/**
 * +---------------------------------------------+
 * |   JEP 512: Compact Source Files & main()   |
 * +---------------------------------------------+
 * Java 25 lets us prototype with an implicit class plus `void main()` at the top
 * of the file. The mood is calmer: fewer keywords, same executable result, and a
 * good way to show students that the platform can be minimal when it wants to.
 */
public class CompactSourceFilesLab {

    /**
     * Demo method: prints and returns a valid compact-source snippet so students can
     * paste it directly into a file and see the lean entrypoint in action.
     */
    public String runCompactHello(String coder) {
        var snippet = ("""
                // This file has no class declaration on purpose.
                void main() {
                    println("Hello, %s! Java 25 is fine with a minimalist entry point.");
                }
                """.strip()).formatted(coder);
        System.out.println(snippet);
        return snippet;
    }

    /**
     * TODO 1: Build another compact source snippet that prints the provided message.
     * Requirements:
     *  - Use a text block (this feature exists; let's lean on it).
     *  - Keep the structure exactly like the demo: comment, void main, println.
     *  - Return the snippet so the tests (and students) can verify it.
     */
    public String buildCompactSnippet(String message) {
        throw new UnsupportedOperationException("TODO: create a compact source snippet that prints the given message.");
    }
}
