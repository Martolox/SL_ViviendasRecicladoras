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
        return new DuenioDto(duenioDao.listarPorId(dni));
    }

    public List<DuenioDto> listar() throws SQLException {
        List<Duenio> lista = duenioDao.listar();
        List<DuenioDto> listaDto = new ArrayList<>();
        for (Duenio d : lista) {
            listaDto.add(new DuenioDto(d));
        }
        return listaDto;
    }

    public boolean registrar(Duenio d) throws SQLException {
        return duenioDao.registrar(d);
    }
}
