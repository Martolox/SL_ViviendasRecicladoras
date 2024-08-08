package org.unrn.backend.resources;

import org.unrn.backend.controllers.ControladorInscripcion;
import org.unrn.backend.controllers.ControladorPersonal;
import org.unrn.backend.dtos.PersonalDto;
import org.unrn.exceptions.PersonalEntityExistsException;
import org.unrn.exceptions.PersonalFieldInvalidException;
import org.unrn.exceptions.PersonalIdNotFoundException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RecursoPersonal {

    public void eliminar(String dni) throws SQLException {
        if (dni == null || dni.isEmpty() || dni.length() > 8) {
            throw new PersonalFieldInvalidException("documento");
        }
        new ControladorPersonal().eliminar(dni);
    }

    public List<PersonalDto> listarPor(String valor) throws SQLException {
        if (valor.isEmpty()) {
            return new ControladorPersonal().listar();
        } else {
            return new ControladorPersonal().listarPor(valor);
        }
    }

    public PersonalDto listarPorId(String dni) throws PersonalIdNotFoundException, SQLException {
        Optional<PersonalDto> optional = Optional.ofNullable(new ControladorPersonal().listarPorId(dni));
        return optional.orElseThrow(PersonalIdNotFoundException::new);
    }

    public List<PersonalDto> listar() throws SQLException {
        return new ControladorPersonal().listar();
    }

    public void modificar(String nombre, String apellido, String dni)
            throws PersonalFieldInvalidException, PersonalIdNotFoundException, NumberFormatException, SQLException {
        validarCampos(nombre, apellido, dni);
        new ControladorPersonal().modificar(nombre, apellido, dni);
    }

    public void registrar(String nombre, String apellido, String dni)
            throws PersonalFieldInvalidException, PersonalEntityExistsException, NumberFormatException, SQLException {
        validarCampos(nombre, apellido, dni);
        if (!new ControladorPersonal().registrar(nombre, apellido, dni)) {
            throw new PersonalEntityExistsException(dni);
        }
    }

    private void validarCampos(String nombre, String apellido, String dni)
            throws PersonalFieldInvalidException, NumberFormatException {
        if (nombre == null || nombre.isEmpty()) {
            throw new PersonalFieldInvalidException("nombre");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new PersonalFieldInvalidException("apellido");
        }
        if (dni == null || dni.isEmpty() || dni.length() > 8) {
            throw new PersonalFieldInvalidException("documento");
        }
        Integer.parseInt(dni);
    }
}
