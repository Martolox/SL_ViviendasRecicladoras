package daos;

import api.Conexion;
import entities.Personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonalDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public void eliminar(String dni) throws SQLException {
        String sql = "DELETE FROM personal WHERE dni_personal = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.execute();
        } finally {
            cn.getClose();
        }
    }

    public Personal listarPorId(String dni) throws SQLException {
        Personal p = null;
        con = cn.getConnection();
        String sql = "SELECT * FROM personal WHERE dni_personal = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, dni);
        rs = ps.executeQuery();
        while (rs.next()) {
            p = new Personal(rs.getString("nom_personal"),
                    rs.getString("ape_personal"),
                    rs.getString("dni_personal"));
        }
        cn.getClose();
        return p;
    }

    public List<Personal> listar() throws SQLException {
        List<Personal> lista = new ArrayList<>();
        con = cn.getConnection();
        String sql = "SELECT * FROM personal ORDER BY ape_personal DESC";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Personal p = new Personal(rs.getString("nom_personal"),
                    rs.getString("ape_personal"),
                    rs.getString("dni_personal"));
            lista.add(p);
        }
        cn.getClose();
        return lista;
    }

    public void modificar(Personal p) throws SQLException {
        String sql = "UPDATE personal SET nom_personal=?, ape_personal=? WHERE dni_personal=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNomPersonal());
            ps.setString(2, p.getApePersonal());
            ps.setString(3, p.getDocPersonal());
            ps.execute();
        } finally {
            cn.getClose();
        }
    }

    public boolean registrar(Personal p) throws SQLException {
        String sql = "INSERT INTO personal VALUES (?,?,?)";
        con = cn.getConnection();
        boolean res = false;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getDocPersonal());
            ps.setString(2, p.getNomPersonal());
            ps.setString(3, p.getApePersonal());
            ps.execute();
            res = true;
        } finally {
            cn.getClose();
        }
        return res;
    }
}