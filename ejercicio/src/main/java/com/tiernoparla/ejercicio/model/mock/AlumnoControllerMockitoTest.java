package com.tiernoparla.ejercicio.model.mock;

import com.tiernoparla.ejercicio.controller.AlumnoController;
import com.tiernoparla.ejercicio.model.Alumno;
import com.tiernoparla.ejercicio.model.database.AlumnoDAO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AlumnoControllerMockitoTest {

    @Test
    void crearAlumno_llamaAlDAO() {
        // Arrange
        AlumnoDAO mockDAO = Mockito.mock(AlumnoDAO.class);
        AlumnoController controller = new AlumnoController(mockDAO);

        // Act
        Alumno alumno = controller.crearAlumno("Juan", "Pérez", 20);

        // Assert
        verify(mockDAO, times(1)).insertar(alumno); // se llamó a insertar()
        assertEquals("Juan", alumno.getNombre());
    }

    @Test
    void listarAlumnos_devuelveListaDelDAO() {
        // Arrange
        AlumnoDAO mockDAO = Mockito.mock(AlumnoDAO.class);
        List<Alumno> alumnosFicticios = Arrays.asList(
                new Alumno("Ana", "García", 22),
                new Alumno("Luis", "López", 25)
        );
        when(mockDAO.listar()).thenReturn(alumnosFicticios);

        AlumnoController controller = new AlumnoController(mockDAO);

        // Act
        List<Alumno> resultado = controller.listarAlumnos();

        // Assert
        assertEquals(2, resultado.size());
        assertEquals("Ana", resultado.get(0).getNombre());
        verify(mockDAO, times(1)).listar(); // verificar que se llamó listar()
    }
}
