import api.Despachador;
import entities.Respuesta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUbicacion {
    private static final Despachador desp = new Despachador();

    @Test
    void TestListarUbicacionPorId() {
        Respuesta rta = desp.listarUbicacionPorId("30300455");
        assertEquals("OK", rta.getEstado());
        assertEquals("{Lat='-40.8096612612647', Long='-63.00209613467383'}", rta.getObj().toString());
    }

    @Test
    void TestRegistrarUbicacion() {
        Respuesta rta = desp.registrarUbicacion("11112222", -41.11111111111111, -64.111111111111111);
        assertEquals("OK", rta.getEstado());
    }

    @Test
    void TestValidarUbicacion() {
        Respuesta rta = desp.validarUbicacion("30237244", "Misiones Salesianas 123", "Zatti");
        assertEquals("OK", rta.getEstado());
    }
}
