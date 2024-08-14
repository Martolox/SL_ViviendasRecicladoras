package controllers;

import daos.DuenioDao;
import dtos.DuenioDto;
import entities.Duenio;
import exceptions.DuenioIdNotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControladorDuenio {
    private final DuenioDao duenioDao;

    public ControladorDuenio() {
        duenioDao = new DuenioDao();
    }

    public void eliminar(String dni) throws SQLException {
        if (duenioDao.listarPorId(dni) == null) throw new DuenioIdNotFoundException(dni);
        duenioDao.eliminar(dni);
    }

    public DuenioDto listarPorId(String dni) throws SQLException {
        return duenioDao.listarPorId(dni);
    }

    public List<DuenioDto> listar() throws SQLException {
        List<Duenio> lista = duenioDao.listar();
        List<DuenioDto> listaDto = new ArrayList<>();
        for (Duenio d : lista) {
            listaDto.add(new DuenioDto(d));
        }
        return listaDto;
    }

    public void modificar(String nombre, String apellido, String dni, String correo, String telefono)
            throws SQLException {
//        if (duenioDao.listarPorId(dni) == null) throw new DuenioIdNotFoundException(dni);
        duenioDao.modificar(nombre, apellido, dni, correo, telefono);
    }

    public boolean registrar(String nombre, String apellido, String dni, String correo, String telefono)
            throws SQLException {
        return duenioDao.registrar(nombre, apellido, dni, correo, telefono);
    }
}
