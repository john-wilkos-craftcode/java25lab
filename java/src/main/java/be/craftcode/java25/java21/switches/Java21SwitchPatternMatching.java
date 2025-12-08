package be.craftcode.java25.java21.switches;

import java.util.List;

record Award(String name, String category, int year) {
    /* no body needed! */
}

record Author(String firstName, String lastName, int age, List<Award> awards) {
}

record Book(String title, int pages, double price, Author author) {
}

public class Java21SwitchPatternMatching {
    /*
     * 
     * +------------------------------------------+
     * | JEP 441: Pattern Matching for switch |
     * +------------------------------------------+
     * ( https://openjdk.org/jeps/441 )
     * 
     * 
     * Imagine you get an Object obj, and depending on what type it is (Integer,
     * Long, Double, String...), you want to perform different operations.
     *
     * // Prior to Java 16 you had to check the type, then explicitly cast it:
     * if (obj instanceof String) {
     *     String s = (String)obj;
     *     ... use s ...
     * }
     * 
     * // As of Java 16 you can use pattern matching:
     * if (obj instanceof String s) {
     *     ... use s ...
     * }
     * 
     * //But, if you had a lot of possible types, you still ended up with a long
     * chain of else-ifs:
     * 
     * // Prior to Java 21
     * static String formatter(Object obj) {
     *     String formatted = "unknown";
     *     if (obj instanceof Integer i) {
     *         formatted = String.format("int %d", i);
     *     } else if (obj instanceof Long l) {
     *         formatted = String.format("long %d", l);
     *     } else if (obj instanceof Double d) {
     *         formatted = String.format("double %f", d);
     *     } else if (obj instanceof String s) {
     *         formatted = String.format("String %s", s);
     *     }
     *     return formatted;
     * }
     * 
     * When you have a long chain of "else-if"s evaluating the same object,
     * you should consider using a switch instead.
     * 
     * Why? Because it's faster.
     * 
     * Each new if/else statement adds time to execution.
     * (e.g. If one "if" takes 1 second to evaluate, then 100 "else if"s would take
     * 100 seconds.
     * In terms of Time Complexity this is called linear time, or in big O notation:
     * O(n).)
     * 
     * In comparision, Switch evalution time is constant.
     * (e.g. If one case takes 1 second to evaluate, then 100 cases would also take
     * 1 second.
     * This is called constant time, or O(1).)
     * 
     * 
     * Problem:
     * We can only switch on values of a few types — integral primitive
     * types (excluding long), their corresponding boxed forms, enum types, and
     * String — and we can only test for exact equality against constants.
     * 
     * Solution:
     * Pattern Matching for Switch!
     * 
     * // As of Java 21
     * static String formatterPatternSwitch(Object obj) {
     *     return switch (obj) {
     *         case Integer i -> String.format("int %d", i);
     *         case Long l -> String.format("long %d", l);
     *         case Double d -> String.format("double %f", d);
     *         case String s -> String.format("String %s", s);
     *         default -> obj.toString();
     *     };
     * }
     * 
     * NULL HANDLING
     * ------------------
     * Before Java 21, submitting a null value to a switch immediately triggered a
     * NullPointerException, which meant you had to test for null outside of the
     * switch first, like so:
     * 
     * // Prior to Java 21
     * static void testFooBarOld(String s) {
     *     if (s == null) {
     *         System.out.println("Oops!");
     *         return;
     *     }
     *     switch (s) {
     *         case "Foo", "Bar" -> System.out.println("Great");
     *         default -> System.out.println("Ok");
     *     }
     * }
     * 
     * This made sense when you could only use primitives and their boxed types,
     * enums, and Strings in a switch, but now that we can use any type, the switch
     * needs to have null handling built in. You can now "catch" null input with
     * 'case null'. Instead of immediately throwing a NullPointerException when a
     * Switch is provided with a null value, now the Java compiler first checks if
     * there is a null case available, and if not, it throws the exception.
     * 
     * // As of Java 21
     * static void testFooBarNew(String s) {
     *     switch (s) {
     *         case null -> System.out.println("Oops");
     *         case "Foo", "Bar" -> System.out.println("Great");
     *         default -> System.out.println("Ok");
     *     }
     * }
     * 
     * You can even combine null and default to the same case label:
     * 
     * switch (obj) {
     *     ...
     *     case null, default ->
     *     System.out.println("The rest (including null)");
     * }
     * 
     * 
     * 
     * GUARDS
     * ----------------------
     * 
     * Problem:
     * If you wanted to add some conditions to your switch case,
     * you used to have to do it on the right side of the arrow (see below).
     * As you can see, it can get a bit difficult to follow:
     * 
     * // Before Java 21
     * static void testStringOld(String response) {
     *     switch (response) {
     *         case null -> { }
     *         case String s -> {
     *             if (s.equalsIgnoreCase("YES"))
     *                 System.out.println("You got it");
     *             else if (s.equalsIgnoreCase("NO"))
     *                 System.out.println("Shame");
     *             else
     *                 System.out.println("Sorry?");
     *         }
     *     }
     * }
     * 
     * Solution:
     * Guards! The "when" clause goes on the left side of the arrow and makes it
     * easier to follow.
     * Judge for yourself:
     * 
     * // As of Java 21
     * static void testStringNew(String response) {
     *     switch (response) {
     *         case null -> { }
     *         case String s
     *             when s.equalsIgnoreCase("YES") -> {
     *                 System.out.println("You got it");
     *             }
     *         case String s
     *             when s.equalsIgnoreCase("NO") -> {
     *                 System.out.println("Shame");
     *         }
     *         case String s -> {
     *             System.out.println("Sorry?");
     *         }
     *     }
     * }
     * 
     * When you add constants, a new switch structure begins to appear:
     * 
     * // As of Java 21
     * static void testStringEnhanced(String response) {
     *     switch (response) {
     *         case null -> { }
     *         case "y", "Y" -> {
     *             System.out.println("You got it");
     *         }
     *         case "n", "N" -> {
     *             System.out.println("Shame");
     *         }
     *         case String s
     *             when s.equalsIgnoreCase("YES") -> {
     *                 System.out.println("You got it");
     *         }
     *         case String s
     *             when s.equalsIgnoreCase("NO") -> {
     *                 System.out.println("Shame");
     *         }
     *         case String s -> {
     *             System.out.println("Sorry?");
     *         }
     *     }
     * }
     * 
     * DOMINANCE
     * -------------------------
     * We should check the most specific cases first, for example constants (like
     * "y" or "n"), and move to more and more general cases (like String s) further
     * down the switch.
     * 
     * This order is important because when a case label is a superset of another,
     * it is said to "dominate" it. For example, case String s dominates case "y".
     * If you put case String s before case "y", the later case would be unreachable
     * and a compliler error would be triggered.
     * 
     * This means that switch case labels must be ordered from least to most
     * dominant.
     * 
     * 
     * BETTER ENUM SUPPORT
     * -------------------------
     * 
     * When Switching over Enums, you used to be forced to only use the simple names
     * of the enum's constants in case labels. Example:
     * 
     * // Prior to Java 21
     * public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
     * 
     * static void testforHearts(Suit s) {
     * switch (s) {
     * case HEARTS -> System.out.println("It's a heart!");
     * default -> System.out.println("Some other suit");
     * }
     * }
     * 
     * Problem:
     * Now that we can use pattern labels, this old style results in unnecessarily
     * verbose code when enums are part of the possibilities involved:
     * 
     * // As of Java 21
     * sealed interface CardClassification permits Suit, Tarot {}
     * public enum Suit implements CardClassification { CLUBS, DIAMONDS, HEARTS,
     * SPADES }
     * final class Tarot implements CardClassification {}
     * 
     * static void exhaustiveSwitchWithoutEnumSupport(CardClassification c) {
     *     switch (c) {
     *         case Suit s when s == Suit.CLUBS -> {
     *             System.out.println("It's clubs");
     *         }
     *         case Suit s when s == Suit.DIAMONDS -> {
     *             System.out.println("It's diamonds");
     *         }
     *         case Suit s when s == Suit.HEARTS -> {
     *             System.out.println("It's hearts");
     *         }
     *         case Suit s -> {
     *             System.out.println("It's spades");
     *         }
     *         case Tarot t -> {
     *             System.out.println("It's a tarot");
     *         }
     *     }
     * }
     * 
     * Solution:
     * Now we can directly use the qualified names of enum constants (e.g.
     * enum_name.constant) to differentiate between different types:
     * 
     * 
     * // As of Java 21
     * sealed interface CardClassification permits Suit, Tarot {}
     * public enum Suit implements CardClassification { CLUBS, DIAMONDS, HEARTS,
     * SPADES }
     * final class Tarot implements CardClassification {}
     * 
     * 
     * static void exhaustiveSwitchWithBetterEnumSupport(CardClassification c) {
     *     switch (c) {
     *         case Suit.CLUBS -> {
     *             System.out.println("It's clubs");
     *         }
     *         case Suit.DIAMONDS -> {
     *             System.out.println("It's diamonds");
     *         }
     *         case Suit.HEARTS -> {
     *             System.out.println("It's hearts");
     *         }
     *         case Suit.SPADES -> {
     *             System.out.println("It's spades");
     *         }
     *         case Tarot t -> {
     *             System.out.println("It's a tarot");
     *         }
     *     }
     * }
     * 
     * 
     * REMINDER ON EXHAUSTIVENESS
     * ----------------------------
     * Switch Expressions (switches that return a value) must be exhaustive
     * (i.e. all possible inputs need to be handled and return a value).
     * 
     * What does that mean now that we can switch over any object type?
     * 
     * // As of Java 21
     * static int coverage(Object obj) {
     *     return switch (obj) { // Error - not exhaustive
     *         case String s -> s.length();
     *         case Integer i -> i;
     *     };
     * }
     * 
     * An Object selector in a switch expression still needs all of its
     * subtypes to be handled. Since almost everything is an object in Java,
     * this list would be infinite. This means that a default case is required!
     * 
     * // As of Java 21
     * static int coverage(Object obj) {
     *     return switch (obj) {
     *         case String s -> s.length();
     *         case Integer i -> i;
     *         default -> 0;
     *     };
     * }
     * 
     * 
     */

