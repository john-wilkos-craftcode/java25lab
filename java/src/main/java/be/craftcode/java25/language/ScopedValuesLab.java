package be.craftcode.java25.language;

import java.lang.ScopedValue;

/**
 * +--------------------------------+
 * |   JEP 506: Scoped Values       |
 * +--------------------------------+
 * Scoped values provide immutable, thread-bound context that follows structured
 * and virtual threads without the usual ThreadLocal bookkeeping.
 */
public class ScopedValuesLab {

    private static final ScopedValue<String> REQUEST_ID = ScopedValue.newInstance();
    private static final ScopedValue<String> CHILD_SPAN = ScopedValue.newInstance();

    /**
     * Demo: stamps the request id into the scoped value and reads it back from a
     * pretend "deep" method.
     */
    public String describeRequest(String requestId) throws Exception {
        return ScopedValue.where(REQUEST_ID, requestId)
                .call(() -> "Handling request %s on %s".formatted(REQUEST_ID.get(), Thread.currentThread().getName()));
    }

    /**
     * TODO 1: Use nested `ScopedValue.where(...)` calls so the return string looks
     * like "<root> -> child:<suffix> (on <thread>)". Store the root request id in
     * REQUEST_ID and the child span name in CHILD_SPAN.
     */
    public String captureChildSpan(String rootRequestId, String childSuffix) throws Exception {
        throw new UnsupportedOperationException("TODO: push two scoped values and format the relationship string.");
    }
}
