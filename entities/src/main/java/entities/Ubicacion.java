package entities;

public class Ubicacion {
    private String idUbicacion;
    private double latitud;
    private double longitud;

    public Ubicacion(String idUbicacion, double latitud, double longitud) {
        this.idUbicacion = idUbicacion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getIdUbicacion() {
        return idUbicacion;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setIdUbicacion(String idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