    public String oldCheckObject(Object o) {
        String formatted;
        if (o instanceof Integer i) {
            formatted = String.format("int %d", i);
        } else if (o instanceof Long l) {
            formatted = String.format("long %d", l);
        } else if (o instanceof Double d) {
            formatted = String.format("double %f", d);
        } else if (o == null) {
            formatted = String.format("null");
        } else {
            formatted = String.format("Object %s", o.toString());
        }
        return formatted;
    }

    public String checkObject(Object obj) {
        // TODO1: rewrite the above method using Switch Pattern Matching
        return "fail";
    }

    public String testStringOld(String response) {
        return switch (response) {
            case null -> "null";
            case String s -> {
                if (s.equalsIgnoreCase("YES") || s.equalsIgnoreCase("Y")) {
                    yield "You got it";
                } else if (s.equalsIgnoreCase("NO") || s.equalsIgnoreCase("N")) {
                    yield "Shame";
                } else
                    yield "Sorry?";
            }
        };
    }

    public String testStringWithGuards(String input) {
        // TODO2: rewrite the above method using Switch Pattern Matching Guards.
        // Example: case Integer i when i>3 -> "something";
        return "fail";
    }

    // TODO3: Uncomment the method below. What's wrong with it? Can you fix it?

    /*

    public String testDominance(String input) {
        return switch (input) {
            case String s -> "It's a string: " + s;
            case "y" -> "It's the letter 'y'!";
            default -> "none";
        };
    }
    
    */
    

