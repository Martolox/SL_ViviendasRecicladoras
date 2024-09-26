import api.Despachador;
import dtos.DuenioDto;
import exceptions.DuenioFieldInvalidException;
import exceptions.DuenioIdNotFoundException;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDuenio {
    private static final Despachador desp = new Despachador();

    @Test
    void TestEliminarDuenio() {
        try {
            desp.eliminarDuenio("30237244");
            ;
        } catch (DuenioFieldInvalidException | DuenioIdNotFoundException | NumberFormatException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    @Test
    void TestListarDuenioPorId() {
        try {
            DuenioDto d = desp.listarDuenioPorId("30300455");
            assertEquals("Duenio{nombre='Diego', apellido='Fernandez', DNI='30300455'}", d.toString());
        } catch (DuenioIdNotFoundException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    @Test
    void TestRegistrarDuenio() {
        try {
            desp.registrarDuenio("Javier", "Rodriguez", "30237244", "javier@hotmail.com", "2920000001");
        } catch (DuenioFieldInvalidException e) {
            System.out.println("Error de validación. ");
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry"))
                System.out.println("Error de duplicación. Ya existe un personal con ese documento");
            else {
                System.out.println("Error de conexión SQL: " + e);
            }
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }
}
