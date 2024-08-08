package org.unrn.backend.dtos;

import org.unrn.entities.Inscripcion;

public class InscripcionDto {
    private int id;
    private String documento;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
    private String zona;
    private String barrio;
    private String latitud;
    private String longitud;
    private String fecha;

    public InscripcionDto(Inscripcion i) {
        this.documento = i.getDocumento();
        this.nombre = i.getNombre();
        this.apellido = i.getApellido();
        this.correo = i.getCorreo();
        this.telefono = i.getTelefono();
        this.direccion = i.getDireccion();
        this.zona = i.getZona();
        this.barrio = i.getBarrio();
        this.latitud = i.getLatitud();
        this.longitud = i.getLongitud();
        this.fecha = i.getFecha();
    }

    public InscripcionDto(String documento, String nombre, String apellido, String correo, String telefono,
                          String direccion, String zona, String barrio, String latitud, String longitud, String fecha) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.zona = zona;
        this.barrio = barrio;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
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

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public String getFecha() {
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String comparacion() {
        return String.format("%s%s%s%s", documento, nombre, apellido, direccion);
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", barrio='" + barrio + '\'' +
                '}';
    }
}