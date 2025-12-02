package be.craftcode.java25.language;

import java.util.List;

/**
 * +------------------------------------------+
 * |   JEP 511: Module Import Declarations    |
 * +------------------------------------------+
 * Java 25 lets us import every exported package of a module in a single line.
 * Less repetition, same clarity, and fewer chances to forget a companion import.
 */
public class ModuleImportLab {

    /**
     * Demo snippet that shows how two modules can be imported at the top of a
     * compact source file.
     */
    public String showDesktopSnippet() {
        var snippet = """
                import module java.desktop;
                import module java.sql;

                void main() {
                    println("Both Swing and JDBC types are now on the classpath");
                }
                """.strip();
        System.out.println(snippet);
        return snippet;
    }

    /**
     * TODO 1: Return a newline-separated list of `import module` statements for
     * the provided modules. Keep them alphabetically sorted to avoid compiler
     * diff churn.
     */
    public String createImportBlock(List<String> modules) {
        throw new UnsupportedOperationException("TODO: render each module as `import module <name>;` on its own line.");
    }
}
