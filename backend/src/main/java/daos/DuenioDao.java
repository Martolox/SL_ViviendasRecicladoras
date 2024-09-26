package daos;

import api.Conexion;
import entities.Duenio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DuenioDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public void eliminar(String dni) throws SQLException {
        String sql = "DELETE FROM duenio WHERE dni_duenio = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.execute();
        } finally {
            cn.getClose();
        }
    }

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

    public List<Duenio> listar() throws SQLException {
        List<Duenio> lista = new ArrayList<>();
        con = cn.getConnection();
        String sql = "SELECT * FROM duenio ORDER BY telefono DESC";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Duenio d = new Duenio(
                    rs.getString("dni_duenio"),
                    rs.getString("nom_duenio"),
                    rs.getString("ape_duenio"),
                    rs.getString("correo"),
                    rs.getString("telefono"),
                    rs.getString("fecha"));
            lista.add(d);
        }
        cn.getClose();
        return lista;
    }

    public void modificar(Duenio d) throws SQLException {
        String sql = "UPDATE duenio SET nom_duenio=?, ape_duenio=?, correo=?, telefono=? WHERE dni_duenio=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, d.getNomDuenio());
            ps.setString(2, d.getApeDuenio());
            ps.setString(3, d.getCorreoDuenio());
            ps.setString(4, d.getTelDuenio());
            ps.setString(5, d.getDocDuenio());
            ps.execute();
        } finally {
            cn.getClose();
        }
    }

    public boolean registrar(Duenio d) throws SQLException {
        String sql = "INSERT INTO duenio (dni_duenio, nom_duenio, ape_duenio, correo, " +
                "telefono) VALUES (?,?,?,?,?)";
        con = cn.getConnection();
        boolean res = false;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, d.getDocDuenio());
            ps.setString(2, d.getNomDuenio());
            ps.setString(3, d.getApeDuenio());
            ps.setString(4, d.getCorreoDuenio());
            ps.setString(5, d.getTelDuenio());
            ps.execute();
            res = true;
        } finally {
            cn.getClose();
        }
        return res;
    }
}
