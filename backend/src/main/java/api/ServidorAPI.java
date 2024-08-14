package api;

import entities.Respuesta;

import java.sql.SQLException;

public interface ServidorAPI {

    /**
     * Dado un número de documento y un beneficio deseado determina si puede intercambiar el puntaje
     *
     * @param id
     * @return mensaje OK o BAD_REQUEST si la entidad no es hallada.
     */
    Respuesta cambiarPuntos(String id, String beneficio);

    /**
     * Elimina una campaña de la BD usando como identificador un número de documento.
     *
     * @param id String de 8 caracteres numéricos.
     * @return mensaje OK o BAD_REQUEST si la entidad no es hallada.
     */
    Respuesta eliminarCampania(String id);

    /**
     * Recupera una campaña en específico usando como identificador un número de documento.
     *
     * @param id String de 8 caracteres numéricos.
     * @return mensaje OK más objeto Duenio o BAD_REQUEST con null.
     */
    Respuesta listarCampaniaPorId(String id);

    /**
     * Recupera la lista completa de campañas.
     *
     * @return mensaje OK más objeto List[Duenio] o BAD_REQUEST con lista vacía.
     */
    Respuesta listarCampanias();

    /**
     * Modifica la entidad con los datos que se suministren.
     *
     * @param id         Obligatorio, String de 8 caracteres numéricos.
     * @param puntos     Valor entero (ej: 50).
     * @param beneficios String donde se detallan los beneficios activos (ej:"Reducción de impuesto ABL").
     * @return mensaje OK o BAD_REQUEST si la entidad no es hallada.
     */
    Respuesta modificarCampania(String id, int puntos, String beneficios);

    /**
     * Registra la entidad con los datos que se suministren.
     *
     * @param id         Obligatorio, String de 8 caracteres numéricos.
     * @param puntos     Valor entero (ej: 50).
     * @param beneficios String donde se detallan los beneficios activos (ej:"Reducción de impuesto ABL").
     * @return mensaje OK o BAD_REQUEST si algún parámetro no cumple con los requisitos.
     */
    Respuesta registrarCampania(String id, int puntos, String beneficios);

    /**
     * Elimina un dueño de la BD usando como identificador un número de documento.
     *
     * @param dni String de 8 caracteres numéricos.
     * @return mensaje OK o BAD_REQUEST si la entidad no es hallada.
     */
    Respuesta eliminarDuenio(String dni);

    /**
     * Recupera un dueño en específico usando como identificador un número de documento.
     *
     * @param dni String de 8 caracteres numéricos.
     * @return mensaje OK más objeto Duenio o BAD_REQUEST con null.
     */
    Respuesta listarDuenioPorId(String dni);

    /**
     * Recupera la lista completa de duenios.
     *
     * @return mensaje OK más objeto List[Duenio] o BAD_REQUEST con lista vacía.
     */
    Respuesta listarDuenios();

    /**
     * Modifica la entidad con los datos que se suministren.
     *
     * @param nombre   Obligatorio.
     * @param apellido Obligatorio.
     * @param dni      Obligatorio, String de 8 caracteres numéricos.
     * @param correo   Debe contener un '@'.
     * @param telefono Debe tener hasta 10 caracteres numéricos.
     * @return mensaje OK o BAD_REQUEST si la entidad no es hallada.
     */
    Respuesta modificarDuenio(String nombre, String apellido, String dni, String correo, String telefono);

    /**
     * Registra la entidad con los datos que se suministren.
     *
     * @param nombre   Obligatorio.
     * @param apellido Obligatorio.
     * @param dni      Obligatorio, String de 8 caracteres numéricos.
     * @param correo   Debe contener un '@'.
     * @param telefono Debe tener hasta 10 caracteres numéricos.
     * @return mensaje OK o BAD_REQUEST si algún parámetro no cumple con los requisitos.
     */
    Respuesta registrarDuenio(String nombre, String apellido, String dni, String correo, String telefono);

    /**
     * Elimina una inscripcion de la BD usando como identificador un número de documento.
     *
     * @param dni String de 8 caracteres numéricos.
     * @return mensaje OK o BAD_REQUEST si la entidad no es hallada.
     */
    Respuesta eliminarInscripcion(String dni);

    /**
     * Recupera una lista de inscripciones filtradas por el valor indicado.
     *
     * @param valor String que se puede corresponder con un nombre, apellido o documento.
     * @return mensaje OK más objeto List[Inscripcion] o BAD_REQUEST con lista vacía.
     */
    Respuesta listarInscripcionPor(String valor);

