import api.Despachador;
import entities.Respuesta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPersonal {
    private static final Despachador desp = new Despachador();

    @Test
    void TestEliminarPersonal() {
        Respuesta rta = desp.eliminarPersonal("12345678");
        assertEquals("OK", rta.getEstado());
    }

    @Test
    void TestEliminarPersonal_FaltanDatos() {
        Respuesta rta = desp.eliminarPersonal("");
        assertEquals("BAD_REQUEST Campo obligatorio inválido: documento", rta.getEstado());
    }

    @Test
    void TestEliminarPersonal_DocNoEncontrado() {
        Respuesta rta = desp.eliminarPersonal("00000000");
        assertEquals("BAD_REQUEST El id indicado no fue encontrado, 00000000", rta.getEstado());
    }

    @Test
    void TestEliminarPersonal_DocLongErronea() {
        Respuesta rta = desp.eliminarPersonal("123456789");
        assertEquals("BAD_REQUEST Campo obligatorio inválido: documento", rta.getEstado());
    }

    @Test
    void TestListarPersonalPor() {
        Respuesta rta = desp.listarPersonalPor("J");
        assertEquals("OK", rta.getEstado());
        assertEquals("Personal{nombre='Ana', apellido='Torres', DNI='23456789'}", rta.getObj().toString());
    }

    @Test
    void TestListarPersonalPorId() {
        Respuesta rta = desp.listarPersonalPorId("23456789");
        assertEquals("OK", rta.getEstado());
        assertEquals("Personal{nombre='Ana', apellido='Torres', DNI='23456789'}", rta.getObj().toString());
    }

    @Test
    void TestListarPersonal() {
        Respuesta rta = desp.listarPersonal();
        assertEquals("OK", rta.getEstado());
        assertEquals("[Personal{nombre='Ana', apelli", rta.getObj().toString().substring(0, 30));
    }

    @Test
    void TestModificarPersonal() {
        Respuesta rta = desp.modificarPersonal("Juan", "Garcia", "12345678");
        assertEquals("OK", rta.getEstado());
    }

    @Test
    void TestModificarPersonal_DocNoEncontrado() {
        Respuesta rta = desp.modificarPersonal("Juan", "Garcia", "12345678");
        assertEquals("OK", rta.getEstado());
    }

    @Test
    void TestRegistrarPersonal() {
        Respuesta rta = desp.registrarPersonal("Juan", "Garcia", "12345678");
        assertEquals("OK", rta.getEstado());
    }

    @Test
    void TestRegistrarPersonal_FaltanDatos() {
        Respuesta rta = desp.registrarPersonal("", "Garcia", "12345678");
        assertEquals("BAD_REQUEST org.unrn.exceptions.PersonalFieldInvalidException:" +
                " Campo obligatorio inválido: nombre", rta.getEstado());
    }

    @Test
    void TestRegistrarPersonal_DocNoNumerico() {
        Respuesta rta = desp.registrarPersonal("Juan", "Garcia", "a2345678");
        assertEquals("BAD_REQUEST java.lang.NumberFormatException:" +
                " For input string: \"a2345678\"", rta.getEstado());
    }

    @Test
    void TestRegistrarPersonal_DocLongErronea() {
        Respuesta rta = desp.registrarPersonal("Juan", "Garcia", "123456789");
        assertEquals("BAD_REQUEST org.unrn.exceptions.PersonalFieldInvalidException:" +
                " Campo obligatorio inválido: documento", rta.getEstado());
    }

    @Test
    void TestRegistrarPersonal_IdDuplicado() {
        Respuesta rta = desp.registrarPersonal("", "Garcia", "12345678");
        assertEquals("BAD_REQUEST org.unrn.exceptions.PersonalFieldInvalidException:" +
                " Campo obligatorio inválido: nombre", rta.getEstado());
    }
}
