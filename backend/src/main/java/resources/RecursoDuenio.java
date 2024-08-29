package resources;

import controllers.ControladorDuenio;
import dtos.DuenioDto;
import exceptions.DuenioEntityExistsException;
import exceptions.DuenioFieldInvalidException;
import exceptions.DuenioIdNotFoundException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RecursoDuenio {

    public void eliminar(String dni) throws SQLException {
        if (dni == null || dni.isEmpty() || dni.length() > 8) {
            throw new DuenioFieldInvalidException("documento");
        }
        new ControladorDuenio().eliminar(dni);
    }

    public DuenioDto listarPorId(String dni) throws SQLException {
        Optional<DuenioDto> optional = Optional.ofNullable(new ControladorDuenio().listarPorId(dni));
        return optional.orElseThrow(DuenioIdNotFoundException::new);
    }

    public List<DuenioDto> listar() throws SQLException {
        return new ControladorDuenio().listar();
    }

    public void modificar(String nombre, String apellido, String dni, String correo, String telefono) throws SQLException {
        validarCampos(nombre, apellido, dni, correo, telefono);
        new ControladorDuenio().modificar(nombre, apellido, dni, correo, telefono);
    }

    public void registrar(String nombre, String apellido, String dni, String correo, String telefono) throws SQLException {
        validarCampos(nombre, apellido, dni, correo, telefono);
        if (!new ControladorDuenio().registrar(nombre, apellido, dni, correo, telefono)) {
            throw new DuenioEntityExistsException(dni);
        }
    }

    private void validarCampos(String nombre, String apellido, String dni, String correo, String telefono) throws NumberFormatException {
        if (nombre == null || nombre.isEmpty()) {
            throw new DuenioFieldInvalidException("nombre");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new DuenioFieldInvalidException("apellido");
        }
        if (dni == null || dni.isEmpty() || dni.length() > 8) {
            throw new DuenioFieldInvalidException("documento");
        }
        if (!correo.isEmpty()) {
            if (!correo.contains("@")) throw new DuenioFieldInvalidException("correo");
        }
        if (telefono.length() > 10) {
            throw new DuenioFieldInvalidException("telefono");
        }
        if (!telefono.isEmpty()) {
            Long.parseLong(telefono);
        }
        Integer.parseInt(dni);
    }
}
