package org.unrn.backend.controllers;

import org.unrn.backend.daos.PersonalDao;
import org.unrn.backend.dtos.InscripcionDto;
import org.unrn.backend.dtos.PersonalDto;
import org.unrn.entities.Personal;
import org.unrn.exceptions.PersonalIdNotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControladorPersonal {
    private final PersonalDao personalDao;
    private List<PersonalDto> lista;

    public ControladorPersonal() {
        personalDao = new PersonalDao();
    }

    public void eliminar(String dni) throws SQLException {
        if (personalDao.listarPorId(dni) == null) throw new PersonalIdNotFoundException(dni);
        personalDao.eliminar(dni);
    }

    public List<PersonalDto> listarPor(String valor) throws SQLException {
        if (lista == null) lista = listar();
        return lista.stream().filter(x -> x.comparacion().toLowerCase().contains(valor.toLowerCase())).toList();
    }

    public PersonalDto listarPorId(String dni) throws SQLException {
        return personalDao.listarPorId(dni);
    }

    public List<PersonalDto> listar() throws SQLException {
        List<Personal> lista = personalDao.listar();
        List<PersonalDto> listaDto = new ArrayList<>();
        for (Personal p : lista) {
            listaDto.add(new PersonalDto(p));
        }
        return listaDto;
    }

    public void modificar(String nombre, String apellido, String dni) throws SQLException {
        if (personalDao.listarPorId(dni) == null) throw new PersonalIdNotFoundException(dni);
        personalDao.modificar(nombre, apellido, dni);
    }

    public boolean registrar(String nombre, String apellido, String dni) throws SQLException {
        return personalDao.registrar(nombre, apellido, dni);
    }
}
