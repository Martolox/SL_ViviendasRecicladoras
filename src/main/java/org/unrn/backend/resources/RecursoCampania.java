package org.unrn.backend.resources;

import org.unrn.backend.controllers.ControladorCampania;
import org.unrn.backend.dtos.CampaniaDto;
import org.unrn.exceptions.CampaniaEntityExistsException;
import org.unrn.exceptions.CampaniaFieldInvalidException;
import org.unrn.exceptions.CampaniaIdNotFoundException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RecursoCampania {

    public void cambiarPuntos(String id, String beneficio) throws SQLException {
        new ControladorCampania().cambiarPuntos(id, beneficio);
    }

    public void eliminar(String id) throws SQLException {
        if (id == null || id.isEmpty() || id.length() > 8) {
            throw new CampaniaFieldInvalidException("id");
        }
        new ControladorCampania().eliminar(id);
    }

    public CampaniaDto listarPorId(String dni) throws CampaniaIdNotFoundException, SQLException {
        Optional<CampaniaDto> optional = Optional.ofNullable(new ControladorCampania().listarPorId(dni));
        return optional.orElseThrow(CampaniaIdNotFoundException::new);
    }

    public List<CampaniaDto> listar() throws SQLException {
        return new ControladorCampania().listar();
    }

    public void modificar(String id, int puntos, String beneficios)
            throws CampaniaFieldInvalidException, CampaniaIdNotFoundException, NumberFormatException, SQLException {
        validarCampos(id);
        new ControladorCampania().modificar(id, puntos, beneficios);
    }

    public void registrar(String id, int puntos, String beneficios)
            throws CampaniaEntityExistsException, CampaniaFieldInvalidException, NumberFormatException, SQLException {
        validarCampos(id);
        if (!new ControladorCampania().registrar(id, puntos, beneficios)) {
            throw new CampaniaEntityExistsException(id);
        }
    }

    private void validarCampos(String id)
            throws CampaniaFieldInvalidException, NumberFormatException {
        if (id == null || id.isEmpty() || id.length() > 8) {
            throw new CampaniaFieldInvalidException("id");
        }
        Integer.parseInt(id);
    }
}
