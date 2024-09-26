package dtos;

import entities.Orden;

public class OrdenDto {
    private int id;
    private String duenio;
    private String personal;
    private String fecha;
    private final String estado;
    private final float plastico;
    private final float papel;
    private final float vidrio;
    private final float metal;
    private final boolean vehiculoPesado;
    private final String observacion;
    private String direccion;

    public OrdenDto(Orden orden) {
        this.id = orden.getId();
        this.duenio = orden.getDuenio();
        this.personal = orden.getPersonal();
        this.fecha = orden.getFecha();
        this.estado = orden.getEstado();
        this.plastico = orden.getPlastico();
        this.papel = orden.getPapel();
        this.vidrio = orden.getVidrio();
        this.metal = orden.getMetal();
        this.vehiculoPesado = orden.isVehiculoPesado();
        this.observacion = orden.getObservacion();
        this.direccion = orden.getDireccion();
    }

    public OrdenDto(int id, String duenio, String personal, String fecha, String estado, float plastico,
                    float papel, float vidrio, float metal, boolean vehiculoPesado,
                    String observacion, String direccion) {
        this.id = id;
        this.duenio = duenio;
        this.personal = personal;
        this.fecha = fecha;
        this.estado = estado;
        this.plastico = plastico;
        this.papel = papel;
        this.vidrio = vidrio;
        this.metal = metal;
        this.vehiculoPesado = vehiculoPesado;
        this.observacion = observacion;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public String getDuenio() {
        return duenio;
    }

    public String getPersonal() {
        return personal;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public float getPlastico() {
        return plastico;
    }

    public float getPapel() {
        return papel;
    }

    public float getVidrio() {
        return vidrio;
    }

    public float getMetal() {
        return metal;
    }

    public boolean isVehiculoPesado() {
        return vehiculoPesado;
    }

    public String getObservacion() {
        return observacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String comparacion() {
        return String.format("%s%s%s", duenio, estado, observacion);
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id='" + id + '\'' +
                ", duenio='" + duenio + '\'' +
                ", personal='" + personal + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
