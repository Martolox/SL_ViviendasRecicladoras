package daos;

import api.Conexion;
import dtos.PersonalDto;
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

    public PersonalDto listarPorId(String dni) throws SQLException {
        PersonalDto p = null;
        con = cn.getConnection();
        String sql = "SELECT * FROM personal WHERE dni_personal = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, dni);
        rs = ps.executeQuery();
        while (rs.next()) {
            p = new PersonalDto(rs.getString("nom_personal"),
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

    public void modificar(String nombre, String apellido, String dni) throws SQLException {
        String sql = "UPDATE personal SET nom_personal=?, ape_personal=? WHERE dni_personal=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, dni);
            ps.execute();
        } finally {
            cn.getClose();
        }
    }

    public boolean registrar(String nombre, String apellido, String dni) throws SQLException {
        String sql = "INSERT INTO personal VALUES (?,?,?)";
        con = cn.getConnection();
        boolean res = false;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.execute();
            res = true;
        } finally {
            cn.getClose();
        }
        return res;
    }
}