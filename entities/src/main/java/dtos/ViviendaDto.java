package dtos;

import entities.Vivienda;

public class ViviendaDto {
    private String id;
    private String documento;
    private String direccion;
    private String zona;
    private String barrio;

    public ViviendaDto(String id, String documento, String direccion, String zona, String barrio) {
        this.id = id;
        this.documento = documento;
        this.direccion = direccion;
        this.zona = zona;
        this.barrio = barrio;
    }

    public ViviendaDto(Vivienda vivienda) {
        this.id = vivienda.getId();
        this.documento = vivienda.getDocumento();
        this.direccion = vivienda.getDireccion();
        this.zona = vivienda.getZona();
        this.barrio = vivienda.getBarrio();
    }

    public String getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getZona() {
        return zona;
    }

    public String getBarrio() {
        return barrio;
    }

    public String getDocumento() {
        return documento;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "Vivienda{" +
                "id='" + id + '\'' +
                ", documento='" + documento + '\'' +
                ", direccion='" + direccion + '\'' +
                ", barrio='" + barrio + '\'' +
                '}';
    }
}
