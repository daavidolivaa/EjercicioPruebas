package com.tiernoparla.ejercicio.controller;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.tiernoparla.ejercicio.model.Alumno;

class AlumnoControllerTest {

    @Test
    void crearAlumno_y_listar() {
        AlumnoController controller = new AlumnoController();

        controller.crearAlumno("Juan", "Pérez", 20);
        controller.crearAlumno("Ana", "García", 22);

        List<Alumno> alumnos = controller.listarAlumnos();

        assertEquals(2, alumnos.size());
        assertEquals("Juan", alumnos.get(0).getNombre());
    }
}
