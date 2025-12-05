package be.craftcode.java25;

/**
 * +---------------------------------------------+
 * |   JEP 512: Compact Source Files & main()   |
 * +---------------------------------------------+
 * Java 25 lets us prototype with an implicit class plus `void main()` at the top
 * of the file. The mood is calmer: fewer keywords, same executable result, and a
 * good way to show students that the platform can be minimal when it wants to.
 * 
 * 
 */
public class CompactSourceFilesLab {

    void main() {
        System.out.println(sayHello());
    }

    String sayHello() {
        String name = "YourNameHere"; 
        return String.format(
            """
            ================================================================
                Hello, %s! 

                (•_•)
                ( •_•)>⌐■-■
                (⌐■_■)
                Just FYI, Java is cool and modern now.
            ================================================================
                """, name);
    }
}
