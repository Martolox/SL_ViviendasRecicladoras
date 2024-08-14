package entities;

public class Orden {
    private int id;
    private String duenio;
    private String personal;
    private String fecha;
    private String estado;
    private float plastico;
    private float papel;
    private float vidrio;
    private float metal;
    private boolean vehiculoPesado;
    private String observacion;
    private String direccion;

    public Orden(int id, String duenio, String personal, String fecha, String estado, float plastico, float papel,
                 float vidrio, float metal, boolean vehiculoPesado, String observacion, String direccion) {
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

    public String getObservacion() {
        return observacion;
    }

    public boolean isVehiculoPesado() {
        return vehiculoPesado;
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

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPlastico(float plastico) {
        this.plastico = plastico;
    }

    public void setPapel(float papel) {
        this.papel = papel;
    }

    public void setVidrio(float vidrio) {
        this.vidrio = vidrio;
    }

    public void setMetal(float metal) {
        this.metal = metal;
    }

    public void setVehiculoPesado(boolean vehiculoPesado) {
        this.vehiculoPesado = vehiculoPesado;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}