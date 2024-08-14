package exceptions;

public class DuenioEntityExistsException extends RuntimeException {
    public static final String DESC = "Ya existe un registro con el siguiente documento";

    public DuenioEntityExistsException(String id) {
        super(DESC + ": " + id);
    }

    public DuenioEntityExistsException() {
        this("");
    }
}
