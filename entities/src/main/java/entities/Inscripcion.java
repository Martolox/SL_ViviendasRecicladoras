package entities;

import exceptions.InscripcionFieldInvalidException;

public class Inscripcion {
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

    public Inscripcion(String documento, String nombre, String apellido, String correo, String telefono,
                       String direccion, String zona, String barrio) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.zona = zona;
        this.barrio = barrio;
        validarCampos();
    }

    public Inscripcion(String documento, String nombre, String apellido, String correo, String telefono,
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
        validarCampos();
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

    private void validarCampos() {
        if (documento == null || documento.isEmpty() || documento.length() > 8) {
            throw new InscripcionFieldInvalidException("documento");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new InscripcionFieldInvalidException("nombre");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new InscripcionFieldInvalidException("apellido");
        }
        if (!correo.isEmpty()) {
            if (!correo.contains("@")) throw new InscripcionFieldInvalidException("correo");
        }
        if (telefono.length() > 10) {
            throw new InscripcionFieldInvalidException("telefono");
        }
        if (direccion == null || direccion.isEmpty()) {
            throw new InscripcionFieldInvalidException("direccion");
        }
        if (barrio == null || barrio.isEmpty()) {
            throw new InscripcionFieldInvalidException("apellido");
        }
        if (!telefono.isEmpty()) {
            Long.parseLong(telefono);
        }
        Integer.parseInt(documento);
    }
}
