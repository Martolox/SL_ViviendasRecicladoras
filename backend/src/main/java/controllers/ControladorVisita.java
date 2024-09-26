package controllers;

import daos.OrdenDao;
import daos.VisitaDao;
import dtos.VisitaDto;
import entities.Orden;
import entities.Visita;
import exceptions.OrdenIdNotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControladorVisita {
    private final VisitaDao visitaDao;
    private final OrdenDao ordenDao;


    public ControladorVisita() {
        visitaDao = new VisitaDao();
        ordenDao = new OrdenDao();
    }

    public List<VisitaDto> listarPorId(String id) throws SQLException {
        List<Visita> lista = visitaDao.listarPorId(id);
        List<VisitaDto> listaDto = new ArrayList<>();
        for (Visita v : lista) {
            listaDto.add(new VisitaDto(v));
        }
        return listaDto;
    }

    public boolean registrar(Orden o) throws SQLException {
        if (ordenDao.listarPorId(o.getId()) == null)
            throw new OrdenIdNotFoundException(o.getId());
        ordenDao.modificar(o.getId(), o.getEstado());
        return visitaDao.registrar(o.getId(), o.getObservacion());
    }
}
