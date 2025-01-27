package com.example.proyectoneodatis.controladores;

import com.example.proyectoneodatis.App;
import com.example.proyectoneodatis.Modelo.Constantes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static com.example.proyectoneodatis.App.contrasenaInicioFile;

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
    public void cambiarContrasenaOnAction(ActionEvent event) throws IOException {
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
        Constantes.CONTRASENA = contrasenaNueva.getText();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(contrasenaInicioFile))) {
            writer.write(Constantes.CONTRASENA);
            writer.flush();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cambio de Contraseña");
            alert.setHeaderText(null);
            alert.setContentText("La contraseña ha sido cambiada exitosamente.");
            alert.showAndWait();
        } catch (IOException e) {
            System.err.println("Error al escribir la nueva contraseña en el archivo: " + e.getMessage());
        }
        App.setRoot("inicio");

    }

}

