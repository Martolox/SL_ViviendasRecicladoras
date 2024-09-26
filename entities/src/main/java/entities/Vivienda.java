package entities;

import exceptions.ViviendaFieldInvalidException;

public class Vivienda {
    private String id;
    private String documento;
    private String direccion;
    private String zona;
    private String barrio;

    public Vivienda(String id, String direccion, String zona, String barrio) {
        this.id = id;
        this.direccion = direccion;
        this.zona = zona;
        this.barrio = barrio;
        validarCampos();
    }

    public Vivienda(String id, String documento, String direccion, String zona, String barrio) {
        this.id = id;
        this.documento = documento;
        this.direccion = direccion;
        this.zona = zona;
        this.barrio = barrio;
        validarCampos();
    }

    public String getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    private void validarCampos() {
        if (id == null || id.isEmpty() || id.length() > 8) {
            throw new ViviendaFieldInvalidException("id");
        }
        if (direccion == null || direccion.isEmpty()) {
            throw new ViviendaFieldInvalidException("direccion");
        }
        if (barrio == null || barrio.isEmpty()) {
            throw new ViviendaFieldInvalidException("barrio");
        }
        Integer.parseInt(id);
    }
}