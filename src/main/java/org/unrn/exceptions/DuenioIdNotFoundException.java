package org.unrn.exceptions;

public class DuenioIdNotFoundException extends RuntimeException {
    public static final String DESC = "El id indicado no fue encontrado";

    public DuenioIdNotFoundException(String id) {
        super(DESC + ", " + id);
    }

    public DuenioIdNotFoundException() {
        this("");
    }
}
