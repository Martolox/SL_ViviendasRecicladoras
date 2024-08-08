package org.unrn.backend.daos;

import org.unrn.backend.api.Conexion;
import org.unrn.backend.dtos.VisitaDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VisitaDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public List<VisitaDto> listarPorId(String id) throws SQLException {
        List<VisitaDto> lista = new ArrayList<>();
        con = cn.getConnection();
        String sql = "SELECT * FROM visita WHERE id_orden = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            VisitaDto v = new VisitaDto(rs.getString("id_orden"),
                    rs.getString("fecha_visita"),
                    rs.getString("obs_visita"));
            lista.add(v);
        }
        cn.getClose();
        return lista;
    }

    public boolean registrar(int orden, String observacion) throws SQLException {
        String sql = "INSERT INTO visita (id_orden, obs_visita) VALUES (?,?)";
        con = cn.getConnection();
        boolean res = false;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, orden);
            ps.setString(2, observacion);
            ps.execute();
            res = true;
        } finally {
            cn.getClose();
        }
        return res;
    }
}