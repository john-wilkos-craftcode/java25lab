package be.craftcode.java25;

/**
 * +-------------------------------------------+
 * |   JEP 507: Primitive Patterns (Preview)   |
 * +-------------------------------------------+
 * Pattern matching for switch/instanceof now accepts primitive targets, so we
 * can branch on numbers without bouncing through boxed types.
 */
public class PrimitivePatternsLab {

    /**
     * Demo switch: inspects primitive wrappers without boxing back and forth.
     */
    public String describePayload(Object payload) {
        return switch (payload) {
            case Integer i when i == 0 -> "zero-ish int";
            case Integer i when i > 0 -> "positive int:" + i;
            case Integer i -> "negative int:" + i;
            case Long l -> "long:" + l;
            case Double d when Double.isFinite(d) -> "double:" + d;
            case Double d -> "double:NaN";
            case null -> "null payload";
            default -> "something else:" + payload.getClass().getSimpleName();
        };
    }

    /**
     * TODO 1: Pattern match the provided Number. 
     * ## Rules:
     *  - shorts and bytes should yield "tiny:<value>"
     *  - floats produce "float:<value>" with the raw float value
     *  - anything else delegates to `Number.longValue()` and returns
     *    "generic:<longValue>"
     */
    public String summarizeNumber(Number number) {
        throw new UnsupportedOperationException("TODO: use primitive patterns in a switch on Number.");
    }
}
