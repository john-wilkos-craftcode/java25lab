package be.craftcode.java25;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class Java25FlexibleConstructorsLabTest {

    private final Java25FlexibleConstructorsLab lab = new Java25FlexibleConstructorsLab();
    private final LocalDateTime baseTime = LocalDateTime.of(2024, 5, 1, 8, 0);

    @Test
    void legacyTrainTicketLeaksNullSeat() {
        var ticket = lab.reproduceLegacyTrainTicket(baseTime);
        assertEquals("Intercity", ticket.zone());
        assertTrue(ticket.creationLog().get(1).contains("seat null"));
        assertTrue(ticket.isValid(baseTime.plusHours(1)));
    }

    @Test
    void tramTicketSanitizesLineBeforeCallingSuper() {
        var ticket = lab.demonstrateFlexibleTramTicket(baseTime);
        assertEquals("De Lijn", ticket.operator());
        assertEquals("5", ticket.lineCode());
        assertTrue(ticket.creationLog().get(1).contains("line 5"));
    }

    @Test
    void sharedBikePassMustInitializeBeforeSuper() {
        var pass = lab.createBikePass(baseTime, 40);
        assertEquals("Velo", pass.provider());
        assertEquals(40, pass.freeMinutes());
        assertEquals(50.0, pass.deposit());
        assertTrue(pass.creationLog().get(1).contains("Velo"));
        assertTrue(pass.creationLog().get(1).contains("50.00"));
        assertThrows(IllegalArgumentException.class, () -> lab.createBikePass(baseTime, 0));
    }

    @Test
    void studentSubscriptionValidatesBeforeSuper() {
        var subscription = lab.enrollStudent(baseTime, baseTime.plusMonths(1), "  STU-42  ", 20);
        assertEquals("STU-42", subscription.studentId());
        assertEquals(20, subscription.age());
        assertTrue(subscription.creationLog().get(1).contains("STU-42"));
        assertEquals(12.5, subscription.calculatePrice());
        assertThrows(IllegalArgumentException.class, () -> lab.enrollStudent(baseTime, baseTime.plusMonths(1), "stu", 16));
    }
}
