package dtos;

import entities.Ubicacion;

public class UbicacionDto {
    private final double latitud;
    private final double longitud;

    public UbicacionDto(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public UbicacionDto(Ubicacion ubicacion) {
        this.latitud = ubicacion.getLatitud();
        this.longitud = ubicacion.getLongitud();
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    @Override
    public String toString() {
        return "{Lat='" + latitud + '\'' +
                ", Long='" + longitud + '\'' +
                '}';
    }
}
