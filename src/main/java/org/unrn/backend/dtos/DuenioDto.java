package org.unrn.backend.dtos;

import org.unrn.entities.Duenio;

public class DuenioDto {
    private String docDuenio;
    private String nomDuenio;
    private String apeDuenio;
    private String correoDuenio;
    private String telDuenio;
    private String fechaReg;

    public DuenioDto(String docDuenio, String nomDuenio, String apeDuenio) {
        this.docDuenio = docDuenio;
        this.nomDuenio = nomDuenio;
        this.apeDuenio = apeDuenio;
    }

    public DuenioDto(String docDuenio, String nomDuenio, String apeDuenio, String correoDuenio,
                     String telDuenio) {
        this.docDuenio = docDuenio;
        this.nomDuenio = nomDuenio;
        this.apeDuenio = apeDuenio;
        this.correoDuenio = correoDuenio;
        this.telDuenio = telDuenio;
    }

    public DuenioDto(String docDuenio, String nomDuenio, String apeDuenio, String correoDuenio,
                     String telDuenio, String fechaReg) {
        this.docDuenio = docDuenio;
        this.nomDuenio = nomDuenio;
        this.apeDuenio = apeDuenio;
        this.correoDuenio = correoDuenio;
        this.telDuenio = telDuenio;
        this.fechaReg = fechaReg;
    }

    public DuenioDto(Duenio duenio) {
        this.docDuenio = duenio.getDocDuenio();
        this.nomDuenio = duenio.getNomDuenio();
        this.apeDuenio = duenio.getApeDuenio();
        this.correoDuenio = duenio.getCorreoDuenio();
        this.telDuenio = duenio.getTelDuenio();
        this.fechaReg = duenio.getFechaReg();
    }

    public String getNomDuenio() {
        return nomDuenio;
    }

    public String getApeDuenio() {
        return apeDuenio;
    }

    public String getDocDuenio() {
        return docDuenio;
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

    public void setNomDuenio(String nomDuenio) {
        this.nomDuenio = nomDuenio;
    }

    public void setApeDuenio(String apeDuenio) {
        this.apeDuenio = apeDuenio;
    }

    public void setDocDuenio(String docDuenio) {
        this.docDuenio = docDuenio;
    }

    public void setCorreoDuenio(String correoDuenio) {
        this.correoDuenio = correoDuenio;
    }

    public void setTelDuenio(String telDuenio) {
        this.telDuenio = telDuenio;
    }

    @Override
    public String toString() {
        return "Duenio{" +
                "nombre='" + nomDuenio + '\'' +
                ", apellido='" + apeDuenio + '\'' +
                ", DNI='" + docDuenio + '\'' +
                '}';
    }
}
