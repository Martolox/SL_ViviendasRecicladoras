package org.unrn.backend.dtos;

import org.unrn.entities.Campania;

public class CampaniaDto {
    private String duenio;
    private int puntos;
    private String beneficios;

    public CampaniaDto(Campania campania) {
        this.duenio = campania.getDuenio();
        this.puntos = campania.getPuntos();
        this.beneficios = campania.getBeneficios();
    }

    public CampaniaDto(String duenio, int puntos, String beneficios) {
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

    @Override
    public String toString() {
        return "Campania{" +
                "duenio='" + duenio + '\'' +
                ", puntos='" + puntos + '\'' +
                ", beneficios='" + beneficios + '\'' +
                '}';
    }
}
