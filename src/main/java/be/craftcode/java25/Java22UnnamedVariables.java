package be.craftcode.java25;

import java.time.Year;
import java.util.List;

record Award(String name, String category, int year) {
    /* no body needed! */
}

record Author(String firstName, String lastName, int age, List<Award> awards) {
}

record Book(String title, int pages, double price, Author author) {
}

/// # [JEP 456](https://openjdk.org/jeps/456): Unnamed Variables & Patterns
/// This is an updated version of the Record patterns class to focus on the unnamed variables aspect.
///
/// ##### RELATED: [JEP 440](https://openjdk.org/jeps/440): Record Patterns
///
/// ```java
/// static void printXCoordOfUpperLeftPointWithPatterns(Rectangle r) {
///     if (r instanceof Rectangle(ColoredPoint(Point(var x, var y), var c), var lr)) {
///         System.out.println("Upper-left corner: " + x);
///     }
/// }
/// ```
public class Java22UnnamedVariables {

    public String oldStyleFindOldestAwardCategoryForAuthorOfBook(Object obj) {
        if (obj instanceof Book book) {
            if (book.author() instanceof Author author) {
                if (author.awards() instanceof List<Award> awards) {
                    Award oldestAward = new Award("", "", Integer.parseInt(Year.now().toString()));
                    for (Award award : awards) {
                        if (award.year() < oldestAward.year()) {
                            oldestAward = award;
                        }
                    }
                    if (!oldestAward.category().isBlank()) {
                        return oldestAward.category();
                    }
                }
            }
        }
        return "";
    }

    /// #### Reminder of our record structure:
    /// ```java
    /// record Award(String name, String category, int year) {}
    /// record Author(String firstName, String lastName, int age, List<Award> awards) {}
    /// record Book(String title, int pages, double price, Author author) {}
    /// ```
    /// ## TODO 1 :
    /// 1. Use record patterns and the new unnamed variables to return the oldest award that the
    /// author of the input book has.
    /// 2. Return an empty string if no match is found.
    public String findOldestAwardCategoryForAuthorOfBook(Object obj) {
        return "fail";
    }
}
