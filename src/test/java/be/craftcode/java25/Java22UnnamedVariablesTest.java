package be.craftcode.java25;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Java22UnnamedVariablesTest {
    Java22UnnamedVariables java22UnnamedVariables = new Java22UnnamedVariables();

    Award awardOne = new Award("International Horror Guild Award", "Living Legend Award", 2003);
    Award awardTwo = new Award("Bram Stoker Award", "Lifetime Achievement Award", 2002);
    Award awardThree = new Award("World Horror Convention", "Grand Master Award", 1992);
    Author authorOne = new Author("Stephen", "King", 79, new ArrayList<>(Arrays.asList(awardOne, awardTwo, awardThree)));
    Book bookOne = new Book("Pet Sematary", 416, 15.99, authorOne);

    @Test
    void oldWrongTest() {
        assertEquals("", java22UnnamedVariables.oldStyleFindOldestAwardCategoryForAuthorOfBook(null), "Expected wrong object to return empty.");
        assertEquals("", java22UnnamedVariables.oldStyleFindOldestAwardCategoryForAuthorOfBook(3), "Expected wrong object to return empty.");
        assertEquals("", java22UnnamedVariables.oldStyleFindOldestAwardCategoryForAuthorOfBook(awardOne), "Expected wrong object to return empty.");
    }

    @Test
    void oldRightTest() {
        assertEquals("Grand Master Award", java22UnnamedVariables.oldStyleFindOldestAwardCategoryForAuthorOfBook(bookOne));
    }

    @Test
    void givenWrongInputOldestCategoryShouldReturnEmpty() {
        assertEquals("", java22UnnamedVariables.findOldestAwardCategoryForAuthorOfBook(null), "Expected wrong object to return empty.");
        assertEquals("", java22UnnamedVariables.findOldestAwardCategoryForAuthorOfBook(3), "Expected wrong object to return empty.");
        assertEquals("", java22UnnamedVariables.findOldestAwardCategoryForAuthorOfBook(awardOne), "Expected wrong object to return empty.");
    }

    @Test
    void givenBookOldestCategoryShouldReturnCorrectString() {
        assertEquals("Grand Master Award", java22UnnamedVariables.findOldestAwardCategoryForAuthorOfBook(bookOne));
    }
}
