package com.example.proyectoneodatis.controladores;

import com.example.proyectoneodatis.Modelo.Constantes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

public class CambiarContrasenaControlador {

    @FXML
    PasswordField contrasenaVieja,contrasenaNueva,contrasenaNueva2;

    @FXML
    Text contrasenaCoincidir,camposVacios,contrasenaAntigua;

    public void initialize(){
        contrasenaCoincidir.setVisible(false);
        camposVacios.setVisible(false);
        contrasenaAntigua.setVisible(false);

    }
    public void cambiarContrasenaOnAction(ActionEvent event) {
        initialize();
        if (contrasenaVieja.getText().isEmpty() || contrasenaNueva.getText().isEmpty() || contrasenaNueva2.getText().isEmpty()) {
            camposVacios.setVisible(true);
            return;
        }
        if (!contrasenaNueva.getText().equals(contrasenaNueva2.getText())) {
            contrasenaCoincidir.setVisible(true);
            return;
        }
        if (contrasenaAntigua.getText().equals(Constantes.CONTRASENA)) {
            contrasenaCoincidir.setVisible(true);
            return;
        }

    }
}
