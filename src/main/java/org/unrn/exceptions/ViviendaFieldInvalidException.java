package org.unrn.exceptions;

public class ViviendaFieldInvalidException extends RuntimeException {
    public static final String DESC = "Campo obligatorio inválido";

    public ViviendaFieldInvalidException(String id) {
        super(DESC + ": " + id);
    }

    public ViviendaFieldInvalidException() {
        this("");
    }
}
