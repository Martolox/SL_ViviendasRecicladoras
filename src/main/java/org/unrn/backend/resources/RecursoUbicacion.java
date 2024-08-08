package org.unrn.backend.resources;

import org.unrn.backend.controllers.ControladorDuenio;
import org.unrn.backend.controllers.ControladorUbicacion;
import org.unrn.backend.dtos.UbicacionDto;
import org.unrn.entities.Coordenada;
import org.unrn.exceptions.DuenioIdNotFoundException;
import org.unrn.exceptions.UbicacionEntityExistsException;
import org.unrn.exceptions.UbicacionFieldInvalidException;
import org.unrn.exceptions.UbicacionIdNotFoundException;

import java.sql.SQLException;
import java.util.Optional;

public class RecursoUbicacion {

    public UbicacionDto listarPorId(String id) throws UbicacionIdNotFoundException, SQLException {
        Optional<UbicacionDto> optional = Optional.ofNullable(new ControladorUbicacion().listarPorId(id));
        return optional.orElseThrow(UbicacionIdNotFoundException::new);
    }

    public void registrar(String id, double latitud, double longitud)
            throws UbicacionFieldInvalidException, UbicacionEntityExistsException, SQLException {
        validarCampos(id, latitud, longitud);
        if (!new ControladorUbicacion().registrar(id, latitud, longitud)) {
            throw new UbicacionEntityExistsException();
        }
    }

    public Coordenada validar(String id, String direccion, String barrio) throws SQLException {
        validarCamposDireccion(direccion, barrio);
        if (new ControladorDuenio().listarPorId(id) == null) throw new DuenioIdNotFoundException();
        return new ControladorUbicacion().validar(direccion);
    }


    private void validarCampos(String id, double latitud, double longitud)
            throws UbicacionFieldInvalidException {
        if (id == null || id.isEmpty() || id.length() > 8) {
            throw new UbicacionFieldInvalidException("id");
        }
        if (Double.isNaN(latitud)) {
            throw new UbicacionFieldInvalidException("latitud");
        }
        if (Double.isNaN(longitud)) {
            throw new UbicacionFieldInvalidException("longitud");
        }
    }

    private void validarCamposDireccion(String direccion, String barrio)
            throws UbicacionFieldInvalidException {
        if (direccion == null || direccion.isEmpty()) {
            throw new UbicacionFieldInvalidException("direccion");
        }
        if (barrio == null || barrio.isEmpty()) {
            throw new UbicacionFieldInvalidException("barrio");
        }
    }
}
