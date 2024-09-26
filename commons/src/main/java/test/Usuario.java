package test;

public class Usuario {
    private String id;
    private String pass;
    private String documento;

    public Usuario(String id, String pass, String documento) {
        this.id = id;
        this.pass = pass;
        this.documento = documento;
    }

    public String getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public String getDocumento() {
        return documento;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

}
