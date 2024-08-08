package org.unrn;

import org.junit.jupiter.api.Test;
import org.unrn.backend.api.Despachador;
import org.unrn.entities.Respuesta;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrden {
    private static final Despachador desp = new Despachador();

    @Test
    void TestEliminarOrden() {
        Respuesta rta = desp.eliminarOrden("101");
        assertEquals("OK", rta.getEstado());
    }

    @Test
    void TestListarOrdenPor() {
        Respuesta rta = desp.listarOrdenPor("EN");
        assertEquals("OK", rta.getEstado());
        assertEquals("[Orden{id='103', duenio='30029", rta.getObj().toString().substring(0, 30));
    }

    @Test
    void TestListarOrdenPorId() {
        Respuesta rta = desp.listarOrdenPorId("102");
        assertEquals("OK", rta.getEstado());
        assertEquals("Orden{id='102', duenio='30300455', personal='23456789', fecha='2024-05-30 17:14:28'}", rta.getObj().toString());
    }

    @Test
    void TestListarOrdenes() {
        Respuesta rta = desp.listarOrdenes();
        assertEquals("OK", rta.getEstado());
        assertEquals("[Orden{id='101', duenio='30237", rta.getObj().toString().substring(0, 30));
    }

    @Test
    void TestModificarOrden() {
        Respuesta rta = desp.modificarOrden("101", "30300455", "23456789", "CANCELADO",
                "3.0", "5.0", "27.0", "", true, "Ninguna observacion");
        assertEquals("OK", rta.getEstado());
    }

    @Test
    void TestRegistrarOrden() {
        Respuesta rta = desp.registrarOrden("30237244", "5.5", "15.0",
                "2.0", "0", false, "");
        assertEquals("OK", rta.getEstado());
    }
}