    /**
     * Recupera una inscripcion en específico usando como identificador un número de documento.
     *
     * @param dni String de 8 caracteres numéricos.
     * @return mensaje OK más objeto Inscripcion o BAD_REQUEST con null.
     */
    Respuesta listarInscripcionPorId(String dni);

    /**
     * Recupera la lista completa de duenios.
     *
     * @return mensaje OK más objeto List[Inscripcion] o BAD_REQUEST con lista vacía.
     */
    Respuesta listarInscripciones();

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
     * @return mensaje OK o BAD_REQUEST si la entidad no es hallada.
     */
    Respuesta modificarInscripcion(String dni, String nombre, String apellido, String correo,
                                   String telefono, String direccion, String zona, String barrio);

    /**
     * Registra la entidad con los datos que se suministren.
     *
     * @param dni       Obligatorio, String de 8 caracteres numéricos.
     * @param nombre    Obligatorio.
     * @param apellido  Obligatorio.
     * @param correo    String, debe contener un '@'.
     * @param telefono  String, debe tener hasta 10 caracteres numéricos.
     * @param direccion Obligatorio.
     * @param zona      String opcional.
     * @param barrio    Obligatorio.
     * @return mensaje OK o BAD_REQUEST si algún parámetro no cumple con los requisitos.
     */
    Respuesta registrarInscripcion(String dni, String nombre, String apellido, String correo,
                                   String telefono, String direccion, String zona, String barrio);

    /**
     * Elimina una orden de la BD usando como identificador su id.
     *
     * @param id String que se parsea a int, el cual comienza con 100 (ej: 102).
     * @return mensaje OK o BAD_REQUEST si la entidad no es hallada.
     */
    Respuesta eliminarOrden(String id);

    /**
     * Recupera una lista de órdenes filtradas por el valor indicado.
     *
     * @param valor String que se puede corresponder con un documento o id.
     * @return mensaje OK más objeto List[Orden], o BAD_REQUEST con null.
     */
    Respuesta listarOrdenPor(String valor);

    /**
     * Recupera una orden en específico usando como identificador un número en String.
     *
     * @param id String que se parsea a int, el cual comienza con 100 (ej: 102).
     * @return mensaje OK más objeto Orden, o BAD_REQUEST con null.
     */
    Respuesta listarOrdenPorId(String id);

    /**
     * Recupera la lista completa de órdenes.
     *
     * @return mensaje OK y List[Orden] o BAD_REQUEST con lista vacía.
     */
    Respuesta listarOrdenes();

    /**
     * Modifica una orden con los datos suministrados.
     *
     * @param id             Obligatorio, int identificatorio.
     * @param duenio         Obligatorio, String de 8 caracteres numéricos.
     * @param personal       Obligatorio, String de 8 caracteres numéricos.
     * @param estado         String, ('PENDIENTE','EN_EJECUCION','CONCRETADO','CANCELADO').
     * @param plastico       Float.
     * @param papel          Float.
     * @param vidrio         Float.
     * @param metal          Float.
     * @param vehiculoPesado Booleano.
     * @param observacion    String de hasta 160 caracteres.
     * @return mensaje OK o BAD_REQUEST si algún parámetro no cumple con los requisitos.
     */
    Respuesta modificarOrden(String id, String duenio, String personal, String estado, String plastico, String papel,
                             String vidrio, String metal, boolean vehiculoPesado, String observacion);

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
     * @return mensaje OK o BAD_REQUEST si algún parámetro no cumple con los requisitos.
     */
    Respuesta registrarOrden(String duenio, String plastico, String papel,
                             String vidrio, String metal, boolean vehiculoPesado, String observacion);

    /**
     * Elimina a un personal de la BD usando como identificador su número de documento.
     *
     * @param dni String de 8 caracteres numéricos.
     * @return mensaje OK o BAD_REQUEST si la entidad no es hallada.
     */
    Respuesta eliminarPersonal(String dni);

    /**
     * Recupera una lista filtrada del personal.
     *
     * @param valor String que filtra según nombre, apellido o documeto.
     * @return mensaje OK y List[Personal] o BAD_REQUEST con lista vacía.
     */
    Respuesta listarPersonalPor(String valor);

    /**
     * Recupera a un personal en específico usando como identificador un número de documento.
     *
     * @param dni String de 8 caracteres numéricos.
     * @return mensaje OK más objeto Personal, o BAD_REQUEST con null.
     */
    Respuesta listarPersonalPorId(String dni);

