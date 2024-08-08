package org.unrn.exceptions;

public class OrdenEntityExistsException extends RuntimeException {
    public static final String DESC = "Ya existe un registro con el siguiente documento";

    public OrdenEntityExistsException(String id) {
        super(DESC + ": " + id);
    }

    public OrdenEntityExistsException() {
        this("");
    }
}
