package org.unrn.exceptions;

public class CampaniaIdNotFoundException extends RuntimeException {
    public static final String DESC = "El id indicado no fue encontrado";

    public CampaniaIdNotFoundException(String id) {
        super(DESC + ", " + id);
    }

    public CampaniaIdNotFoundException() {
        this("");
    }
}
