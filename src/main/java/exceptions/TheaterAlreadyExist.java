package exceptions;

public class TheaterAlreadyExist extends RuntimeException {
    public TheaterAlreadyExist() {
        super("Theater already exist");
    }
}
