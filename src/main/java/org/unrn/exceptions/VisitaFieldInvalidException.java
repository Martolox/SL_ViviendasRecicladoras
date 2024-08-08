package org.unrn.exceptions;

public class VisitaFieldInvalidException extends RuntimeException {
    public static final String DESC = "Campo obligatorio inválido";

    public VisitaFieldInvalidException(String id) {
        super(DESC + ": " + id);
    }

    public VisitaFieldInvalidException() {
        this("");
    }
}
