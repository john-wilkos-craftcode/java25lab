package be.craftcode.java25;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/// # [JEP 513](https://openjdk.org/jeps/513): Flexible Constructor Bodies
///
/// Ticketing systems make for great demonstrations of this JEP. `TransportTicket`
/// logs details from its constructor, and subclasses such as `TrainTicket`
/// override the logging method. In legacy Java releases the subclass was forced
/// to call `super(...)` as the first statement, which meant the superclass could
/// access subclass fields *before* they were initialized. With flexible
/// constructor bodies, validation and initialization can now run before the
/// call to `super(...)`, preventing partially initialized state from leaking.
public class Java25FlexibleConstructorsLab {

    public static abstract class TransportTicket {
        private final double price;
        private final LocalDateTime validFrom;
        private final LocalDateTime validTo;
        private final String zone;
        private final List<String> creationLog = new ArrayList<>();

        protected TransportTicket(double price, LocalDateTime validFrom, LocalDateTime validTo, String zone) {
            if (price <= 0) {
                throw new IllegalArgumentException("price must be positive");
            }
            var start = Objects.requireNonNull(validFrom, "validFrom must not be null");
            var end = Objects.requireNonNull(validTo, "validTo must not be null");
            if (end.isBefore(start)) {
                throw new IllegalArgumentException("validTo must not be before validFrom");
            }
            var sanitizedZone = Objects.requireNonNull(zone, "zone must not be null").trim();
            if (sanitizedZone.isEmpty()) {
                throw new IllegalArgumentException("zone must not be blank");
            }
            this.price = price;
            this.validFrom = start;
            this.validTo = end;
            this.zone = sanitizedZone;
            creationLog.add("ctor:" + getClass().getSimpleName());
            creationLog.add(describeTicket());
        }

        protected String describeTicket() {
            return "Ticket for zone %s (%.2f EUR)".formatted(zone, price);
        }

        public double calculatePrice() {
            return price;
        }

        protected final double basePrice() {
            return price;
        }

        public boolean isValid(LocalDateTime when) {
            Objects.requireNonNull(when, "when must not be null");
            return !when.isBefore(validFrom) && !when.isAfter(validTo);
        }

        public LocalDateTime validFrom() {
            return validFrom;
        }

        public LocalDateTime validTo() {
            return validTo;
        }

        public String zone() {
            return zone;
        }

        public List<String> creationLog() {
            return List.copyOf(creationLog);
        }
    }

    public static final class TrainTicket extends TransportTicket {
        private final String operator;
        private final String trainNumber;
        private final String seat;

        public TrainTicket(double price, LocalDateTime validFrom, LocalDateTime validTo, String zone, String operator, String trainNumber, String seat) {
            super(price, validFrom, validTo, zone);
            this.operator = operator;
            this.trainNumber = trainNumber;
            this.seat = seat;
        }

        @Override
        protected String describeTicket() {
            return "%s train %s seat %s for zone %s".formatted(operator, trainNumber, seat, zone());
        }

        public String operator() {
            return operator;
        }

        public String trainNumber() {
            return trainNumber;
        }

        public String seat() {
            return seat;
        }
    }

    public static final class TramTicket extends TransportTicket {
        private final String operator;
        private final String lineCode;

        public TramTicket(double price, LocalDateTime validFrom, LocalDateTime validTo, String zone, String operator, String lineCode) {
            var sanitizedOperator = Objects.requireNonNull(operator, "operator must not be null").trim();
            if (sanitizedOperator.isEmpty()) {
                throw new IllegalArgumentException("operator must not be blank");
            }
            var sanitizedLine = Objects.requireNonNull(lineCode, "lineCode must not be null").trim();
            if (sanitizedLine.isEmpty()) {
                throw new IllegalArgumentException("lineCode must not be blank");
            }
            this.operator = sanitizedOperator;
            this.lineCode = sanitizedLine.toUpperCase();
            super(price, validFrom, validTo, zone);
        }

