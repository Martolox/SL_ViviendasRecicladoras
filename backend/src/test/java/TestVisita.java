import api.Despachador;
import exceptions.PersonalIdNotFoundException;
import exceptions.UbicacionIdNotFoundException;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVisita {
    private static final Despachador desp = new Despachador();

    @Test
    void TestListarVisitasPorId() {
        try {
            var rta = desp.listarVisitasPorId("101");
            assertEquals("[Visita{id='101', fecha='2024-", rta.toString().substring(0, 30));
        } catch (
                PersonalIdNotFoundException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    @Test
    void TestRegistrarVisita() {
        try {
            desp.registrarVisita("102", "EN_EJECUCION", "Ninguna observacion");
        } catch (UbicacionIdNotFoundException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }
}
