package controllers;

import daos.CampaniaDao;
import dtos.CampaniaDto;
import entities.Campania;
import exceptions.CampaniaIdNotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControladorCampania {
    private final CampaniaDao campaniaDao;
    private final Map<String, Integer> puntaje;
    private final Map<String, String> descripcion;

    public ControladorCampania() {
        campaniaDao = new CampaniaDao();
        puntaje = new HashMap<>();
        puntaje.put("Beneficio 1", 30);
        puntaje.put("Beneficio 2", 50);
        puntaje.put("Beneficio 3", 20);
        puntaje.put("Beneficio 4", 80);
        descripcion = new HashMap<>();
        descripcion.put("Beneficio 1", "Reducción de impuesto ABL - 15%");
        descripcion.put("Beneficio 2", "Descuento de 50% en talleres brindados por el municipio.");
        descripcion.put("Beneficio 3", "Boleto grátis ida/vuelta a El Cóndor.");
        descripcion.put("Beneficio 4", "Pedido de poda y retiro de árboles gratis.");
    }

    public void cambiarPuntos(String id, String beneficio) throws SQLException {
        CampaniaDto camp = new CampaniaDto(campaniaDao.listarPorId(id));
        if (camp.getPuntos() > puntaje.get(beneficio)) {
            int puntos = camp.getPuntos() - puntaje.get(beneficio);
            String nuevoBenef = camp.getBeneficios() + "\n" + descripcion.get(beneficio);
            System.out.println(nuevoBenef);
            campaniaDao.modificar(id, puntos, nuevoBenef);
        }
    }

    public void eliminar(String id) throws SQLException {
        if (campaniaDao.listarPorId(id) == null) throw new CampaniaIdNotFoundException(id);
        campaniaDao.eliminar(id);
    }

    public CampaniaDto listarPorId(String id) throws SQLException {
        return new CampaniaDto(campaniaDao.listarPorId(id));
    }

    public List<CampaniaDto> listar() throws SQLException {
        List<Campania> lista = campaniaDao.listar();
        List<CampaniaDto> listaDto = new ArrayList<>();
        for (Campania c : lista) {
            listaDto.add(new CampaniaDto(c));
        }
        return listaDto;
    }

    public void modificar(String id, int puntos, String beneficios) throws SQLException {
        if (campaniaDao.listarPorId(id) == null) throw new CampaniaIdNotFoundException(id);
        campaniaDao.modificar(id, puntos, beneficios);
    }

    public boolean registrar(String id, int puntos, String beneficios) throws SQLException {
        return campaniaDao.registrar(id, puntos, beneficios);
    }
}
