package com.example.proyectoneodatis;

import com.example.proyectoneodatis.Modelo.Constantes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    public static File contrasenaInicioFile = new File("contrasenaFile");

    @Override
    public void start(Stage stage) throws IOException {
        if (contrasenaInicioFile.exists() && contrasenaInicioFile.length() > 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(contrasenaInicioFile))) {
                String contenido = reader.readLine();
                if (contenido != null && !contenido.trim().isEmpty()) {
                    Constantes.CONTRASENA = contenido.trim();
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo de contraseña: " + e.getMessage());
            }
        }
        // Cargar la primera escena
        scene = new Scene(loadFXML("inicio"), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("App");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}