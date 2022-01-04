package exceptions;

public class nullStringException extends Throwable {
    public nullStringException(String null_nif) {
        super(null_nif);
    }
}
