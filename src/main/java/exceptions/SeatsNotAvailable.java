package exceptions;

public class SeatsNotAvailable extends RuntimeException {
    public SeatsNotAvailable() {
        super("Seats not available");
    }
}
