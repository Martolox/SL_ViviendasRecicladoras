package org.unrn.exceptions;

public class PersonalEntityExistsException extends RuntimeException {
    public static final String DESC = "Ya existe un registro con el siguiente documento";

    public PersonalEntityExistsException(String id) {
        super(DESC + ": " + id);
    }

    public PersonalEntityExistsException() {
        this("");
    }
}
