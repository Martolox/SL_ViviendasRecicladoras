package org.unrn.exceptions;

public class VisitaIdNotFoundException extends RuntimeException {
    public static final String DESC = "El id indicado no fue encontrado";

    public VisitaIdNotFoundException(String id) {
        super(DESC + ", " + id);
    }

    public VisitaIdNotFoundException() {
        this("");
    }
}
