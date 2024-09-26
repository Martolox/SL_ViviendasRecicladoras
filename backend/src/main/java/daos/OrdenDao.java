package daos;

import api.Conexion;
import entities.Orden;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdenDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM orden WHERE id_orden = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } finally {
            cn.getClose();
        }
    }

    public Orden listarPorId(int id) throws SQLException {
        Orden o = null;
        con = cn.getConnection();
        String sql = "SELECT o.id_orden, o.dni_duenio, o.dni_personal, o.fecha, o.estado, o.plastico, " +
                "o.papel, o.vidrio, o.metal, o.vehiculo_pesado, o.obs_orden, vivienda.direccion " +
                "FROM orden AS o, vivienda WHERE o.id_orden = ?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            o = new Orden(rs.getInt("id_orden"),
                    rs.getString("dni_duenio"),
                    rs.getString("dni_personal"),
                    rs.getString("fecha"),
                    rs.getString("estado"),
                    rs.getFloat("plastico"),
                    rs.getFloat("papel"),
                    rs.getFloat("vidrio"),
                    rs.getFloat("metal"),
                    rs.getBoolean("vehiculo_pesado"),
                    rs.getString("obs_orden"),
                    rs.getString("direccion"));
        }
        cn.getClose();
        return o;
    }

    public List<Orden> listar() throws SQLException {
        List<Orden> lista = new ArrayList<>();
        con = cn.getConnection();
        String sql = "SELECT o.id_orden, o.dni_duenio, o.dni_personal, o.fecha, o.estado, o.plastico, " +
                "o.papel, o.vidrio, o.metal, o.vehiculo_pesado, o.obs_orden, vivienda.direccion " +
                "FROM orden AS o, vivienda WHERE o.dni_duenio=vivienda.dni_duenio ORDER BY o.id_orden ASC";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Orden o = new Orden(rs.getInt("id_orden"),
                    rs.getString("dni_duenio"),
                    rs.getString("dni_personal"),
                    rs.getString("fecha"),
                    rs.getString("estado"),
                    rs.getFloat("plastico"),
                    rs.getFloat("papel"),
                    rs.getFloat("vidrio"),
                    rs.getFloat("metal"),
                    rs.getBoolean("vehiculo_pesado"),
                    rs.getString("obs_orden"),
                    rs.getString("direccion"));
            lista.add(o);
        }
        cn.getClose();
        return lista;
    }

    public void modificar(int id, String estado)
            throws SQLException {
        String sql = "UPDATE orden SET estado=? WHERE id_orden=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, id);
            ps.execute();
        } finally {
            cn.getClose();
        }
    }

    public void modificar(int id, String duenio, String personal, String estado, float plastico,
                          float papel, float vidrio, float metal, boolean vehiculoPesado, String observacion)
            throws SQLException {
        String sql = "UPDATE orden SET dni_duenio=?, dni_personal=?, estado=?, plastico=?," +
                " papel=?, vidrio=?, metal=?, vehiculo_pesado=?, obs_orden=? WHERE id_orden=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, duenio);
            ps.setString(2, personal);
            ps.setString(3, estado);
            ps.setFloat(4, plastico);
            ps.setFloat(5, papel);
            ps.setFloat(6, vidrio);
            ps.setFloat(7, metal);
            ps.setBoolean(8, vehiculoPesado);
            ps.setString(9, observacion);
            ps.setInt(10, id);
            ps.execute();
        } finally {
            cn.getClose();
        }
    }

    public boolean registrar(Orden o)
            throws SQLException {
        String sql = "INSERT INTO orden (`dni_duenio`, `dni_personal`, `estado`, `plastico`, `papel`, `vidrio`," +
                " `metal`, `vehiculo_pesado`, `obs_orden`) VALUES (?,?,?,?,?,?,?,?,?)";
        con = cn.getConnection();
        boolean res = false;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, o.getDuenio());
            ps.setString(2, o.getPersonal());
            ps.setString(3, o.getEstado());
            ps.setFloat(4, o.getPlastico());
            ps.setFloat(5, o.getPapel());
            ps.setFloat(6, o.getVidrio());
            ps.setFloat(7, o.getMetal());
            ps.setBoolean(8, o.isVehiculoPesado());
            ps.setString(9, o.getObservacion());
            ps.execute();
            res = true;
        } finally {
            cn.getClose();
        }
        return res;
    }
}