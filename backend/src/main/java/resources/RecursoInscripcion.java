package resources;

import controllers.ControladorInscripcion;
import dtos.InscripcionDto;
import exceptions.DuenioEntityExistsException;
import exceptions.DuenioFieldInvalidException;
import exceptions.DuenioIdNotFoundException;
import exceptions.InscripcionFieldInvalidException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RecursoInscripcion {

    public void eliminar(String dni) throws SQLException {
        if (dni == null || dni.isEmpty() || dni.length() > 8) {
            throw new InscripcionFieldInvalidException("documento");
        }
        new ControladorInscripcion().eliminar(dni);
    }

    public List<InscripcionDto> listarPor(String valor) throws SQLException {
        if (valor.isEmpty()) {
            return new ControladorInscripcion().listar();
        } else {
            return new ControladorInscripcion().listarPor(valor);
        }
    }

    public InscripcionDto listarPorId(String dni) throws SQLException {
        Optional<InscripcionDto> optional = Optional.ofNullable(new ControladorInscripcion().listarPorId(dni));
        return optional.orElseThrow(DuenioIdNotFoundException::new);
    }

    public List<InscripcionDto> listar() throws SQLException {
        return new ControladorInscripcion().listar();
    }

    public void modificar(String dni, String nombre, String apellido, String correo, String telefono, String direccion,
                          String zona, String barrio)
            throws InscripcionFieldInvalidException, DuenioIdNotFoundException, NumberFormatException, SQLException {
        validarCampos(dni, nombre, apellido, correo, telefono, direccion, barrio);
        new ControladorInscripcion().modificar(dni, nombre, apellido, correo, telefono, direccion, zona, barrio);
    }

    public void registrar(String dni, String nombre, String apellido, String correo, String telefono, String direccion,
                          String zona, String barrio)
            throws DuenioFieldInvalidException, DuenioEntityExistsException, NumberFormatException, SQLException {
        validarCampos(dni, nombre, apellido, correo, telefono, direccion, barrio);
        if (!new ControladorInscripcion().registrar(dni, nombre, apellido, correo, telefono, direccion, zona, barrio)) {
            throw new DuenioEntityExistsException(dni);
        }
    }

    private void validarCampos(String dni, String nombre, String apellido, String correo,
                               String telefono, String direccion, String barrio)
            throws NumberFormatException {
        if (dni == null || dni.isEmpty() || dni.length() > 8) {
            throw new InscripcionFieldInvalidException("documento");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new InscripcionFieldInvalidException("nombre");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new InscripcionFieldInvalidException("apellido");
        }
        if (!correo.isEmpty()) {
            if (!correo.contains("@")) throw new InscripcionFieldInvalidException("correo");
        }
        if (telefono.length() > 10) {
            throw new InscripcionFieldInvalidException("telefono");
        }
        if (direccion == null || direccion.isEmpty()) {
            throw new InscripcionFieldInvalidException("direccion");
        }
        if (barrio == null || barrio.isEmpty()) {
            throw new InscripcionFieldInvalidException("apellido");
        }
        if (!telefono.isEmpty()) {
            Long.parseLong(telefono);
        }
        Integer.parseInt(dni);
    }
}
