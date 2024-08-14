package controllers;

import daos.OrdenDao;
import daos.VisitaDao;
import dtos.VisitaDto;
import exceptions.OrdenIdNotFoundException;

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
