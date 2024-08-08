package org.unrn.backend.resources;

import org.unrn.backend.controllers.ControladorVivienda;
import org.unrn.backend.dtos.ViviendaDto;
import org.unrn.exceptions.DuenioIdNotFoundException;
import org.unrn.exceptions.ViviendaEntityExistsException;
import org.unrn.exceptions.ViviendaFieldInvalidException;
import org.unrn.exceptions.ViviendaIdNotFoundException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RecursoVivienda {

    public void eliminar(String id) throws SQLException {
        if (id == null || id.isEmpty()) {
            throw new ViviendaFieldInvalidException();
        }
        new ControladorVivienda().eliminar(id);
    }

    public ViviendaDto listarPorId(String id) throws ViviendaIdNotFoundException, SQLException {
        Optional<ViviendaDto> optional = Optional.ofNullable(new ControladorVivienda().listarPorId(id));
        return optional.orElseThrow(ViviendaIdNotFoundException::new);
    }

    public List<ViviendaDto> listar() throws SQLException {
        return new ControladorVivienda().listar();
    }

    public void modificar(String id, String duenio, String direccion, String zona, String barrio)
            throws ViviendaFieldInvalidException, ViviendaIdNotFoundException, NumberFormatException, SQLException {
        validarCampos(id, direccion, barrio);
        if (!id.equals(duenio)) throw new ViviendaFieldInvalidException(id);
        new ControladorVivienda().modificar(id, direccion, zona, barrio);
    }

    public void registrar(String id, String direccion, String zona, String barrio) throws ViviendaFieldInvalidException,
            DuenioIdNotFoundException, ViviendaEntityExistsException, NumberFormatException, SQLException {
        validarCampos(id, direccion, barrio);
        if (!new ControladorVivienda().registrar(id, direccion, zona, barrio)) {
            throw new ViviendaEntityExistsException();
        }
    }

    private void validarCampos(String id, String direccion, String barrio)
            throws ViviendaFieldInvalidException, NumberFormatException {
        if (id == null || id.isEmpty() || id.length() > 8) {
            throw new ViviendaFieldInvalidException("id");
        }
        if (direccion == null || direccion.isEmpty()) {
            throw new ViviendaFieldInvalidException("direccion");
        }
        if (barrio == null || barrio.isEmpty()) {
            throw new ViviendaFieldInvalidException("barrio");
        }
        Integer.parseInt(id);
    }
}
