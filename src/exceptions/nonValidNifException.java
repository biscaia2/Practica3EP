package exceptions;

public class nonValidNifException extends Throwable {
    public nonValidNifException(String invalid_nif) {
        super(invalid_nif);
    }
}
