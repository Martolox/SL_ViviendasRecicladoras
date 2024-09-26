package dtos;

import entities.Campania;

public class CampaniaDto {
    private String duenio;
    private final int puntos;
    private final String beneficios;

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

    @Override
    public String toString() {
        return "Campania{" +
                "duenio='" + duenio + '\'' +
                ", puntos='" + puntos + '\'' +
                ", beneficios='" + beneficios + '\'' +
                '}';
    }
}
