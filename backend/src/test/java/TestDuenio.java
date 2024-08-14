import api.Despachador;
import entities.Respuesta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDuenio {
    private static final Despachador desp = new Despachador();

    @Test
    void TestEliminarDuenio() {
        Respuesta rta = desp.eliminarDuenio("30237244");
        assertEquals("OK", rta.getEstado());
    }

    @Test
    void TestListarDuenioPorId() {
        Respuesta rta = desp.listarDuenioPorId("30300455");
        assertEquals("OK", rta.getEstado());
        assertEquals("Duenio{nombre='Diego', apellido='Fernandez', DNI='30300455'}", rta.getObj().toString());
    }

    @Test
    void TestListarDuenios() {
        Respuesta rta = desp.listarDuenios();
        assertEquals("OK", rta.getEstado());
        assertEquals("[Duenio{nombre='Mario', apelli", rta.getObj().toString().substring(0, 30));
    }

    @Test
    void TestModificarDuenio() {
        Respuesta rta = desp.modificarDuenio("Luis", "Martinez", "30029911", "luis@hotmail.com", "2920000003");
        assertEquals("OK", rta.getEstado());
    }

    @Test
    void TestRegistrarDuenio() {
        Respuesta rta = desp.registrarDuenio("Javier", "Rodriguez", "30237244", "javier@hotmail.com", "2920000001");
        assertEquals("OK", rta.getEstado());
    }
}
