package api;

import entities.Respuesta;
import exceptions.*;
import resources.*;

import java.sql.SQLException;

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
    public Respuesta cambiarPuntos(String id, String beneficio) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoCampania.cambiarPuntos(id, beneficio);
        } catch (PersonalIdNotFoundException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta eliminarCampania(String id) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoCampania.eliminar(id);
        } catch (CampaniaFieldInvalidException | CampaniaIdNotFoundException | NumberFormatException e) {
            respuesta.setEstado("ERROR " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e.getMessage());
        }
        return respuesta;
    }

    @Override
    public Respuesta listarCampaniaPorId(String id) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoCampania.listarPorId(id));
        } catch (PersonalIdNotFoundException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta listarCampanias() {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoCampania.listar());
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta modificarCampania(String id, int puntos, String beneficios) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoCampania.modificar(id, puntos, beneficios);
        } catch (CampaniaFieldInvalidException | CampaniaIdNotFoundException | NumberFormatException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta registrarCampania(String id, int puntos, String beneficios) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoCampania.registrar(id, puntos, beneficios);
        } catch (CampaniaFieldInvalidException | CampaniaEntityExistsException |
                 DuenioIdNotFoundException | NumberFormatException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta eliminarDuenio(String dni) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoDuenio.eliminar(dni);
        } catch (DuenioFieldInvalidException | DuenioIdNotFoundException | NumberFormatException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e.getMessage());
        }
        return respuesta;
    }

    @Override
    public Respuesta listarDuenioPorId(String dni) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoDuenio.listarPorId(dni));
        } catch (DuenioIdNotFoundException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta listarDuenios() {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoDuenio.listar());
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta modificarDuenio(String nombre, String apellido, String dni, String correo, String telefono) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoDuenio.modificar(nombre, apellido, dni, correo, telefono);
        } catch (PersonalFieldInvalidException | PersonalIdNotFoundException | NumberFormatException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta registrarDuenio(String nombre, String apellido, String dni, String correo, String telefono) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoDuenio.registrar(nombre, apellido, dni, correo, telefono);
        } catch (DuenioFieldInvalidException | DuenioEntityExistsException | NumberFormatException e) {
            respuesta.setEstado("BAD_REQUEST " + e.getMessage());
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta eliminarInscripcion(String dni) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoInscripcion.eliminar(dni);
        } catch (InscripcionFieldInvalidException | DuenioIdNotFoundException | NumberFormatException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e.getMessage());
        }
        return respuesta;
    }

    @Override
    public Respuesta listarInscripcionPor(String valor) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoInscripcion.listarPor(valor));
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta listarInscripcionPorId(String dni) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoInscripcion.listarPorId(dni));
        } catch (DuenioIdNotFoundException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta listarInscripciones() {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoInscripcion.listar());
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta modificarInscripcion(String dni, String nombre, String apellido, String correo,
                                          String telefono, String direccion, String zona, String barrio) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoInscripcion.modificar(dni, nombre, apellido, correo, telefono, direccion, zona, barrio);
        } catch (InscripcionFieldInvalidException | DuenioIdNotFoundException | NumberFormatException e) {
            respuesta.setEstado("BAD_REQUEST " + e.getMessage());
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta registrarInscripcion(String dni, String nombre, String apellido, String correo,
                                          String telefono, String direccion, String zona, String barrio) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoInscripcion.registrar(dni, nombre, apellido, correo, telefono, direccion, zona, barrio);
        } catch (InscripcionFieldInvalidException | DuenioEntityExistsException | NumberFormatException e) {
            respuesta.setEstado("BAD_REQUEST " + e.getMessage());
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta eliminarOrden(String id) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoOrden.eliminar(id);
        } catch (OrdenIdNotFoundException | NumberFormatException e) {
            respuesta.setEstado("ERROR " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e.getMessage());
        }
        return respuesta;
    }

    @Override
    public Respuesta listarOrdenPor(String valor) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoOrden.listarPor(valor));
        } catch (NumberFormatException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta listarOrdenPorId(String id) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoOrden.listarPorId(id));
        } catch (OrdenIdNotFoundException | NumberFormatException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta listarOrdenes() {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoOrden.listar());
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta modificarOrden(String id, String duenio, String personal, String estado, String plastico,
                                    String papel, String vidrio, String metal, boolean vehiculoPesado,
                                    String observacion) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoOrden.modificar(id, duenio, personal, estado, plastico, papel, vidrio,
                    metal, vehiculoPesado, observacion);
        } catch (OrdenFieldInvalidException | OrdenIdNotFoundException | NumberFormatException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta registrarOrden(String duenio, String plastico, String papel, String vidrio,
                                    String metal, boolean vehiculoPesado, String observacion) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoOrden.registrar(duenio, plastico, papel, vidrio,
                    metal, vehiculoPesado, observacion);
        } catch (OrdenFieldInvalidException | OrdenEntityExistsException |
                 DuenioIdNotFoundException | PersonalIdNotFoundException | NumberFormatException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta eliminarPersonal(String dni) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoPersonal.eliminar(dni);
        } catch (PersonalFieldInvalidException | PersonalIdNotFoundException | NumberFormatException e) {
            respuesta.setEstado("BAD_REQUEST " + e.getMessage());
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e.getMessage());
        }
        return respuesta;
    }

    @Override
    public Respuesta listarPersonalPor(String valor) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoPersonal.listarPor(valor));
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta listarPersonalPorId(String dni) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoPersonal.listarPorId(dni));
        } catch (PersonalIdNotFoundException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta listarPersonal() {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoPersonal.listar());
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta modificarPersonal(String nombre, String apellido, String documento) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoPersonal.modificar(nombre, apellido, documento);
        } catch (PersonalFieldInvalidException | PersonalIdNotFoundException | NumberFormatException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta registrarPersonal(String nombre, String apellido, String documento) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoPersonal.registrar(nombre, apellido, documento);
        } catch (PersonalFieldInvalidException | PersonalEntityExistsException | NumberFormatException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta eliminarVivienda(String id) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoVivienda.eliminar(id);
        } catch (ViviendaFieldInvalidException | ViviendaIdNotFoundException | NumberFormatException e) {
            respuesta.setEstado("ERROR " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e.getMessage());
        }
        return respuesta;
    }

    @Override
    public Respuesta listarViviendaPorId(String id) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoVivienda.listarPorId(id));
        } catch (ViviendaIdNotFoundException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta listarViviendas() {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoVivienda.listar());
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta modificarVivienda(String id, String duenio, String direccion, String zona, String barrio) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoVivienda.modificar(id, duenio, direccion, zona, barrio);
        } catch (ViviendaFieldInvalidException | ViviendaIdNotFoundException | NumberFormatException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta registrarVivienda(String id, String direccion, String zona, String barrio) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoVivienda.registrar(id, direccion, zona, barrio);
        } catch (ViviendaFieldInvalidException | ViviendaEntityExistsException |
                 DuenioIdNotFoundException | NumberFormatException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta listarVisitasPorId(String id) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoVisita.listarPorId(id));
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta registrarVisita(String orden, String estado, String observacion) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoVisita.registrar(orden, estado, observacion);
        } catch (UbicacionIdNotFoundException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta listarUbicacionPorId(String id) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoUbicacion.listarPorId(id));
        } catch (UbicacionIdNotFoundException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta registrarUbicacion(String id, double latitud, double longitud) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            recursoUbicacion.registrar(id, latitud, longitud);
        } catch (UbicacionFieldInvalidException | UbicacionEntityExistsException e) {
            respuesta.setEstado("BAD_REQUEST " + e.getMessage());
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta validarUbicacion(String id, String direccion, String barrio) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoUbicacion.validar(id, direccion, barrio));
        } catch (DuenioIdNotFoundException | UbicacionFieldInvalidException e) {
            respuesta.setEstado("BAD_REQUEST " + e.getMessage());
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }

    @Override
    public Respuesta listarOrdenesMC(String dni) {
        Respuesta respuesta = new Respuesta("OK");
        try {
            respuesta.setObj(recursoOrden.listarOrdenesMC(dni));
        } catch (OrdenFieldInvalidException e) {
            respuesta.setEstado("BAD_REQUEST " + e);
        } catch (SQLException e) {
            respuesta.setEstado("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            respuesta.setEstado("ERROR " + e);
        }
        return respuesta;
    }
}
