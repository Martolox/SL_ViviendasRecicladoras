package exceptions;

public class DuenioIdNotFoundException extends RuntimeException {
    public static final String DESC = "El id indicado no fue encontrado";

    public DuenioIdNotFoundException(String id) {
        label
        super(DESC + ", " + id);
    }

    public DuenioIdNotFoundException() {
        this("");
    }
}
