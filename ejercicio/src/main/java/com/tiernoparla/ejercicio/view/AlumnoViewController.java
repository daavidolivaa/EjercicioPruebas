package com.tiernoparla.ejercicio.view;

import com.tiernoparla.ejercicio.controller.AlumnoController;
import com.tiernoparla.ejercicio.model.Alumno;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AlumnoViewController {

    @FXML private TextField nombreField;
    @FXML private TextField apellidosField;
    @FXML private TextField edadField;
    @FXML private TableView<Alumno> tablaAlumnos;
    @FXML private TableColumn<Alumno, String> colNombre;
    @FXML private TableColumn<Alumno, String> colApellidos;
    @FXML private TableColumn<Alumno, Integer> colEdad;

    private AlumnoController controller;

    public void setAlumnoController(AlumnoController controller) {
        this.controller = controller;

        tablaAlumnos.getItems().setAll(controller.listarAlumnos());
    }

    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        colApellidos.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getApellidos()));
        colEdad.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getEdad()));
    }

    @FXML
    public void insertarAlumno() {
        try {
            String nombre = nombreField.getText();
            String apellidos = apellidosField.getText();
            int edad = Integer.parseInt(edadField.getText());

            controller.crearAlumno(nombre, apellidos, edad);

            tablaAlumnos.getItems().setAll(controller.listarAlumnos());

            nombreField.clear();
            apellidosField.clear();
            edadField.clear();
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "La edad debe ser un número").showAndWait();
        }
    }
}
