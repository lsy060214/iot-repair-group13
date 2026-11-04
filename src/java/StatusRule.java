public class StatusRule {
    public enum Status { PENDING, PROCESSING, COMPLETED }

    public static boolean canTransition(Status current, Status target) {
        // Allowed: PENDING -> PROCESSING (maintainer starts the repair)
        if (current == Status.PENDING && target == Status.PROCESSING) {
            return true;
        }
        // Allowed: PROCESSING -> COMPLETED (maintainer finishes the repair)
        if (current == Status.PROCESSING && target == Status.COMPLETED) {
            return true;
        }
        // Reject all other transitions: skipping, rollback, same-state, null input.
        return false;
    }
}
