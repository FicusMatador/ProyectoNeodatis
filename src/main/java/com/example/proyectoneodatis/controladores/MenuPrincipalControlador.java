package com.example.proyectoneodatis.controladores;

import com.example.proyectoneodatis.App;
import javafx.event.ActionEvent;

import java.io.IOException;

public class MenuPrincipalControlador {
    public void gestionarArticulosOnAction(ActionEvent actionEvent) throws IOException {
        App.setRoot("listados");
    }

    public void exportarArticulosOnAction(ActionEvent actionEvent) {

    }

    public void importarArticulosOnAction(ActionEvent actionEvent) {


    }

    public void cerrarSesionOnAction(ActionEvent actionEvent) throws IOException {
        App.setRoot("inicio");
    }

    public void cambiarContrasenaOnAction(ActionEvent actionEvent) throws IOException {
        App.setRoot("cambiarContrasena");
    }
}
