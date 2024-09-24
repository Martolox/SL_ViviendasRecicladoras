import api.Despachador;
import exceptions.DuenioIdNotFoundException;
import exceptions.OrdenEntityExistsException;
import exceptions.OrdenFieldInvalidException;
import exceptions.PersonalIdNotFoundException;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrden {
    private static final Despachador desp = new Despachador();

    @Test
    void TestListarOrdenPor() {
        try {
            var rta = desp.listarOrdenPor("EN");
            assertEquals("[Orden{id='103', duenio='30029", rta.toString().substring(0, 30));
        } catch (NumberFormatException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    @Test
    void TestListarOrdenes() {
        try {
            var rta = desp.listarOrdenes();
            assertEquals("[Orden{id='101', duenio='30237", rta.toString().substring(0, 30));
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    @Test
    void TestRegistrarOrden() {
        try {
            desp.registrarOrden("30237244", "5.5", "15.0", "2.0", "0", false, "");
        } catch (OrdenFieldInvalidException | OrdenEntityExistsException |
                 DuenioIdNotFoundException | PersonalIdNotFoundException | NumberFormatException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (
                SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }
}
