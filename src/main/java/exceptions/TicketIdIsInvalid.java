package exceptions;

public class TicketIdIsInvalid extends RuntimeException {
    public TicketIdIsInvalid() {
        super("Ticket Id is invalid");
    }
}
