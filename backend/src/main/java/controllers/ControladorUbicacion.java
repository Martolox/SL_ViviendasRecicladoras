package controllers;

import daos.UbicacionDao;
import dtos.UbicacionDto;
import exceptions.UbicacionEntityExistsException;

import java.sql.SQLException;
import java.util.Random;

public class ControladorUbicacion {
    private final UbicacionDao ubicacionDao;

    public ControladorUbicacion() {
        ubicacionDao = new UbicacionDao();
    }

    public UbicacionDto listarPorId(String id) throws SQLException {
        return ubicacionDao.listarPorId(id);
    }

    public boolean registrar(String id, double latitud, double longitud) throws SQLException {
        if (ubicacionDao.listarPorId(id) != null) throw new UbicacionEntityExistsException(id);
        return ubicacionDao.registrar(id, latitud, longitud);
    }

    public UbicacionDto validar(String direccion) {
//        TODO Agregar GeoDecoder;
        Random randomNumbers = new Random();
        double latitud = -40.810376207395485 + randomNumbers.nextFloat() * 0.1;
        double longitud = -63.006517432922706 + randomNumbers.nextFloat() * 0.1;
        return new UbicacionDto("", latitud, longitud);
    }
}
