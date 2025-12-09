package be.craftcode.java25;

/// # [JEP 507](https://openjdk.org/jeps/507): Primitive Patterns (Preview)
/// Primitive type patterns can now be used directly in `switch` and `instanceof`
/// constructs. Inspired by the JEP examples, this lab demonstrates matching on
/// booleans and large `long` constants without awkward helper code.
public class PrimitivePatternsLab {

    /// Demo switch: inspects primitive values (including booleans and longs)
    /// directly, with guards for the trickier cases.
    public String describePayload(Object payload) {
        return switch (payload) {
            case null -> "null payload";
            case boolean flag -> "boolean:" + flag;
            case int i when i == 0 -> "zero-ish int";
            case int i when i > 0 -> "positive int:" + i;
            case int i -> "negative int:" + i;
            case long l when l >= 10_000_000_000L -> "huge long:" + l;
            case long l -> "long:" + l;
            case double d when Double.isFinite(d) -> "double:" + d;
            case double d -> "double:NaN";
            default -> "something else:" + payload.getClass().getSimpleName();
        };
    }

    /// Mirrors the boolean `switch` example in the JEP: statement blocks may now
    /// appear on a boolean expression rather than juggling ternaries.
    public int resolveUserId(boolean loggedIn, int knownUserId) {
        return switch (loggedIn) {
            case true -> knownUserId;
            case false -> {
                System.out.println("Guest login detected");
                yield -1;
            }
        };
    }

    /// *TODO 1: Dispatch commands using a `long` switch, as shown in the JEP.*
    /// Requirements:
    ///  - Use a `switch` on the primitive `long` command code.
    ///  - Recognize `1L` as "dispatch:new-order" and `2L` as "dispatch:status-check".
    ///  - Treat `10_000_000_000L` as "dispatch:priority-escalation" and
    ///    `20_000_000_000L` as "dispatch:bulk-export".
    ///  - For all other values, capture the primitive with `case long other ->`
    ///    and return "dispatch:fallback:*value*".
    /// The method should compile before you implement it; the accompanying tests
    /// will fail until you replace the exception with the switch.
    public String describeCommand(long commandCode) {
        throw new UnsupportedOperationException("TODO: implement the long-pattern switch from JEP 507.");
    }
}
