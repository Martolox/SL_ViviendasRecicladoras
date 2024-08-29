package controllers;

import daos.DuenioDao;
import daos.InscripcionDao;
import daos.ViviendaDao;
import dtos.InscripcionDto;
import entities.Inscripcion;
import exceptions.DuenioIdNotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControladorInscripcion {
    private final DuenioDao duenioDao;
    private final ViviendaDao viviendaDao;
    private final InscripcionDao inscripcionDao;
    private List<InscripcionDto> lista;

    public ControladorInscripcion() {
        duenioDao = new DuenioDao();
        viviendaDao = new ViviendaDao();
        inscripcionDao = new InscripcionDao();
    }

    public void eliminar(String dni) throws SQLException {
        if (duenioDao.listarPorId(dni) == null) throw new DuenioIdNotFoundException(dni);
        duenioDao.eliminar(dni);
    }

    public List<InscripcionDto> listarPor(String valor) throws SQLException {
        if (lista == null) lista = listar();
        return lista.stream().filter(x -> x.comparacion().toLowerCase().contains(valor.toLowerCase())).toList();
    }

    public List<InscripcionDto> listar() throws SQLException {
        List<Inscripcion> lista = inscripcionDao.listar();
        List<InscripcionDto> listaDto = new ArrayList<>();
        for (Inscripcion ins : lista) {
            listaDto.add(new InscripcionDto(ins));
        }
        for (int i = 0; i < listaDto.size(); i++) {
            listaDto.get(i).setId(i);
        }
        return listaDto;
    }

    public void modificar(String dni, String nombre, String apellido, String correo, String telefono, String direccion,
                          String zona, String barrio) throws SQLException {
        if (duenioDao.listarPorId(dni) == null) throw new DuenioIdNotFoundException(dni);
        duenioDao.modificar(nombre, apellido, dni, correo, telefono);
        viviendaDao.modificar(dni, direccion, zona, barrio);
    }

    public boolean registrar(String dni, String nombre, String apellido, String correo, String telefono, String direccion,
                             String zona, String barrio) throws SQLException {
        duenioDao.registrar(nombre, apellido, dni, correo, telefono);
        return viviendaDao.registrar(dni, direccion, zona, barrio);
    }
}