        @Override
        protected String describeTicket() {
            return "%s tram line %s for zone %s".formatted(operator, lineCode, zone());
        }

        public String operator() {
            return operator;
        }

        public String lineCode() {
            return lineCode;
        }
    }

    public static final class SharedBikePass extends TransportTicket {
        private final String provider;
        private final int freeMinutes;
        private final double deposit;

        /// TODO 1: Complete this constructor to demonstrate flexible constructor bodies.
        /// Requirements:
        /// 1. Validate that `provider` is not blank and `freeMinutes` is > 0
        ///    before calling `super(...)`.
        /// 2. Normalize the provider with [String#trim()] and store it in the field.
        /// 3. Compute `deposit` as {`Math.min(75.0, freeMinutes * 1.25)` before
        ///    invoking the `super(...)` constructor.
        /// 4. Finally, invoke `super(price, validFrom, validTo, zone)` so that the
        ///    [TransportTicket] constructor logs the already-initialized values.
        public SharedBikePass(double price, LocalDateTime validFrom, LocalDateTime validTo, String zone, String provider, int freeMinutes) {
            super(price, validFrom, validTo, zone);
            throw new UnsupportedOperationException("TODO: validate and initialize fields before calling super.");
        }

        @Override
        protected String describeTicket() {
            return "%s bike pass with %d free minutes (deposit %.2f)".formatted(provider, freeMinutes, deposit);
        }

        public String provider() {
            return provider;
        }

        public int freeMinutes() {
            return freeMinutes;
        }

        public double deposit() {
            return deposit;
        }
    }

    public static final class StudentSubscription extends TransportTicket {
        private final String studentId;
        private final int age;

        ///TODO 2: Finish this constructor so students can initialize and validate their state
        ///before invoking `super(...)`.
        ///Requirements:
        ///1. `studentId` must be non-blank; trim it and store the uppercased trimmed value.
        ///2. `age` must be between 17 and 26 (inclusive), otherwise throw
        ///[IllegalArgumentException].
        ///3. Assign both fields *before* calling `super(...)` so that
        ///[TransportTicket]'s constructor logs the correct information.
        public StudentSubscription(double price, LocalDateTime validFrom, LocalDateTime validTo, String zone, String studentId, int age) {
            super(price, validFrom, validTo, zone);
            throw new UnsupportedOperationException("TODO: validate student data and initialize fields before calling super.");
        }

        @Override
        protected String describeTicket() {
            return "Student %s (%d) for zone %s".formatted(studentId, age, zone());
        }

        @Override
        public double calculatePrice() {
            return Math.round(basePrice() * 0.5 * 100.0) / 100.0;
        }

        public String studentId() {
            return studentId;
        }

        public int age() {
            return age;
        }
    }

    public TrainTicket reproduceLegacyTrainTicket(LocalDateTime validFrom) {
        var start = Objects.requireNonNull(validFrom, "validFrom must not be null");
        return new TrainTicket(24.0, start, start.plusHours(3), "Intercity", "NMBS", "IC-431", "16A");
    }

    public TramTicket demonstrateFlexibleTramTicket(LocalDateTime validFrom) {
        var start = Objects.requireNonNull(validFrom, "validFrom must not be null");
        return new TramTicket(2.9, start, start.plusHours(2), "Antwerp", "De Lijn", " 5 ");
    }

    public SharedBikePass createBikePass(LocalDateTime validFrom, int freeMinutes) {
        var start = Objects.requireNonNull(validFrom, "validFrom must not be null");
        return new SharedBikePass(15.0, start, start.plusDays(5), "Antwerp", "  Velo  ", freeMinutes);
    }

    public StudentSubscription enrollStudent(LocalDateTime validFrom, LocalDateTime validTo, String studentId, int age) {
        Objects.requireNonNull(validFrom, "validFrom must not be null");
        Objects.requireNonNull(validTo, "validTo must not be null");
        return new StudentSubscription(25.0, validFrom, validTo, "Campus", studentId, age);
    }
}
