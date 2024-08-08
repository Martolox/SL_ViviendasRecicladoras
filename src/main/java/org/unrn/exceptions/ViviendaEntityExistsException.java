package org.unrn.exceptions;

public class ViviendaEntityExistsException extends RuntimeException {
    public static final String DESC = "Ya existe un registro con el siguiente id";

    public ViviendaEntityExistsException(String id) {
        super(DESC + ": " + id);
    }

    public ViviendaEntityExistsException() {
        this("");
    }
}
