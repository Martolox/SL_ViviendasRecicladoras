package org.unrn.entities;

public class Visita {
    private String idOrden;
    private String fecha;
    private String observacion;

    public Visita(String idOrden, String fecha, String observacion) {
        this.idOrden = idOrden;
        this.fecha = fecha;
        this.observacion = observacion;
    }

    public String getIdOrden() {
        return idOrden;
    }

    public String getFecha() {
        return fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}