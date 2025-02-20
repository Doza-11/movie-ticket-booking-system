package exceptions;

public class TheaterIsNotExists extends RuntimeException {
    public TheaterIsNotExists() {
        super("The theater is not exists");
    }
}
