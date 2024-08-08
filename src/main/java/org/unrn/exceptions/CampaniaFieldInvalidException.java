package org.unrn.exceptions;

public class CampaniaFieldInvalidException extends RuntimeException {
    public static final String DESC = "Campo obligatorio inválido";

    public CampaniaFieldInvalidException(String id) {
        super(DESC + ": " + id);
    }

    public CampaniaFieldInvalidException() {
        this("");
    }
}
