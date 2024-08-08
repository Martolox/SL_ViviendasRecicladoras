package org.unrn.backend.controllers;

import org.unrn.backend.daos.OrdenDao;
import org.unrn.backend.daos.VisitaDao;
import org.unrn.backend.dtos.VisitaDto;
import org.unrn.exceptions.OrdenIdNotFoundException;

import java.sql.SQLException;
import java.util.List;

public class ControladorVisita {
    private final VisitaDao visitaDao;
    private final OrdenDao ordenDao;


    public ControladorVisita() {
        visitaDao = new VisitaDao();
        ordenDao = new OrdenDao();
    }

    public List<VisitaDto> listarPorId(String id) throws SQLException {
        return visitaDao.listarPorId(id);
    }

    public boolean registrar(int id, String estado, String observacion) throws SQLException {
        if (ordenDao.listarPorId(id) == null)
            throw new OrdenIdNotFoundException(id);
        ordenDao.modificar(id, estado);
        return visitaDao.registrar(id, observacion);
    }
}
