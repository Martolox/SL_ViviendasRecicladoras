package exceptions;

public class UbicacionFieldInvalidException extends RuntimeException {
    public static final String DESC = "Campo obligatorio inválido";

    public UbicacionFieldInvalidException(String id) {
        super(DESC + ": " + id);
    }

    public UbicacionFieldInvalidException() {
        this("");
    }
}