    sealed interface GameSystem permits PlayStation, Xbox, Nintendo, PC {
    }

    public enum PC implements GameSystem {
        RTX3060, RX580, RTX4090, RX7900
    }

    static final class Xbox implements GameSystem {
    }

    static final class PlayStation implements GameSystem {
    }

    public enum Nintendo implements GameSystem {
        SWITCH, WII, GAMECUBE, N64
    }

    public String oldEnumSupport(GameSystem gs) {
        String result = "";
        switch (gs) {
            case PC pc -> {
                switch (pc) {
                    case RTX3060 -> result = "This is a: RTX3060";
                    case RTX4090 -> result = "This is a: RTX4090";
                    case RX580 -> result = "This is a: RX580";
                    case RX7900 -> result = "This is a: RX7900";
                }
            }
            case Nintendo nintendo -> {
                switch (nintendo) {
                    case SWITCH -> result = "This is a: SWITCH";
                    case WII -> result = "This is a: WII";
                    case GAMECUBE -> result = "This is a: GAMECUBE";
                    case N64 -> result = "This is a: N64";
                }
            }
            case Xbox x-> result = "This is a: Xbox";
            case null, default -> result = "This is a: PlayStation";
        }

        return result;
    }

    public String betterEnumSupport(GameSystem gs) {
        // TODO4: Replace that mess above with a single exhaustive switch expression that 
        // uses the new enum qualified name support
        return "fail";
    }

}
