package org.unrn.exceptions;

public class OrdenIdNotFoundException extends RuntimeException {
    public static final String DESC = "El id indicado no fue encontrado";

    public OrdenIdNotFoundException(int id) {
        super(DESC + ", " + id);
    }

    public OrdenIdNotFoundException() {
    }
}
