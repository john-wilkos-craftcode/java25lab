package be.craftcode.java25.java21.records;

import java.time.Year;
import java.util.List;

record Award(String name, String category, int year) {
    /* no body needed! */
}

record Author(String firstName, String lastName, int age, List<Award> awards) {
}

record Book(String title, int pages, double price, Author author) {
}

public class Java21RecordPatterns {
    /**
     * Records are immutable data containers which come with common functions
     * built-in: field accessors, equals(), hashCode(), and toString().
     * (see above for examples)
     * 
     * +------------------------------+
     * |   JEP 440: Record Patterns   |
     * +------------------------------+
     * 
     * (https://openjdk.org/jeps/440)
     * 
     * Let's say you get an object that you're hoping is a certain type of record
     * and you want to print out one of its properties to the terminal. How do you do it?
     * 
     * As of Java 16: Match the record, then access the properties. 
     * 
     * Example:
     * 
     * record Point(int x, int y) {}
     * 
     * static void printSum(Object obj) {
     *     if (obj instanceof Point p) {
     *         int x = p.x();
     *         int y = p.y();
     *         System.out.println(x+y);
     *     }
     * }
     * 
     * As of Java 21: Match the record with property variables and simply access
     * them directly.
     * 
     * static void printSum(Object obj) {
     *     if (obj instanceof Point(int x, int y)) {
     *         System.out.println(x+y);
     *     }
     * }
     * 
     * The benefits of this new approach are more clearly apparent when dealing with
     * nested records:
     * 
     * 
     * record Point(int x, int y) {}
     * enum Color { RED, GREEN, BLUE }
     * record ColoredPoint(Point p, Color c) {}
     * record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {}
     * 
     * // As of Java 16:
     * static void printXCoordOfUpperLeftPointTheOldWay(Rectangle r) {
     *     if(r instance of Rectangle rectangle){
     *         if(rectangle.upperLeft() instanceof ColoredPoint coloredPoint){
     *             if(coloredPoint.p() instanceof Point topLeft){
     *                 int x = topLeft.x();
     *                 System.out.println("Upper-left corner: " + x);
     *             }
     *         }
     *     }
     * }
     * 
     * // As of Java 21:
     * static void printXCoordOfUpperLeftPointWithPatterns(Rectangle r) {
     *     if (r instanceof Rectangle(ColoredPoint(Point(var x, var y), var c), var lr)) {
     *         System.out.println("Upper-left corner: " + x);
     *     }
     * }
     */

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

    public String findOldestAwardCategoryForAuthorOfBook(Object obj) {
        // TODO 1: Use the new record patterns to return the oldest award that the
        // author of the book has. Return empty string if no match is found.
        return "fail";
    }
}
