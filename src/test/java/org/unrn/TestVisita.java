package org.unrn;

import org.junit.jupiter.api.Test;
import org.unrn.backend.api.Despachador;
import org.unrn.entities.Respuesta;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVisita {
    private static final Despachador desp = new Despachador();

    @Test
    void TestListarVisitasPorId() {
        Respuesta rta = desp.listarVisitasPorId("101");
        assertEquals("OK", rta.getEstado());
        assertEquals("[Visita{id='101', fecha='2024-", rta.getObj().toString().substring(0, 30));
    }

    @Test
    void TestRegistrarVisita() {
        Respuesta rta = desp.registrarVisita("102", "EN_EJECUCION", "Ninguna observacion");
        assertEquals("OK", rta.getEstado());
    }
}
