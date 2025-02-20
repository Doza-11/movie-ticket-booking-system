package exceptions;

public class MovieAlreadyExist extends RuntimeException {

    public MovieAlreadyExist() {
        super("Movie is already exists with same name and language");
    }
}
