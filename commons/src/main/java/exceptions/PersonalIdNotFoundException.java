package exceptions;

public class PersonalIdNotFoundException extends RuntimeException {
    public static final String DESC = "El id indicado no fue encontrado";

    public PersonalIdNotFoundException(String id) {
        super(DESC + ", " + id);
    }

    public PersonalIdNotFoundException() {
        this("");
    }
}
