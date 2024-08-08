package org.unrn.exceptions;

public class InscripcionFieldInvalidException extends RuntimeException {
    public static final String DESC = "Campo obligatorio inválido";

    public InscripcionFieldInvalidException(String id) {
        super(DESC + ": " + id);
    }

    public InscripcionFieldInvalidException() {
        this("");
    }
}
