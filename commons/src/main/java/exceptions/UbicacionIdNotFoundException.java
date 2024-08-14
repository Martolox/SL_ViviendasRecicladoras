package exceptions;

public class UbicacionIdNotFoundException extends RuntimeException {
    public static final String DESC = "El id indicado no fue encontrado";

    public UbicacionIdNotFoundException(String id) {
        super(DESC + ", " + id);
    }

    public UbicacionIdNotFoundException() {
        this("");
    }
}
