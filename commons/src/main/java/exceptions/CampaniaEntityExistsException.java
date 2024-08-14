package exceptions;

public class CampaniaEntityExistsException extends RuntimeException {
    public static final String DESC = "Ya existe un registro con el siguiente documento";

    public CampaniaEntityExistsException(String id) {
        super(DESC + ": " + id);
    }

    public CampaniaEntityExistsException() {
        this("");
    }
}
