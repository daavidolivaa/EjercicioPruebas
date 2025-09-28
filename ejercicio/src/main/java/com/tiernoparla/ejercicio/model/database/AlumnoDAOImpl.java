package com.tiernoparla.ejercicio.model.database;

import java.util.ArrayList;
import java.util.List;

import com.tiernoparla.ejercicio.model.Alumno;

public class AlumnoDAOImpl implements AlumnoDAO {

    private final List<Alumno> alumnos = new ArrayList<>();

    @Override
    public void insertar(Alumno alumno) {
        alumnos.add(alumno);
    }

    @Override
    public List<Alumno> listar() {
        return new ArrayList<>(alumnos);
    }
}
