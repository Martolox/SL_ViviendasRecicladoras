package org.unrn.backend.controllers;

import org.unrn.backend.daos.DuenioDao;
import org.unrn.backend.daos.InscripcionDao;
import org.unrn.backend.daos.ViviendaDao;
import org.unrn.backend.dtos.InscripcionDto;
import org.unrn.entities.Inscripcion;
import org.unrn.exceptions.DuenioIdNotFoundException;

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

    public InscripcionDto listarPorId(String dni) throws SQLException {
//        DuenioDto d = duenioDao.listarPorId(dni);
//        ViviendaDto v = viviendaDao.listarPorId(dni);
//        UbicacionDto u = ubicacionDao.listarPorId(dni);
//        String ubicacion = String.format("%s:%s", u.getLatitud(), u.getLongitud());
//        return new InscripcionDto(dni, d.getNomDuenio(), d.getApeDuenio(), d.getCorreoDuenio(), d.getTelDuenio(),
//                v.getDireccion(), v.getZona(), v.getBarrio(), ubicacion, d.getFechaReg());
        return null;
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
                          String zona, String barrio)
            throws SQLException {
        if (duenioDao.listarPorId(dni) == null) throw new DuenioIdNotFoundException(dni);
        duenioDao.modificar(nombre, apellido, dni, correo, telefono);
        viviendaDao.modificar(dni, direccion, zona, barrio);
    }

    public boolean registrar(String dni, String nombre, String apellido, String correo, String telefono, String direccion,
                             String zona, String barrio)
            throws SQLException {
        duenioDao.registrar(nombre, apellido, dni, correo, telefono);
        return viviendaDao.registrar(dni, direccion, zona, barrio);
    }
}
