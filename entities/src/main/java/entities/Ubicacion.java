package entities;

import exceptions.UbicacionFieldInvalidException;

public class Ubicacion {
    private final String idUbicacion;
    private double latitud;
    private double longitud;

    public Ubicacion(String idUbicacion, double latitud, double longitud) {
        this.idUbicacion = idUbicacion;
        this.latitud = latitud;
        this.longitud = longitud;
        validarCampos();
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

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    private void validarCampos() {
        if (idUbicacion == null || idUbicacion.isEmpty() || idUbicacion.length() > 8) {
            throw new UbicacionFieldInvalidException("id");
        }
        if (Double.isNaN(latitud)) {
            throw new UbicacionFieldInvalidException("latitud");
        }
        if (Double.isNaN(longitud)) {
            throw new UbicacionFieldInvalidException("longitud");
        }
    }
}
