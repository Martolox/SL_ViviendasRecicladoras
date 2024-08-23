package controllers;

import daos.OrdenDao;
import daos.PersonalDao;
import dtos.OrdenDto;
import entities.Orden;
import exceptions.OrdenIdNotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ControladorOrden {
    private final OrdenDao ordenDao;
    private final PersonalDao personalDao;
    private List<OrdenDto> lista;

    public ControladorOrden() {
        ordenDao = new OrdenDao();
        personalDao = new PersonalDao();
    }

    public void eliminar(int id) throws SQLException {
        if (ordenDao.listarPorId(id) == null) throw new OrdenIdNotFoundException(id);
        ordenDao.eliminar(id);
    }

    public List<OrdenDto> listarPor(String valor) throws SQLException {
        if (lista == null) lista = listar();
        return lista.stream().filter(x -> x.comparacion().toLowerCase().contains(valor.toLowerCase())).toList();
    }

    public OrdenDto listarPorId(int id) throws SQLException {
        return ordenDao.listarPorId(id);
    }

    public List<OrdenDto> listar() throws SQLException {
        List<Orden> lista = ordenDao.listar();
        List<OrdenDto> listaDto = new ArrayList<>();
        for (Orden o : lista) {
            listaDto.add(new OrdenDto(o));
        }
        return listaDto;
    }

    public String listarOrdenesMC(String dni) throws SQLException {
        List<OrdenDto> lista = listarPor(dni);
        String txt = "";
        int i = 1;
        for (OrdenDto o : lista) {
            System.out.println(o);
            if (o.getEstado().equals("EN_EJECUCION") || o.getEstado().equals("PENDIENTE")) {
                txt += String.format("Orden %d - Fecha:%s - Estado:%s", i, o.getFecha(), o.getEstado());
                i++;
                System.out.println(txt);
            }
        }
        return txt;
    }

    public void modificar(int id, String duenio, String personal, String estado, float plastico,
                          float papel, float vidrio, float metal, boolean vehiculoPesado, String observacion)
            throws SQLException {
        if (ordenDao.listarPorId(id) == null) throw new OrdenIdNotFoundException(id);
        ordenDao.modificar(id, duenio, personal, estado, plastico, papel, vidrio, metal, vehiculoPesado, observacion);
    }

    public boolean registrar(String duenio, float plastico,
                             float papel, float vidrio, float metal, boolean vehiculoPesado, String observacion)
            throws SQLException {
        var lista = personalDao.listar();
        Random rand = new Random();
        String personal = lista.get(rand.nextInt(lista.size())).getDocPersonal();
        return ordenDao.registrar(duenio, personal, "PENDIENTE", plastico, papel, vidrio, metal, vehiculoPesado, observacion);
    }
}
