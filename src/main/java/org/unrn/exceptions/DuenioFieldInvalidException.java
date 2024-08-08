package org.unrn.exceptions;

public class DuenioFieldInvalidException extends RuntimeException {
    public static final String DESC = "Campo obligatorio inválido";

    public DuenioFieldInvalidException(String id) {
        super(DESC + ": " + id);
    }

    public DuenioFieldInvalidException() {
        this("");
    }
}
