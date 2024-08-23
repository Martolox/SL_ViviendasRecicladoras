package api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion implements GestorConexion {
    private final String url = "jdbc:mysql://localhost:3306/viviendas_recicladoras";
    private final String user = "root";
    private final String pass = "";
//    private final String url;
//    private final String user;
//    private final String pass;

    Connection con;

//    public Conexion() {
//        ResourceBundle database = ResourceBundle.getBundle("database");
//        System.out.println(database.getString("db.url"));
//        url = database.getString("db.url");
//        user = database.getString("db.user");
//        pass = database.getString("db.pass");
//    }

    public Connection getConnection() throws SQLException {
        con = DriverManager.getConnection(url, user, pass);
//        System.out.println("Conexion abierta");
        return con;
    }

    public void getClose() throws SQLException {
//        System.out.println("Conexion cerrada");
        con.close();
    }
}
