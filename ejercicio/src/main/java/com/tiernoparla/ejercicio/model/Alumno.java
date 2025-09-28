package com.tiernoparla.ejercicio.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
    private String nombre;
    private String apellidos;
    private int edad;
}
