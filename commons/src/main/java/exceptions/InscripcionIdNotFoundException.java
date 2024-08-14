package exceptions;

public class InscripcionIdNotFoundException extends RuntimeException {
    public static final String DESC = "El id indicado no fue encontrado";

    public InscripcionIdNotFoundException(String id) {
        super(DESC + ", " + id);
    }

    public InscripcionIdNotFoundException() {
        this("");
    }
}
