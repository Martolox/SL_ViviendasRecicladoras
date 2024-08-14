package dtos;

import entities.Personal;

public class PersonalDto {
    private String nomPersonal;
    private String apePersonal;
    private String docPersonal;

    public PersonalDto(Personal personal) {
        this.nomPersonal = personal.getNomPersonal();
        this.apePersonal = personal.getApePersonal();
        this.docPersonal = personal.getDocPersonal();
    }

    public PersonalDto(String nomPersonal, String apePersonal, String docPersonal) {
        this.nomPersonal = nomPersonal;
        this.apePersonal = apePersonal;
        this.docPersonal = docPersonal;
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

    public void setNomPersonal(String nomPersonal) {
        this.nomPersonal = nomPersonal;
    }

    public void setApePersonal(String apePersonal) {
        this.apePersonal = apePersonal;
    }

    public void setDocPersonal(String docPersonal) {
        this.docPersonal = docPersonal;
    }

    public String comparacion() {
        return String.format("%s%s%s", nomPersonal, apePersonal, docPersonal);
    }

    @Override
    public String toString() {
        return "Personal{" +
                "nombre='" + nomPersonal + '\'' +
                ", apellido='" + apePersonal + '\'' +
                ", DNI='" + docPersonal + '\'' +
                '}';
    }
}
