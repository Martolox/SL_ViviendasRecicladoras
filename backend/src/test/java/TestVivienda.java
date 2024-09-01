import api.Despachador;
import exceptions.DuenioIdNotFoundException;
import exceptions.ViviendaEntityExistsException;
import exceptions.ViviendaFieldInvalidException;
import exceptions.ViviendaIdNotFoundException;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVivienda {
    private static final Despachador desp = new Despachador();

    @Test
    void TestListarViviendaPorId() {
        try {
            var rta = desp.listarViviendaPorId("30300455");
            assertEquals("Vivienda{id='30300455', documento='30300455', direccion='Moreno 1053', barrio='Belgrano'}", rta.toString());
        } catch (ViviendaIdNotFoundException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    @Test
    void TestRegistrarVivienda() {
        try {
            desp.registrarVivienda("30237244", "Salvo P. M. 53", "Norte", "San Martin");
        } catch (ViviendaFieldInvalidException | ViviendaEntityExistsException |
                 DuenioIdNotFoundException | NumberFormatException e) {
            System.out.println("BAD_REQUEST " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }
}
