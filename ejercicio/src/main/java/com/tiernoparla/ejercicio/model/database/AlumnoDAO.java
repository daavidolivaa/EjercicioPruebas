package com.tiernoparla.ejercicio.model.database;

import java.util.List;

import com.tiernoparla.ejercicio.model.Alumno;

public interface AlumnoDAO {
    
    void insertar(Alumno alumno);
    List<Alumno> listar();
}