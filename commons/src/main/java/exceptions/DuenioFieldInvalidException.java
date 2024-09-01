package exceptions;

public class DuenioFieldInvalidException extends RuntimeException {
    public DuenioFieldInvalidException(String id) {
        super(id);
    }

    public DuenioFieldInvalidException() {
        this("");
    }
}
