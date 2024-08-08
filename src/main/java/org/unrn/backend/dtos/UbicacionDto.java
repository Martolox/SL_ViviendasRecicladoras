package org.unrn.backend.dtos;

import org.unrn.entities.Ubicacion;

public class UbicacionDto {
    private String idUbicacion;
    private double latitud;
    private double longitud;

    public UbicacionDto(String idUbicacion, double latitud, double longitud) {
        this.idUbicacion = idUbicacion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public UbicacionDto(Ubicacion ubicacion) {
        this.idUbicacion = ubicacion.getIdUbicacion();
        this.latitud = ubicacion.getLatitud();
        this.longitud = ubicacion.getLongitud();
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

    public void setIdUbicacion(String id_ubicacion) {
        this.idUbicacion = idUbicacion;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }


    @Override
    public String toString() {
        return "{Lat='" + latitud + '\'' +
                ", Long='" + longitud + '\'' +
                '}';
    }
}
