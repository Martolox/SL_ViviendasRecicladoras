package api;

import dtos.*;

import java.sql.SQLException;
import java.util.List;

public interface ServidorAPI {

    /**
     * Dado un número de documento y un beneficio deseado determina si puede intercambiar el puntaje
     *
     * @param id        String de 8 caracteres numéricos.
     * @param beneficio Enumerador, ej: Beneficio1, Beneficio2...
     */
    void cambiarPuntos(String id, String beneficio) throws SQLException;

    /**
     * Recupera una campaña en específico usando como identificador un número de documento.
     *
     * @param id String de 8 caracteres numéricos.
     * @return CampaniaDto.
     */
    CampaniaDto listarCampaniaPorId(String id) throws SQLException;

    /**
     * Elimina un dueño de la BD usando como identificador un número de documento.
     *
     * @param dni String de 8 caracteres numéricos.
     */
    void eliminarDuenio(String dni) throws SQLException;

    /**
     * Recupera un dueño en específico usando como identificador un número de documento.
     *
     * @param dni String de 8 caracteres numéricos.
     * @return DuenioDto.
     */
    DuenioDto listarDuenioPorId(String dni) throws SQLException;

    /**
     * Registra la entidad con los datos que se suministren.
     *
     * @param nombre   Obligatorio.
     * @param apellido Obligatorio.
     * @param dni      Obligatorio, String de 8 caracteres numéricos.
     * @param correo   Debe contener un '@'.
     * @param telefono Debe tener hasta 10 caracteres numéricos.
     */
    void registrarDuenio(String nombre, String apellido, String dni, String correo, String telefono) throws SQLException;

    /**
     * Recupera una lista de inscripciones filtradas por el valor indicado.
     *
     * @param valor String que se puede corresponder con un nombre, apellido o documento.
     * @return List<InscripcionDto>.
     */
    List<InscripcionDto> listarInscripcionPor(String valor) throws SQLException;

    /**
     * Recupera la lista completa de inscripciones.
     *
     * @return List<InscripcionDto>.
     */
    List<InscripcionDto> listarInscripciones() throws SQLException;

    /**
     * Modifica la entidad con los datos que se suministren.
     *
     * @param dni       Obligatorio, String de 8 caracteres numéricos.
     * @param nombre    Obligatorio.
     * @param apellido  Obligatorio.
     * @param correo    String, debe contener un '@'.
     * @param telefono  String, debe tener hasta 10 caracteres numéricos.
     * @param direccion Obligatorio.
     * @param zona      String opcional.
     * @param barrio    Obligatorio.
     */
    void modificarInscripcion(String dni, String nombre, String apellido, String correo,
                              String telefono, String direccion, String zona, String barrio) throws SQLException;

    /**
     * Recupera una lista de órdenes filtradas por el valor indicado.
     *
     * @param valor String que se puede corresponder con un documento o id.
     * @return List<OrdenDto>.
     */
    List<OrdenDto> listarOrdenPor(String valor) throws SQLException;

    /**
     * Recupera la lista completa de órdenes.
     *
     * @return List<OrdenDto>.
     */
    List<OrdenDto> listarOrdenes() throws SQLException;

    /**
     * Registra una orden con los datos suministrados.
     *
     * @param duenio         Obligatorio, String de 8 caracteres numéricos.
     * @param plastico       Float.
     * @param papel          Float.
     * @param vidrio         Float.
     * @param metal          Float.
     * @param vehiculoPesado Booleano.
     * @param observacion    String de hasta 160 caracteres.
     */
    void registrarOrden(String duenio, String plastico, String papel,
                        String vidrio, String metal, boolean vehiculoPesado, String observacion) throws SQLException;

    /**
     * Elimina a un personal de la BD usando como identificador su número de documento.
     *
     * @param dni String de 8 caracteres numéricos.
     */
    void eliminarPersonal(String dni) throws SQLException;

    /**
     * Recupera una lista filtrada del personal.
     *
     * @param valor String que filtra según nombre, apellido o documeto.
     * @return List<PersonalDto>.
     */
    List<PersonalDto> listarPersonalPor(String valor) throws SQLException;

    /**
     * Recupera a un personal en específico usando como identificador un número de documento.
     *
     * @param dni String de 8 caracteres numéricos.
     * @return PersonalDto.
     */
    PersonalDto listarPersonalPorId(String dni) throws SQLException;

    /**
     * Recupera la lista completa del personal.
     *
     * @return mensaje OK y List[Personal] o BAD_REQUEST con lista vacía.
     */
    List<PersonalDto> listarPersonal() throws SQLException;

    /**
     * Modifica un personal con los datos suministrados.
     *
     * @param nombre    Obligatorio.
     * @param apellido  Obligatorio.
     * @param documento Obligatorio, String de 8 caracteres numéricos.
     */
    void modificarPersonal(String nombre, String apellido, String documento) throws SQLException;

    /**
     * Registra un personal con los datos suministrados.
     *
     * @param nombre    Obligatorio.
     * @param apellido  Obligatorio.
     * @param documento Obligatorio, String de 8 caracteres numéricos.
     */
    void registrarPersonal(String nombre, String apellido, String documento) throws SQLException;

    /**
     * Recupera una lista de visitas asociada al número de órden.
     *
     * @param id String que representa un número de órden.
     * @return mensaje OK y List[Visita] o BAD_REQUEST con lista vacía.
     */
    List<VisitaDto> listarVisitasPorId(String id) throws SQLException;

    /**
     * Agrega una visita a una orden, y actualiza el estado de la misma.
     *
     * @param orden       String numérico que representa el id de la órden.
     * @param estado      Enumeración,'PENDIENTE','EN_EJECUCION','CONCRETADO','CANCELADO'.
     * @param observacion String de hasta 160 caracteres.
     */
    void registrarVisita(String orden, String estado, String observacion) throws SQLException;

    /**
     * Recupera una vivienda en específico usando como identificador el dni del duenio.
     *
     * @param id String de 8 caracteres numéricos.
     * @return mensaje OK más objeto Vivienda o BAD_REQUEST con null.
     */
    ViviendaDto listarViviendaPorId(String id) throws SQLException;

    /**
     * Registra la entidad con los datos que se suministren.
     *
     * @param id        Obligatorio, String de 8 caracteres numéricos que representa el documento del dueño.
     * @param direccion Obligatorio.
     * @param zona      Opcional.
     * @param barrio    Obligatorio.
     */
    void registrarVivienda(String id, String direccion, String zona, String barrio) throws SQLException;

    /**
     * Registra una ubicación en coordenadas GPS. Debe ejecutarse al registrar una vivienda.
     *
     * @param latitud  double (ej -40.80485058962254).
     * @param longitud double (ej -63.012335681129805).
     */
    void registrarUbicacion(String id, double latitud, double longitud) throws SQLException;

    /**
     * Verifica que la dirección se corresponda a una coordenada GPS.
     *
     * @param id        Obligatorio, String de 8 caracteres numéricos que representa el documento del dueño.
     * @param direccion String obiligatorio.
     * @param barrio    String obiligatorio.
     * @return mensaje OK más objeto Coordenada o BAD_REQUEST con null.
     */
    UbicacionDto validarUbicacion(String id, String direccion, String barrio) throws SQLException;

    /**
     * Recupera una lista de visitas activas asociadas al número de documento.
     *
     * @param dni String numérico.
     * @return Lista de visitas activas.
     */
    String listarOrdenesMC(String dni) throws SQLException;
}
