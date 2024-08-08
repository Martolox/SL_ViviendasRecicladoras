package org.unrn.entities;

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
    }

    public Duenio(String docDuenio, String nomDuenio, String apeDuenio, String correoDuenio, String telDuenio) {
        this.docDuenio = docDuenio;
        this.nomDuenio = nomDuenio;
        this.apeDuenio = apeDuenio;
        this.correoDuenio = correoDuenio;
        this.telDuenio = telDuenio;
    }

    public Duenio(String docDuenio, String nomDuenio, String apeDuenio, String correoDuenio,
                  String telDuenio, String fechaReg) {
        this.docDuenio = docDuenio;
        this.nomDuenio = nomDuenio;
        this.apeDuenio = apeDuenio;
        this.correoDuenio = correoDuenio;
        this.telDuenio = telDuenio;
        this.fechaReg = fechaReg;
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
}
