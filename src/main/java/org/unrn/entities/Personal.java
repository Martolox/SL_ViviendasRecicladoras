package org.unrn.entities;

public class Personal {
    private String nomPersonal;
    private String apePersonal;
    private String docPersonal;

    public Personal(String nomPersonal, String apePersonal, String docPersonal) {
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
}
