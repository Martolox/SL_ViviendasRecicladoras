package org.unrn.exceptions;

public class ViviendaIdNotFoundException extends RuntimeException {
    public static final String DESC = "El id indicado no fue encontrado";

    public ViviendaIdNotFoundException(String id) {
        super(DESC + ", " + id);
    }

    public ViviendaIdNotFoundException() {
        this("");
    }
}
