package org.unrn;

import org.junit.jupiter.api.Test;
import org.unrn.backend.api.Despachador;
import org.unrn.entities.Respuesta;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVivienda {
    private static final Despachador desp = new Despachador();

    @Test
    void TestEliminarVivienda() {
        Respuesta rta = desp.eliminarVivienda("30237244");
        assertEquals("OK", rta.getEstado());
    }

    @Test
    void TestListarViviendaPorId() {
        Respuesta rta = desp.listarViviendaPorId("30300455");
        assertEquals("OK", rta.getEstado());
        assertEquals("Vivienda{id='30300455', documento='30300455', direccion='Moreno 1053', barrio='Belgrano'}", rta.getObj().toString());
    }

    @Test
    void TestListarViviendas() {
        Respuesta rta = desp.listarViviendas();
        assertEquals("OK", rta.getEstado());
        assertEquals("[Vivienda{id='08335628', docum", rta.getObj().toString().substring(0, 30));
    }

    @Test
    void TestModificarVivienda() {
        Respuesta rta = desp.modificarVivienda("30300455", "30300455", "Moreno 1054", "Centro", "Belgrano");
        assertEquals("OK", rta.getEstado());
    }

    @Test
    void TestRegistrarVivienda() {
        Respuesta rta = desp.registrarVivienda("30237244", "Salvo P. M. 53", "Norte", "San Martin");
        assertEquals("OK", rta.getEstado());
    }
}
