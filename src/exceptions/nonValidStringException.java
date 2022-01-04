package exceptions;

public class nonValidStringException extends Throwable {
    public nonValidStringException(String invalid_nif) {
        super(invalid_nif);
    }
}
