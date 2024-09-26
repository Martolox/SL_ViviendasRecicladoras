import api.Despachador;
import exceptions.DuenioIdNotFoundException;
import exceptions.InscripcionFieldInvalidException;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInscripcion {
    private static final Despachador desp = new Despachador();

    @Test
    void TestListarInscripcionPor() {
        try {
            var rta = desp.listarInscripcionPor("J");
            assertEquals("[Inscripcion{documento='302372", rta.toString().substring(0, 30));
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    @Test
    void TestListarInscripciones() {
        try {
            var rta = desp.listarInscripciones();
            assertEquals("[Inscripcion{documento='303004", rta.toString().substring(0, 30));

        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    @Test
    void TestModificarInscripcion() {
        try {
            desp.modificarInscripcion("30029911", "Luis", "Martinez", "luis@hotmail.com", "2920000003", "7 de Marzo 630", "Centro", "Fátima");
        } catch (InscripcionFieldInvalidException | DuenioIdNotFoundException | NumberFormatException e) {
            System.out.println("BAD_REQUEST " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }
}
