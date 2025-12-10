package be.craftcode.java25;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class Java25FlexibleConstructorsLabTest {

    private final Java25FlexibleConstructorsLab lab = new Java25FlexibleConstructorsLab();
    private final LocalDateTime baseTime = LocalDateTime.of(2025, 12, 1, 8, 0);

    @Test
    void legacyTrainTicketLeaksNullSeat() {
        var ticket = lab.reproduceLegacyTrainTicket(baseTime);
        var logEntry = ticket.creationLog().get(1);

        assertAll("legacy ticket",
                () -> assertEquals("Intercity", ticket.zone(), "legacy ticket should keep the original zone"),
                () -> assertTrue(logEntry.contains("seat null"), "log should document that the seat is null"),
                () -> assertTrue(ticket.isValid(baseTime.plusHours(1)), "ticket must remain valid for some time"));
    }

    @Test
    void tramTicketSanitizesLineBeforeCallingSuper() {
        var ticket = lab.demonstrateFlexibleTramTicket(baseTime);
        var logEntry = ticket.creationLog().get(1);

        assertAll("tram ticket",
                () -> assertEquals("De Lijn", ticket.operator(), "operator should remain unchanged"),
                () -> assertEquals("5", ticket.lineCode(), "line code must be trimmed before calling super"),
                () -> assertTrue(logEntry.contains("line 5"), "log should contain the sanitized line info"));
    }

    @Test
    void sharedBikePassMustInitializeBeforeSuper() {
        var pass = lab.createBikePass(baseTime, 40);
        var logEntry = pass.creationLog().get(1);
        assertAll("bike pass",
                () -> assertEquals("Velo", pass.provider(), "provider should default to Velo"),
                () -> assertEquals(40, pass.freeMinutes(), "free minutes must be propagated"),
                () -> assertEquals(50.0, pass.deposit(), "deposit should be set to 75.0 or freeMinutes * 1.25, whichever is smallest."),
                () -> assertTrue(logEntry.contains("Velo"), "log should reference the provider"),
                () -> assertTrue(logEntry.contains("50.00"), "log should include the deposit amount"));
        assertThrows(IllegalArgumentException.class, () -> lab.createBikePass(baseTime, 0),
                "bike pass must reject non-positive free minutes");
        assertThrows(IllegalArgumentException.class,
                () -> new Java25FlexibleConstructorsLab.SharedBikePass(15.0, baseTime, baseTime.plusDays(5), "Antwerp", "", 4),
                "did not validate required Provider before super");
    }

    @Test
    void studentSubscriptionValidatesBeforeSuper() {
        var subscription = lab.enrollStudent(baseTime, baseTime.plusMonths(1), "  Stu-42  ", 20);
        var logEntry = subscription.creationLog().get(1);

        assertAll("student subscription",
                () -> assertEquals("STU-42", subscription.studentId(), "student id should be trimmed and uppercased"),
                () -> assertEquals(20, subscription.age(), "age must be stored"),
                () -> assertTrue(logEntry.contains("STU-42"), "log should mention the normalized student id"),
                () -> assertEquals(12.5, subscription.calculatePrice(), "price calculation should reflect flexible constructors"));
        assertThrows(IllegalArgumentException.class,
                () -> lab.enrollStudent(baseTime, baseTime.plusMonths(1), "", 20),
                "enrollment should fail for invalid id");
        assertThrows(IllegalArgumentException.class,
                () -> lab.enrollStudent(baseTime, baseTime.plusMonths(1), "stu", 16),
                "enrollment should fail for invalid age");
    }
}
