package controllers;

import daos.DuenioDao;
import daos.ViviendaDao;
import dtos.ViviendaDto;
import entities.Vivienda;
import exceptions.DuenioIdNotFoundException;
import exceptions.ViviendaIdNotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControladorVivienda {
    private final ViviendaDao viviendaDao;
    private final DuenioDao duenioDao;

    public ControladorVivienda() {
        viviendaDao = new ViviendaDao();
        duenioDao = new DuenioDao();
    }

    public void eliminar(String id) throws SQLException {
        if (viviendaDao.listarPorId(id) == null) throw new ViviendaIdNotFoundException(id);
        viviendaDao.eliminar(id);
    }

    public ViviendaDto listarPorId(String id) throws SQLException {
        return viviendaDao.listarPorId(id);
    }

    public List<ViviendaDto> listar() throws SQLException {
        List<Vivienda> lista = viviendaDao.listar();
        List<ViviendaDto> listaDto = new ArrayList<>();
        for (Vivienda v : lista) {
            listaDto.add(new ViviendaDto(v));
        }
        return listaDto;
    }

    public void modificar(String id, String direccion, String zona, String barrio) throws SQLException {
        if (viviendaDao.listarPorId(id) == null) throw new ViviendaIdNotFoundException(id);
        viviendaDao.modificar(id, direccion, zona, barrio);
    }

    public boolean registrar(String id, String direccion, String zona, String barrio) throws SQLException {
        if (duenioDao.listarPorId(id) == null) throw new DuenioIdNotFoundException(id);
        return viviendaDao.registrar(id, direccion, zona, barrio);
    }
}
