package com.tiernoparla.ejercicio.controller;

import java.io.IOException;
import java.util.List;

import com.tiernoparla.ejercicio.App;
import com.tiernoparla.ejercicio.model.Alumno;
import com.tiernoparla.ejercicio.model.database.AlumnoDAO;
import com.tiernoparla.ejercicio.model.database.AlumnoDAOImpl;
import com.tiernoparla.ejercicio.view.AlumnoViewController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlumnoController extends Application {

    private static final String VIEW_MAIN = "view/alumnoView.fxml";
    private AlumnoDAO model;

    public AlumnoController() {}

    public AlumnoController(AlumnoDAO mockDAO) {
        this.model = mockDAO;
    }

    @Override
    public void start(Stage stage) throws IOException {
        if (model == null) {
            model = new AlumnoDAOImpl();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(VIEW_MAIN));
        Parent root = fxmlLoader.load();

        AlumnoViewController viewController = fxmlLoader.getController();
        viewController.setAlumnoController(this);

        stage.setTitle("Gestión de Alumnos");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public Alumno crearAlumno(String nombre, String apellidos, int edad) {
        Alumno alumno = new Alumno(nombre, apellidos, edad);
        model.insertar(alumno);
        return alumno;
    }

    public List<Alumno> listarAlumnos() {
        return model.listar();
    }
}
