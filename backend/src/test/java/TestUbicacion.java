import api.Despachador;
import exceptions.*;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TestUbicacion {
    private static final Despachador desp = new Despachador();

    @Test
    void TestRegistrarUbicacion() {
        try {
            desp.registrarUbicacion("11112222", -41.11111111111111, -64.111111111111111);
        } catch (ViviendaFieldInvalidException | ViviendaEntityExistsException | DuenioIdNotFoundException |
                 NumberFormatException | UbicacionFieldInvalidException | UbicacionEntityExistsException e) {
            System.out.println("BAD_REQUEST " + e.getMessage());
        } catch (
                SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    @Test
    void TestValidarUbicacion() {
        try {
            desp.validarUbicacion("30237244", "Misiones Salesianas 123", "Zatti");
        } catch (DuenioIdNotFoundException | UbicacionFieldInvalidException e) {
            System.out.println("BAD_REQUEST " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }
}
