package dtos;

import entities.Duenio;

public class DuenioDto {
    private final String docDuenio;
    private final String nomDuenio;
    private final String apeDuenio;
    private final String correoDuenio;
    private final String telDuenio;

    public DuenioDto(String docDuenio, String nomDuenio, String apeDuenio, String correoDuenio,
                     String telDuenio, String fechaReg) {
        this.docDuenio = docDuenio;
        this.nomDuenio = nomDuenio;
        this.apeDuenio = apeDuenio;
        this.correoDuenio = correoDuenio;
        this.telDuenio = telDuenio;
    }

    public DuenioDto(Duenio duenio) {
        this.docDuenio = duenio.getDocDuenio();
        this.nomDuenio = duenio.getNomDuenio();
        this.apeDuenio = duenio.getApeDuenio();
        this.correoDuenio = duenio.getCorreoDuenio();
        this.telDuenio = duenio.getTelDuenio();
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

    @Override
    public String toString() {
        return "Duenio{" +
                "nombre='" + nomDuenio + '\'' +
                ", apellido='" + apeDuenio + '\'' +
                ", DNI='" + docDuenio + '\'' +
                '}';
    }
}
