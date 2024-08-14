package dtos;

import entities.Visita;

public class VisitaDto {
    private String idOrden;
    private String fecha;
    private String observacion;

    public VisitaDto(String idOrden, String fecha, String observacion) {
        this.idOrden = idOrden;
        this.fecha = fecha;
        this.observacion = observacion;
    }

    public VisitaDto(Visita visita) {
        this.idOrden = visita.getIdOrden();
        this.fecha = visita.getFecha();
        this.observacion = visita.getObservacion();
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

    @Override
    public String toString() {
        return "Visita{" +
                "id='" + idOrden + '\'' +
                ", fecha='" + fecha + '\'' +
                ", observacion='" + observacion + '\'' +
                '}';
    }
}
