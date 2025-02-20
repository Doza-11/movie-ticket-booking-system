package exceptions;

public class MovieDoesNotExists extends RuntimeException {

    public MovieDoesNotExists() {
        super("Movie dose not Exists");
    }
}
