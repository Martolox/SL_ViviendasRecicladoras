package org.unrn.exceptions;

public class UbicacionEntityExistsException extends RuntimeException {
    public static final String DESC = "Ya existe un registro con el siguiente documento";

    public UbicacionEntityExistsException(String id) {
        super(DESC + ": " + id);
    }

    public UbicacionEntityExistsException() {
        this("");
    }
}
