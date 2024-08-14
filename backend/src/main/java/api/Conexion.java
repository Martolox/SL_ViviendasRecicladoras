package api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion implements GestorConexion {
    private final String url = "jdbc:mysql://localhost:3306/viviendas_recicladoras";
    private final String user = "root";
    private final String pass = "";

    Connection con;

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
