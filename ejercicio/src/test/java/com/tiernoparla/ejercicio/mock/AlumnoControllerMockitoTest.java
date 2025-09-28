package com.tiernoparla.ejercicio.mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.tiernoparla.ejercicio.controller.AlumnoController;
import com.tiernoparla.ejercicio.model.Alumno;
import com.tiernoparla.ejercicio.model.database.AlumnoDAO;

class AlumnoControllerMockitoTest {

    @Test
    void crearAlumno_llamaAlDAO() {

        AlumnoDAO mockDAO = Mockito.mock(AlumnoDAO.class);
        AlumnoController controller = new AlumnoController(mockDAO);

        Alumno alumno = controller.crearAlumno("Juan", "Pérez", 20);

        verify(mockDAO, times(1)).insertar(alumno);
        assertEquals("Juan", alumno.getNombre());
    }

    @Test
    void listarAlumnos_devuelveListaDelDAO() {

        AlumnoDAO mockDAO = Mockito.mock(AlumnoDAO.class);
        List<Alumno> alumnosFicticios = Arrays.asList(
                new Alumno("Ana", "García", 22),
                new Alumno("Luis", "López", 25)
        );
        when(mockDAO.listar()).thenReturn(alumnosFicticios);

        AlumnoController controller = new AlumnoController(mockDAO);

        List<Alumno> resultado = controller.listarAlumnos();

        assertEquals(2, resultado.size());
        assertEquals("Ana", resultado.get(0).getNombre());
        verify(mockDAO, times(1)).listar();
    }
}
