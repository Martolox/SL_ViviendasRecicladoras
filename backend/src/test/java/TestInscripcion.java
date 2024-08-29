import api.Despachador;
import entities.Respuesta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInscripcion {
    private static final Despachador desp = new Despachador();

    @Test
    void TestEliminarInscripcion() {
        Respuesta rta = desp.eliminarInscripcion("12341234");
        assertEquals("OK", rta.getEstado());
    }

    @Test
    void TestListarInscripcionPor() {
        Respuesta rta = desp.listarInscripcionPor("J");
        assertEquals("OK", rta.getEstado());
        assertEquals("[Inscripcion{documento='302372", rta.getObj().toString().substring(0, 30));
    }

    @Test
    void TestListarInscripciones() {
        Respuesta rta = desp.listarInscripciones();
        assertEquals("OK", rta.getEstado());
        assertEquals("[Inscripcion{documento='303004", rta.getObj().toString().substring(0, 30));
    }

    @Test
    void TestModificarInscripcion() {
        Respuesta rta = desp.modificarInscripcion("30029911", "Luis", "Martinez",
                "luis@hotmail.com", "2920000003", "7 de Marzo 630", "Centro", "Fátima");
        assertEquals("OK", rta.getEstado());
    }

    @Test
    void TestRegistrarInscripcion() {
        Respuesta rta = desp.registrarInscripcion("30237244", "Javier", "Rodriguez",
                "javier@hotmail.com", "2920000001", "7 de Marzo 630", "Centro", "Fátima");
        assertEquals("OK", rta.getEstado());
    }
}
