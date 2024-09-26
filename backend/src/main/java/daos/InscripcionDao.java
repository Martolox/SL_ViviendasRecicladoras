package daos;

import api.Conexion;
import entities.Duenio;
import entities.Inscripcion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InscripcionDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public Duenio listarPorId(String dni) throws SQLException {
        Duenio d = null;
        con = cn.getConnection();
        String sql = "SELECT * FROM duenio WHERE dni_duenio = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, dni);
        rs = ps.executeQuery();
        while (rs.next()) {
            d = new Duenio(
                    rs.getString("dni_duenio"),
                    rs.getString("nom_duenio"),
                    rs.getString("ape_duenio"),
                    rs.getString("correo"),
                    rs.getString("telefono"),
                    rs.getString("fecha"));
        }
        cn.getClose();
        return d;
    }

    public List<Inscripcion> listar() throws SQLException {
        List<Inscripcion> lista = new ArrayList<>();
        con = cn.getConnection();
        String sql = "SELECT * FROM duenio\n" +
                "INNER JOIN vivienda ON vivienda.dni_duenio=duenio.dni_duenio\n" +
                "INNER JOIN ubicacion ON ubicacion.dni_duenio=duenio.dni_duenio ORDER BY fecha ASC";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Inscripcion ins = new Inscripcion(
                    rs.getString("dni_duenio"),
                    rs.getString("nom_duenio"),
                    rs.getString("ape_duenio"),
                    rs.getString("correo"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getString("zona"),
                    rs.getString("barrio"),
                    rs.getString("longitud"),
                    rs.getString("latitud"),
                    rs.getString("fecha"));
            lista.add(ins);
        }
        cn.getClose();
        return lista;
    }

    public void modificar(String nombre, String apellido, String dni, String correo, String telefono) throws SQLException {
        String sql = "UPDATE duenio SET nom_duenio=?, ape_duenio=?, correo=?, telefono=? WHERE dni_duenio=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, correo);
            ps.setString(4, telefono);
            ps.setString(5, dni);
            ps.execute();
        } finally {
            cn.getClose();
        }
    }

    public boolean registrar(String nombre, String apellido, String dni, String correo, String telefono) throws SQLException {
        String sql = "INSERT INTO duenio (dni_duenio, nom_duenio, ape_duenio, correo, " +
                "telefono) VALUES (?,?,?,?,?)";
        con = cn.getConnection();
        boolean res = false;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, correo);
            ps.setString(5, telefono);
            ps.execute();
            res = true;
        } finally {
            cn.getClose();
        }
        return res;
    }
}
