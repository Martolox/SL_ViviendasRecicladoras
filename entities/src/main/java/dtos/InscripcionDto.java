package dtos;

import entities.Inscripcion;

public class InscripcionDto {
    private int id;
    private String documento;
    private String nombre;
    private String apellido;
    private final String correo;
    private final String telefono;
    private String direccion;
    private String zona;
    private String barrio;
    private final String latitud;
    private final String longitud;
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

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
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