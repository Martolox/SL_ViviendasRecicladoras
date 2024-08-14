package exceptions;

public class OrdenFieldInvalidException extends RuntimeException {
    public static final String DESC = "Campo obligatorio inválido";

    public OrdenFieldInvalidException(String id) {
        super(DESC + ": " + id);
    }

    public OrdenFieldInvalidException() {
        this("");
    }
}
