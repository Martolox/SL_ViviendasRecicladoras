package resources;

import controllers.ControladorOrden;
import dtos.OrdenDto;
import exceptions.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RecursoOrden {

    public void eliminar(String id) throws SQLException {
        new ControladorOrden().eliminar(Integer.parseInt(id));
    }

    public List<OrdenDto> listarPor(String valor) throws SQLException {
        if (valor.isEmpty()) {
            return new ControladorOrden().listar();
        } else {
            return new ControladorOrden().listarPor(valor);
        }
    }

    public OrdenDto listarPorId(String id) throws SQLException {
        Optional<OrdenDto> optional = Optional.ofNullable(new ControladorOrden().listarPorId(Integer.parseInt(id)));
        return optional.orElseThrow(OrdenIdNotFoundException::new);
    }

    public List<OrdenDto> listar() throws SQLException {
        return new ControladorOrden().listar();
    }

    public String listarOrdenesMC(String dni) throws SQLException {
        validarCampos(dni);
        return new ControladorOrden().listarOrdenesMC(dni);
    }

    public void modificar(String id, String duenio, String personal, String estado, String plastico, String papel,
                          String vidrio, String metal, boolean vehiculoPesado, String observacion) throws SQLException {
        validarCampos(duenio, personal);
        if (plastico.isEmpty()) plastico = "0";
        if (papel.isEmpty()) papel = "0";
        if (vidrio.isEmpty()) vidrio = "0";
        if (metal.isEmpty()) metal = "0";
        new ControladorOrden().modificar(Integer.parseInt(id), duenio, personal, estado, Float.parseFloat(plastico),
                Float.parseFloat(papel), Float.parseFloat(vidrio), Float.parseFloat(metal), vehiculoPesado, observacion);
    }

    public void registrar(String duenio, String plastico, String papel, String vidrio, String metal,
                          boolean vehiculoPesado, String observacion) throws SQLException {
        validarCampos(duenio, "1234");
        if (!new ControladorOrden().registrar(duenio, Float.parseFloat(plastico), Float.parseFloat(papel),
                Float.parseFloat(vidrio), Float.parseFloat(metal), vehiculoPesado, observacion)) {
            throw new OrdenEntityExistsException(duenio);
        }
    }

    private void validarCampos(String duenio)
            throws OrdenFieldInvalidException {
        if (duenio == null || duenio.isEmpty() || duenio.length() > 8) {
            throw new DuenioIdNotFoundException("duenio");
        }
    }

    private void validarCampos(String duenio, String personal)
            throws OrdenFieldInvalidException {
        if (duenio == null || duenio.isEmpty() || duenio.length() > 8) {
            throw new DuenioIdNotFoundException("duenio");
        }
        if (personal == null || personal.isEmpty() || personal.length() > 8) {
            throw new PersonalIdNotFoundException("personal");
        }
    }
}
