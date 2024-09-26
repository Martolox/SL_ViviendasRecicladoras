package entities;

import exceptions.DuenioFieldInvalidException;

public class Duenio {
    private final String docDuenio;
    private final String nomDuenio;
    private final String apeDuenio;
    private String correoDuenio;
    private String telDuenio;
    private String fechaReg;

    public Duenio(String docDuenio, String nomDuenio, String apeDuenio) {
        this.docDuenio = docDuenio;
        this.nomDuenio = nomDuenio;
        this.apeDuenio = apeDuenio;
        validarCampos();
    }

    public Duenio(String docDuenio, String nomDuenio, String apeDuenio, String correoDuenio, String telDuenio) {
        this.docDuenio = docDuenio;
        this.nomDuenio = nomDuenio;
        this.apeDuenio = apeDuenio;
        this.correoDuenio = correoDuenio;
        this.telDuenio = telDuenio;
        validarCampos();
    }

    public Duenio(String docDuenio, String nomDuenio, String apeDuenio, String correoDuenio,
                  String telDuenio, String fechaReg) {
        this.docDuenio = docDuenio;
        this.nomDuenio = nomDuenio;
        this.apeDuenio = apeDuenio;
        this.correoDuenio = correoDuenio;
        this.telDuenio = telDuenio;
        this.fechaReg = fechaReg;
        validarCampos();
    }

    public String getDocDuenio() {
        return docDuenio;
    }

    public String getNomDuenio() {
        return nomDuenio;
    }

    public String getApeDuenio() {
        return apeDuenio;
    }

    public String getCorreoDuenio() {
        return correoDuenio;
    }

    public String getTelDuenio() {
        return telDuenio;
    }

    public String getFechaReg() {
        return fechaReg;
    }

    private void validarCampos() {
        if (nomDuenio == null || nomDuenio.isEmpty()) throw new DuenioFieldInvalidException("nombre");
        if (apeDuenio == null || apeDuenio.isEmpty()) throw new DuenioFieldInvalidException("apellido");
        if (docDuenio == null || docDuenio.isEmpty() || docDuenio.length() > 8)
            throw new DuenioFieldInvalidException("documento");
        if (!correoDuenio.isEmpty()) if (!correoDuenio.contains("@")) throw new DuenioFieldInvalidException("correo");
        if (telDuenio.length() > 10) throw new DuenioFieldInvalidException("telefono");
        if (!telDuenio.isEmpty()) {
            try {
                Long.parseLong(telDuenio);
            } catch (NumberFormatException e) {
                throw new DuenioFieldInvalidException("Telefono debe ser numérico.");
            }
        }
        try {
            Integer.parseInt(docDuenio);
        } catch (NumberFormatException e) {
            throw new DuenioFieldInvalidException("Documento debe ser numérico.");
        }
    }
}
