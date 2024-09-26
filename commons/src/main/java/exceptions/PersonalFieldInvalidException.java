package exceptions;

public class PersonalFieldInvalidException extends RuntimeException {
    public PersonalFieldInvalidException(String id) {
        super(id);
    }

    public PersonalFieldInvalidException() {
        this("");
    }
}
