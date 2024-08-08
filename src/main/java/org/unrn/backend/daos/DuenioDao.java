package org.unrn.backend.daos;

import org.unrn.backend.api.Conexion;
import org.unrn.backend.dtos.DuenioDto;
import org.unrn.entities.Duenio;

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

    public DuenioDto listarPorId(String dni) throws SQLException {
        DuenioDto d = null;
        con = cn.getConnection();
        String sql = "SELECT * FROM duenio WHERE dni_duenio = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, dni);
        rs = ps.executeQuery();
        while (rs.next()) {
            d = new DuenioDto(
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
