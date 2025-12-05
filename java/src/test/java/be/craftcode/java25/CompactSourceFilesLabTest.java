package be.craftcode.java25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompactSourceFilesLabTest {

    private final CompactSourceFilesLab lab = new CompactSourceFilesLab();

    @Test
    void demoContainsCoderName() {
        String snippet = lab.sayHello();
        assertFalse(snippet.contains("YourNameHere"), """
                                                        .
                                                            Please put a different name in the sayHello method! 
                                                                Unless your name is actually \"YourNameHere\", in which case
                                                                I'm so sorry your parents did that to you.
                                                                """);
    }

}
