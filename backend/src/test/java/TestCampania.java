import api.Despachador;
import entities.Respuesta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCampania {
    private static final Despachador desp = new Despachador();

    @Test
    void TestCambiarPuntos() {
        Respuesta rta = desp.cambiarPuntos("30237244", "Beneficio 1");
        assertEquals("OK", rta.getEstado());
    }

    @Test
    void TestEliminarCampania() {
        Respuesta rta = desp.eliminarCampania("30237244");
        assertEquals("OK", rta.getEstado());
    }

    @Test
    void TestListarCampaniaPorId() {
        Respuesta rta = desp.listarCampaniaPorId("30300455");
        assertEquals("OK", rta.getEstado());
        assertEquals("Campania{duenio='30300455', puntos='190'," +
                " beneficios='Boleto gratis ida/vuelta a El Condor'}", rta.getObj().toString());
    }

    @Test
    void TestListarCampanias() {
        Respuesta rta = desp.listarCampanias();
        assertEquals("OK", rta.getEstado());
        assertEquals("[Campania{duenio='08335628', p", rta.getObj().toString().substring(0, 30));
    }

    @Test
    void TestModificarCampania() {
        Respuesta rta = desp.modificarCampania("30300455", 190, "Boleto gratis ida/vuelta a El Condor");
        assertEquals("OK", rta.getEstado());
    }

    @Test
    void TestRegistrarCampania() {
        Respuesta rta = desp.registrarCampania("30237244", 40, "Pedido de poda " +
                "y retiro de árboles gratis\nReducción de impuesto ABL");
        assertEquals("OK", rta.getEstado());
    }
}
