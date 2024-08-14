package resources;

import controllers.ControladorVisita;
import dtos.VisitaDto;
import exceptions.VisitaFieldInvalidException;

import java.sql.SQLException;
import java.util.List;

public class RecursoVisita {

    public List<VisitaDto> listarPorId(String id) throws SQLException {
        return new ControladorVisita().listarPorId(id);
    }

    public void registrar(String orden, String estado, String observacion)
            throws VisitaFieldInvalidException, NumberFormatException, SQLException {
        validarCampos(orden, estado);
        new ControladorVisita().registrar(Integer.parseInt(orden), estado, observacion);
//        if (! ) {
//            throw new DuenioEntityExistsException(dni);
//        }
    }

    private void validarCampos(String orden, String estado)
            throws VisitaFieldInvalidException, NumberFormatException {
        if (estado == null || estado.isEmpty()) {
            throw new VisitaFieldInvalidException("nombre");
        }
        Integer.parseInt(orden);
    }
}
