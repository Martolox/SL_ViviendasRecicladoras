package org.unrn.exceptions;

public class PersonalFieldInvalidException extends RuntimeException {
    public static final String DESC = "Campo obligatorio inválido";

    public PersonalFieldInvalidException(String id) {
        super(DESC + ": " + id);
    }

    public PersonalFieldInvalidException() {
        this("");
    }
}
