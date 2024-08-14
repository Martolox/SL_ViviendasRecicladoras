package entities;

public class Respuesta {
    private String estado;
    private Object obj;

    public Respuesta(String estado, Object obj) {
        this.estado = estado;
        this.obj = obj;
    }

    public Respuesta(String estado) {
        this.estado = estado;
        obj = null;
    }

    public Object getObj() {
        return obj;
    }

    public String getEstado() {
        return estado;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "estado='" + estado + '\'' +
                ", Objeto='" + obj + '\'' +
                '}';
    }
}
