package org.unrn.backend.daos;

import org.unrn.backend.api.Conexion;
import org.unrn.backend.dtos.ViviendaDto;
import org.unrn.entities.Vivienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViviendaDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM vivienda WHERE id_vivienda = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } finally {
            cn.getClose();
        }
    }

    public ViviendaDto listarPorId(String id) throws SQLException {
        ViviendaDto v = null;
        con = cn.getConnection();
        String sql = "SELECT * FROM vivienda WHERE id_vivienda = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            v = new ViviendaDto(rs.getString("id_vivienda"),
                    rs.getString("dni_duenio"),
                    rs.getString("direccion"),
                    rs.getString("zona"),
                    rs.getString("barrio"));
        }
        cn.getClose();
        return v;
    }

    public List<Vivienda> listar() throws SQLException {
        List<Vivienda> lista = new ArrayList<>();
        con = cn.getConnection();
        String sql = "SELECT * FROM vivienda";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Vivienda v = new Vivienda(rs.getString("id_vivienda"),
                    rs.getString("dni_duenio"),
                    rs.getString("direccion"),
                    rs.getString("zona"),
                    rs.getString("barrio"));
            lista.add(v);
        }
        cn.getClose();
        return lista;
    }

    public void modificar(String id, String direccion, String zona, String barrio) throws SQLException {
        String sql = "UPDATE vivienda SET direccion=?, zona=?, barrio=? WHERE id_vivienda=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, direccion);
            ps.setString(2, zona);
            ps.setString(3, barrio);
            ps.setString(4, id);
            ps.execute();
        } finally {
            cn.getClose();
        }
    }

    public boolean registrar(String id, String direccion, String zona, String barrio) throws SQLException {
        String sql = "INSERT INTO vivienda VALUES (?,?,?,?,?)";
        con = cn.getConnection();
        boolean res = false;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, id);
            ps.setString(3, direccion);
            ps.setString(4, zona);
            ps.setString(5, barrio);
            ps.execute();
            res = true;
        } finally {
            cn.getClose();
        }
        return res;
    }
}