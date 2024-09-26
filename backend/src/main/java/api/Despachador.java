package api;

import dtos.*;
import resources.*;

import java.sql.SQLException;
import java.util.List;

public class Despachador implements ServidorAPI {
    private final RecursoCampania recursoCampania;
    private final RecursoDuenio recursoDuenio;
    private final RecursoInscripcion recursoInscripcion;
    private final RecursoOrden recursoOrden;
    private final RecursoPersonal recursoPersonal;
    private final RecursoUbicacion recursoUbicacion;
    private final RecursoVivienda recursoVivienda;
    private final RecursoVisita recursoVisita;


    public Despachador() {
        this.recursoCampania = new RecursoCampania();
        this.recursoDuenio = new RecursoDuenio();
        this.recursoInscripcion = new RecursoInscripcion();
        this.recursoOrden = new RecursoOrden();
        this.recursoPersonal = new RecursoPersonal();
        this.recursoUbicacion = new RecursoUbicacion();
        this.recursoVivienda = new RecursoVivienda();
        this.recursoVisita = new RecursoVisita();
    }

    @Override
    public void cambiarPuntos(String id, String beneficio) throws SQLException {
        recursoCampania.cambiarPuntos(id, beneficio);
    }

    @Override
    public CampaniaDto listarCampaniaPorId(String id) throws SQLException {
        return recursoCampania.listarPorId(id);
    }

    @Override
    public void eliminarDuenio(String dni) throws SQLException {
        recursoDuenio.eliminar(dni);
    }

    @Override
    public DuenioDto listarDuenioPorId(String dni) throws SQLException {
        return recursoDuenio.listarPorId(dni);
    }

    @Override
    public void registrarDuenio(String nombre, String apellido, String dni, String correo, String telefono) throws SQLException {
        recursoDuenio.registrar(nombre, apellido, dni, correo, telefono);
    }

    @Override
    public List<InscripcionDto> listarInscripcionPor(String valor) throws SQLException {
        return recursoInscripcion.listarPor(valor);
    }

    @Override
    public List<InscripcionDto> listarInscripciones() throws SQLException {
        return recursoInscripcion.listar();
    }

    @Override
    public void modificarInscripcion(String dni, String nombre, String apellido, String correo,
                                     String telefono, String direccion, String zona, String barrio) throws SQLException {
        recursoInscripcion.modificar(dni, nombre, apellido, correo, telefono, direccion, zona, barrio);
    }

    @Override
    public List<OrdenDto> listarOrdenPor(String valor) throws SQLException {
        return recursoOrden.listarPor(valor);
    }

    @Override
    public List<OrdenDto> listarOrdenes() throws SQLException {
        return recursoOrden.listar();
    }

    @Override
    public void registrarOrden(String duenio, String plastico, String papel, String vidrio, String metal,
                               boolean vehiculoPesado, String observacion) throws SQLException {
        recursoOrden.registrar(duenio, plastico, papel, vidrio, metal, vehiculoPesado, observacion);
    }

    @Override
    public void eliminarPersonal(String dni) throws SQLException {
        recursoPersonal.eliminar(dni);
    }

    @Override
    public List<PersonalDto> listarPersonalPor(String valor) throws SQLException {
        return recursoPersonal.listarPor(valor);
    }

    @Override
    public PersonalDto listarPersonalPorId(String dni) throws SQLException {
        return recursoPersonal.listarPorId(dni);
    }

    @Override
    public List<PersonalDto> listarPersonal() throws SQLException {
        return recursoPersonal.listar();
    }

    @Override
    public void modificarPersonal(String nombre, String apellido, String documento) throws SQLException {
        recursoPersonal.modificar(nombre, apellido, documento);
    }

    @Override
    public void registrarPersonal(String nombre, String apellido, String documento) throws SQLException {
        recursoPersonal.registrar(nombre, apellido, documento);
    }

    @Override
    public ViviendaDto listarViviendaPorId(String id) throws SQLException {
        return recursoVivienda.listarPorId(id);
    }

    @Override
    public void registrarVivienda(String id, String direccion, String zona, String barrio) throws SQLException {
        recursoVivienda.registrar(id, direccion, zona, barrio);
    }

    @Override
    public List<VisitaDto> listarVisitasPorId(String id) throws SQLException {
        return recursoVisita.listarPorId(id);
    }

    @Override
    public void registrarVisita(String orden, String estado, String observacion) throws SQLException {
        recursoVisita.registrar(orden, estado, observacion);
    }

    @Override
    public void registrarUbicacion(String id, double latitud, double longitud) throws SQLException {
        recursoUbicacion.registrar(id, latitud, longitud);
    }

    @Override
    public UbicacionDto validarUbicacion(String id, String direccion, String barrio) throws SQLException {
        return recursoUbicacion.validar(id, direccion, barrio);
    }

    @Override
    public String listarOrdenesMC(String dni) throws SQLException {
        return recursoOrden.listarOrdenesMC(dni);
    }
}
