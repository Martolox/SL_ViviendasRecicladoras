package exceptions;

public class IncripcionEntityExistsException extends RuntimeException {
    public static final String DESC = "Ya existe un registro con el siguiente documento";

    public IncripcionEntityExistsException(String id) {
        super(DESC + ": " + id);
    }

    public IncripcionEntityExistsException() {
        this("");
    }
}
