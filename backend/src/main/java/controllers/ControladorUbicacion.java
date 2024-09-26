package controllers;

import daos.UbicacionDao;
import dtos.UbicacionDto;
import entities.Ubicacion;
import exceptions.UbicacionEntityExistsException;

import java.sql.SQLException;
import java.util.Random;

public class ControladorUbicacion {
    private final UbicacionDao ubicacionDao;

    public ControladorUbicacion() {
        ubicacionDao = new UbicacionDao();
    }

    public UbicacionDto listarPorId(String id) throws SQLException {
        return new UbicacionDto(ubicacionDao.listarPorId(id));
    }

    public boolean registrar(Ubicacion u) throws SQLException {
        if (ubicacionDao.listarPorId(u.getIdUbicacion()) != null)
            throw new UbicacionEntityExistsException(u.getIdUbicacion());
        return ubicacionDao.registrar(u);
    }

    public UbicacionDto validar(String direccion) {
//        TODO Agregar GeoDecoder;
        Random randomNumbers = new Random();
        double latitud = -40.810376207395485 + randomNumbers.nextFloat() * 0.1;
        double longitud = -63.006517432922706 + randomNumbers.nextFloat() * 0.1;
        return new UbicacionDto(latitud, longitud);
    }
}
