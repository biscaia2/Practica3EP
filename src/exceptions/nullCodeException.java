package exceptions;

public class nullCodeException extends Throwable {
    public nullCodeException(String null_nif) {
        super(null_nif);
    }
}
