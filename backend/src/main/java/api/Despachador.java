package api;

import controllers.*;
import dtos.*;
import entities.*;
import exceptions.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Despachador implements ServidorAPI {

    @Override
    public void cambiarPuntos(String id, String beneficio) throws SQLException {
        new ControladorCampania().cambiarPuntos(id, beneficio);
    }

    @Override
    public CampaniaDto listarCampaniaPorId(String id) throws SQLException {
        Optional<CampaniaDto> optional = Optional.ofNullable(new ControladorCampania().listarPorId(id));
        return optional.orElseThrow(CampaniaIdNotFoundException::new);
    }

    @Override
    public void eliminarDuenio(String dni) throws SQLException {
        validarCampoDni(dni);
        new ControladorDuenio().eliminar(dni);
    }

    @Override
    public DuenioDto listarDuenioPorId(String dni) throws SQLException {
        Optional<DuenioDto> optional = Optional.ofNullable(new ControladorDuenio().listarPorId(dni));
        return optional.orElseThrow(DuenioIdNotFoundException::new);
    }

    @Override
    public void registrarDuenio(String nombre, String apellido, String dni, String correo, String telefono) throws SQLException {
        new ControladorDuenio().registrar(new Duenio(nombre, apellido, dni, correo, telefono));
    }

    @Override
    public List<InscripcionDto> listarInscripcionPor(String valor) throws SQLException {
        if (valor.isEmpty()) {
            return new ControladorInscripcion().listar();
        } else {
            return new ControladorInscripcion().listarPor(valor);
        }
    }

    @Override
    public List<InscripcionDto> listarInscripciones() throws SQLException {
        return new ControladorInscripcion().listar();
    }

    @Override
    public void modificarInscripcion(String dni, String nombre, String apellido, String correo, String telefono,
                                     String direccion, String zona, String barrio) throws SQLException {
        new ControladorInscripcion().modificar(new Inscripcion(dni, nombre, apellido, correo, telefono, direccion, zona, barrio));
    }

    @Override
    public List<OrdenDto> listarOrdenPor(String valor) throws SQLException {
        if (valor.isEmpty()) {
            return new ControladorOrden().listar();
        } else {
            return new ControladorOrden().listarPor(valor);
        }
    }

    @Override
    public List<OrdenDto> listarOrdenes() throws SQLException {
        return new ControladorOrden().listar();
    }

    @Override
    public String listarOrdenesMC(String dni) throws SQLException {
        validarCampoDni(dni);
        return new ControladorOrden().listarOrdenesMC(dni);
    }

    @Override
    public void registrarOrden(String duenio, String plastico, String papel, String vidrio, String metal,
                               boolean vehiculoPesado, String observacion) throws SQLException {
        if (!new ControladorOrden().registrar(new Orden(duenio, Float.parseFloat(plastico), Float.parseFloat(papel),
                Float.parseFloat(vidrio), Float.parseFloat(metal), vehiculoPesado, observacion))) {
            throw new OrdenEntityExistsException(duenio);
        }
    }

    @Override
    public void eliminarPersonal(String dni) throws SQLException {
        validarCampoDni(dni);
        new ControladorPersonal().eliminar(dni);
    }

    @Override
    public List<PersonalDto> listarPersonalPor(String valor) throws SQLException {
        if (valor.isEmpty()) {
            return new ControladorPersonal().listar();
        } else {
            return new ControladorPersonal().listarPor(valor);
        }
    }

    @Override
    public PersonalDto listarPersonalPorId(String dni) throws SQLException {
        Optional<PersonalDto> optional = Optional.ofNullable(new ControladorPersonal().listarPorId(dni));
        return optional.orElseThrow(PersonalIdNotFoundException::new);
    }

    @Override
    public List<PersonalDto> listarPersonal() throws SQLException {
        return new ControladorPersonal().listar();
    }

    @Override
    public void modificarPersonal(String nombre, String apellido, String documento) throws SQLException {
        new ControladorPersonal().modificar(new Personal(nombre, apellido, documento));
    }

    @Override
    public void registrarPersonal(String nombre, String apellido, String documento) throws SQLException {
        new ControladorPersonal().registrar(new Personal(nombre, apellido, documento));
    }

    @Override
    public ViviendaDto listarViviendaPorId(String id) throws SQLException {
        Optional<ViviendaDto> optional = Optional.ofNullable(new ControladorVivienda().listarPorId(id));
        return optional.orElseThrow(ViviendaIdNotFoundException::new);
    }

    @Override
    public void registrarVivienda(String id, String direccion, String zona, String barrio) throws SQLException {
        if (!new ControladorVivienda().registrar(new Vivienda(id, direccion, zona, barrio))) {
            throw new ViviendaEntityExistsException();
        }
    }

    @Override
    public List<VisitaDto> listarVisitasPorId(String id) throws SQLException {
        return new ControladorVisita().listarPorId(id);
    }

    @Override
    public void registrarVisita(String orden, String estado, String observacion) throws SQLException {
        new ControladorVisita().registrar(new Orden(orden, estado, observacion));
    }

    @Override
    public void registrarUbicacion(String id, double latitud, double longitud) throws SQLException {
        if (!new ControladorUbicacion().registrar(new Ubicacion(id, latitud, longitud))) {
            throw new UbicacionEntityExistsException();
        }
    }

    @Override
    public UbicacionDto validarUbicacion(String id, String direccion, String barrio) throws SQLException {
        validarCamposDireccion(direccion, barrio);
        if (new ControladorDuenio().listarPorId(id) == null) throw new DuenioIdNotFoundException();
        return new ControladorUbicacion().validar(direccion);
    }

    // Validaciones de campos simples
    private void validarCampoDni(String dni) {
        if (dni == null || dni.isEmpty() || dni.length() > 8) {
            throw new DuenioFieldInvalidException("documento");
        }
    }

    private void validarCamposDireccion(String direccion, String barrio) {
        if (direccion == null || direccion.isEmpty()) {
            throw new UbicacionFieldInvalidException("direccion");
        }
        if (barrio == null || barrio.isEmpty()) {
            throw new UbicacionFieldInvalidException("barrio");
        }
    }
}
