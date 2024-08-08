package org.unrn.entities;

public class Campania {
    private String duenio;
    private int puntos;
    private String beneficios;

    public Campania(String duenio, int puntos, String beneficios) {
        this.duenio = duenio;
        this.puntos = puntos;
        this.beneficios = beneficios;
    }

    public String getDuenio() {
        return duenio;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }
}
