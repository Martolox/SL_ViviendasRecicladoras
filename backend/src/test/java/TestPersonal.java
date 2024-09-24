import api.Despachador;
import exceptions.PersonalFieldInvalidException;
import exceptions.PersonalIdNotFoundException;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPersonal {
    private static final Despachador desp = new Despachador();

    @Test
    void TestEliminarPersonal() {
        try {
            desp.eliminarPersonal("12345678");
        } catch (PersonalFieldInvalidException | PersonalIdNotFoundException | NumberFormatException e) {
            System.out.println("BAD_REQUEST " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    @Test
    void TestListarPersonalPor() {
        try {
            var rta = desp.listarPersonalPor("J");
            assertEquals("Personal{nombre='Ana', apellido='Torres', DNI='23456789'}", rta.toString());
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    @Test
    void TestListarPersonalPorId() {
        try {
            var rta = desp.listarPersonalPorId("23456789");
            assertEquals("Personal{nombre='Ana', apellido='Torres', DNI='23456789'}", rta.toString());
        } catch (PersonalIdNotFoundException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    @Test
    void TestListarPersonal() {
        try {
            var rta = desp.listarPersonal();
            assertEquals("[Personal{nombre='Ana', apelli", rta.toString().substring(0, 30));
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    @Test
    void TestModificarPersonal() {
        try {
            desp.modificarPersonal("Juan", "Garcia", "12345678");
            System.out.println("Personal Modificado");
        } catch (PersonalFieldInvalidException | PersonalIdNotFoundException | NumberFormatException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    @Test
    void TestRegistrarPersonal() {
        try {
            desp.registrarPersonal("Juan", "Garcia", "12345678");
        } catch (PersonalFieldInvalidException e) {
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
