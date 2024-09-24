import api.Despachador;
import exceptions.PersonalIdNotFoundException;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCampania {
    private static final Despachador desp = new Despachador();

    @Test
    void TestCambiarPuntos() {
        try {
            desp.cambiarPuntos("30237244", "Beneficio 1");
        } catch (PersonalIdNotFoundException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    @Test
    void TestListarCampaniaPorId() {
        try {
            var rta = desp.listarCampaniaPorId("30300455");
            assertEquals("Campania{duenio='30300455', puntos='190'," +
                    " beneficios='Boleto gratis ida/vuelta a El Condor'}", rta.toString());
        } catch (PersonalIdNotFoundException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }
}
