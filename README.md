# EjercicioPruebas

## Introducción

Aplicación de escritorio en **JavaFX** para realizar pruebas básicas de interfaz y lógica en Java.
El proyecto incluye clases de ejemplo para organizar controladores, modelos y servicios, además de la vista en FXML.

## Herramientas utilizadas

* **Java 17+**
* **JavaFX** (21.0.2)
* **Maven**
* **JUnit 5**
* **Mockito**

## Estructura principal

* `App.java` → punto de entrada de la aplicación JavaFX
* `controller/` → controladores que gestionan la lógica de la interfaz
* `model/` → clases de entidades y capa de acceso a datos
* `service/` → capa de lógica de negocio
* `resources/fxml/` → vistas FXML para la interfaz gráfica
* `test/java/` → pruebas unitarias con JUnit y Mockito

## Repositorio

Para clonar el repositorio:

```bash
git clone https://github.com/daavidolivaa/EjercicioPruebas.git [nombre_de_la_carpeta]
```

## Nota

Al intentar ejecutar la aplicación aparece el error:

Error: JavaFX runtime components are missing, and are required to run this application

He estado buscando cómo solucionarlo pero de momento no he dado con la respuesta.