    /**
     * Recupera la lista completa del personal.
     *
     * @return mensaje OK y List[Personal] o BAD_REQUEST con lista vacía.
     */
    Respuesta listarPersonal();

    /**
     * Modifica un personal con los datos suministrados.
     *
     * @param nombre    Obligatorio.
     * @param apellido  Obligatorio.
     * @param documento Obligatorio, String de 8 caracteres numéricos.
     * @return mensaje OK o BAD_REQUEST si algún parámetro no cumple con los requisitos.
     */
    Respuesta modificarPersonal(String nombre, String apellido, String documento);

    /**
     * Registra un personal con los datos suministrados.
     *
     * @param nombre    Obligatorio.
     * @param apellido  Obligatorio.
     * @param documento Obligatorio, String de 8 caracteres numéricos.
     * @return mensaje OK o BAD_REQUEST si algún parámetro no cumple con los requisitos.
     */
    Respuesta registrarPersonal(String nombre, String apellido, String documento);

    /**
     * Recupera una lista de visitas asociada al número de órden.
     *
     * @param id String que representa un número de órden.
     * @return mensaje OK y List[Visita] o BAD_REQUEST con lista vacía.
     */
    Respuesta listarVisitasPorId(String id);

    /**
     * Agrega una visita a una orden, y actualiza el estado de la misma.
     *
     * @param orden       String numérico que representa el id de la órden.
     * @param estado      Enumeración,'PENDIENTE','EN_EJECUCION','CONCRETADO','CANCELADO'.
     * @param observacion String de hasta 160 caracteres.
     * @return mensaje OK o BAD_REQUEST si algún parámetro no cumple con los requisitos.
     */
    Respuesta registrarVisita(String orden, String estado, String observacion) throws SQLException;

    /**
     * Elimina una vivienda de la BD usando como identificador su número de id.
     *
     * @param id valor numérico.
     * @return mensaje OK o BAD_REQUEST si la entidad no es hallada.
     */
    Respuesta eliminarVivienda(String id);

    /**
     * Recupera una vivienda en específico usando como identificador el dni del duenio.
     *
     * @param id String de 8 caracteres numéricos.
     * @return mensaje OK más objeto Vivienda o BAD_REQUEST con null.
     */
    Respuesta listarViviendaPorId(String id);

    /**
     * Retorna la lista completa de viviendas.
     *
     * @return mensaje OK más objeto List[Vivienda] o BAD_REQUEST con lista vacía.
     */
    Respuesta listarViviendas();

    /**
     * @param id        Obligatorio, String de 8 caracteres numéricos. Debe coincidir con el dni del dueño.
     * @param duenio    Obligatorio, String de 8 caracteres numéricos.
     * @param direccion Obligatorio.
     * @param zona      String opcional.
     * @param barrio    Obligatorio.
     * @return mensaje OK o BAD_REQUEST si algún parámetro no cumple con los requisitos.
     */
    Respuesta modificarVivienda(String id, String duenio, String direccion, String zona, String barrio);

    /**
     * Registra la entidad con los datos que se suministren.
     *
     * @param id        Obligatorio, String de 8 caracteres numéricos que representa el documento del dueño.
     * @param direccion Obligatorio.
     * @param zona      Opcional.
     * @param barrio    Obligatorio.
     * @return mensaje OK o BAD_REQUEST si algún parámetro no cumple con los requisitos.
     */
    Respuesta registrarVivienda(String id, String direccion, String zona, String barrio);

    /**
     * Recupera a una ubicación con coordenadas de latitud y longitud usando como identificador un número de documento.
     *
     * @param id String de 8 caracteres numéricos.
     * @return mensaje OK más objeto Ubicacion, o BAD_REQUEST con null.
     */
    Respuesta listarUbicacionPorId(String id);

    /**
     * Registra una ubicación en coordenadas GPS. Debe ejecutarse al registrar una vivienda.
     *
     * @param latitud  double (ej -40.80485058962254).
     * @param longitud double (ej -63.012335681129805).
     * @return mensaje OK o BAD_REQUEST si algún parámetro no cumple con los requisitos.
     */
    Respuesta registrarUbicacion(String id, double latitud, double longitud);

    /**
     * Verifica que la dirección se corresponda a una coordenada GPS.
     *
     * @param id        Obligatorio, String de 8 caracteres numéricos que representa el documento del dueño.
     * @param direccion String obiligatorio.
     * @param barrio    String obiligatorio.
     * @return mensaje OK más objeto Coordenada o BAD_REQUEST con null.
     */
    Respuesta validarUbicacion(String id, String direccion, String barrio);
}
