package org.unrn.backend.daos;

import org.unrn.backend.api.Conexion;
import org.unrn.backend.dtos.CampaniaDto;
import org.unrn.entities.Campania;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CampaniaDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM campania WHERE id_campania = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } finally {
            cn.getClose();
        }
    }

    public CampaniaDto listarPorId(String id) throws SQLException {
        CampaniaDto c = null;
        con = cn.getConnection();
        String sql = "SELECT * FROM campania WHERE id_campania = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            c = new CampaniaDto(rs.getString("dni_duenio"),
                    rs.getInt("puntos"),
                    rs.getString("benef_activos"));
        }
        cn.getClose();
        return c;
    }

    public List<Campania> listar() throws SQLException {
        List<Campania> lista = new ArrayList<>();
        con = cn.getConnection();
        String sql = "SELECT * FROM campania";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Campania c = new Campania(rs.getString("dni_duenio"),
                    rs.getInt("puntos"),
                    rs.getString("benef_activos"));
            lista.add(c);
        }
        cn.getClose();
        return lista;
    }

    public void modificar(String id, int puntos, String beneficios) throws SQLException {
        String sql = "UPDATE campania SET dni_duenio=?, puntos=?, benef_activos=? WHERE id_campania=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setInt(2, puntos);
            ps.setString(3, beneficios);
            ps.setString(4, id);
            ps.execute();
        } finally {
            cn.getClose();
        }
    }

    public boolean registrar(String id, int puntos, String beneficios) throws SQLException {
        String sql = "INSERT INTO campania VALUES (?,?,?,?)";
        con = cn.getConnection();
        boolean res = false;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, id);
            ps.setInt(3, puntos);
            ps.setString(4, beneficios);
            ps.execute();
            res = true;
        } finally {
            cn.getClose();
        }
        return res;
    }
}