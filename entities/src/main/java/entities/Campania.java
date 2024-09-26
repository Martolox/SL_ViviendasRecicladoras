package entities;

public class Campania {
    private String duenio;
    private final int puntos;
    private final String beneficios;

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
}
