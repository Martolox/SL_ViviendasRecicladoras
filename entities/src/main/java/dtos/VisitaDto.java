package dtos;

import entities.Visita;

public class VisitaDto {
    private final String idOrden;
    private String fecha;
    private final String observacion;

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

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
