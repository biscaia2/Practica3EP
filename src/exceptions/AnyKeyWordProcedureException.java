package exceptions;

public class AnyKeyWordProcedureException extends Exception {
    public AnyKeyWordProcedureException(String invalid_keyword) {
        super(invalid_keyword);
    }
}
