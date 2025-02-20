package exceptions;

public class ShowDoesNotExists extends RuntimeException {
    public ShowDoesNotExists() {
        super("Show doesn't exists");
    }
}
