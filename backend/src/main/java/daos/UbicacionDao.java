package daos;

import api.Conexion;
import dtos.UbicacionDto;
import entities.Ubicacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UbicacionDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public UbicacionDto listarPorId(String id) throws SQLException {
        UbicacionDto u = null;
        con = cn.getConnection();
        String sql = "SELECT * FROM ubicacion WHERE id_ubicacion = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            u = new UbicacionDto(rs.getString("id_ubicacion"),
                    rs.getDouble("longitud"),
                    rs.getDouble("latitud"));
        }
        cn.getClose();
        return u;
    }

    public List<Ubicacion> listar() throws SQLException {
        List<Ubicacion> lista = new ArrayList<>();
        con = cn.getConnection();
        String sql = "SELECT * FROM ubicacion";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Ubicacion u = new Ubicacion(rs.getString("id_ubicacion"),
                    rs.getDouble("longitud"),
                    rs.getDouble("latitud"));
            lista.add(u);
        }
        cn.getClose();
        return lista;
    }

    public boolean registrar(String id, double latitud, double longitud) throws SQLException {
        String sql = "INSERT INTO ubicacion (id_ubicacion, dni_duenio, longitud, latitud) VALUES (?,?,?,?)";
        con = cn.getConnection();
        boolean res = false;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, id);
            ps.setDouble(3, latitud);
            ps.setDouble(4, longitud);
            ps.execute();
            res = true;
        } finally {
            cn.getClose();
        }
        return res;
    }


}