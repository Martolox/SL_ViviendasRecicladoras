package entities;

import exceptions.PersonalFieldInvalidException;

public class Personal {
    private final String nomPersonal;
    private final String apePersonal;
    private final String docPersonal;

    public Personal(String nomPersonal, String apePersonal, String docPersonal) {
        this.nomPersonal = nomPersonal;
        this.apePersonal = apePersonal;
        this.docPersonal = docPersonal;
        validarCampos();
    }

    public String getNomPersonal() {
        return nomPersonal;
    }

    public String getApePersonal() {
        return apePersonal;
    }

    public String getDocPersonal() {
        return docPersonal;
    }

    private void validarCampos() {
        if (nomPersonal == null || nomPersonal.isEmpty()) {
            throw new PersonalFieldInvalidException("nombre");
        }
        if (apePersonal == null || apePersonal.isEmpty()) {
            throw new PersonalFieldInvalidException("apellido");
        }
        if (docPersonal == null || docPersonal.isEmpty() || docPersonal.length() > 8) {
            throw new PersonalFieldInvalidException("documento");
        }
        try {
            Integer.parseInt(docPersonal);
        } catch (NumberFormatException e) {
            throw new PersonalFieldInvalidException("documento debe ser numérico");
        }
    }
}
