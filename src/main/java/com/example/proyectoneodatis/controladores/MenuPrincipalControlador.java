package com.example.proyectoneodatis.controladores;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import com.example.proyectoneodatis.App;
import com.example.proyectoneodatis.Modelo.Articulo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

public class MenuPrincipalControlador {

    @FXML
    public void initialize(){


    }

    @FXML
    public void gestionarArticulosOnAction(ActionEvent actionEvent) {
        try {
            App.loadFXML("camposArticulos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void exportarArticulosOnAction(ActionEvent actionEvent) {


        ODB odb = ODBFactory.open("Neodatis.test");
        try{
            Objects<Articulo> articulos = odb.getObjects(Articulo.class);
            List<Articulo> listaArticulos = new ArrayList<>();
            while (articulos.hasNext()) {
                listaArticulos.add(articulos.next());

            }
            System.out.println(listaArticulos.toString());
            String fechaHoraActual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss"));
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
            fileChooser.setInitialFileName("articulos_" + fechaHoraActual + ".json");
            File archivoSeleccionado = fileChooser.showSaveDialog(null);

            if (archivoSeleccionado != null) {

                exportarAJson(listaArticulos,archivoSeleccionado);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setHeaderText("Exportación Exitosa");
                alert.setContentText("Los artículos se han exportado correctamente a: " + archivoSeleccionado.getAbsolutePath());
                alert.showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error exportando los artículos: " + e.getMessage());
        } finally {

            if (odb != null) {
                odb.close();
            }
        }

    }

    public void exportarAJson(List<Articulo> listaArticulos,File archivoSalida){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida))) {
            writer.write("[\n");
            for (int i = 0; i < listaArticulos.size(); i++) {
                Articulo art = listaArticulos.get(i);
                String articuloJson = String.format(
                        "  {\n" +
                                "    \"codigo\": %d,\n" +
                                "    \"denominacion\": \"%s\",\n" +
                                "    \"pvp\": %.2f,\n" +
                                "    \"categoria\": \"%s\",\n" +
                                "    \"uv\": %.2f,\n" +
                                "    \"stock\": %d\n" +
                                "  }",
                        art.getCodigo(),
                        art.getDenominacion(),
                        art.getPrecioDeVentaAlPublico(),
                        art.getCategoria(),
                        art.getUnidadesVendidas(),
                        art.getStock()
                );
                writer.write(articuloJson);
                if (i < listaArticulos.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]\n");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error escribiendo el archivo JSON: " + e.getMessage());
        }
    }

    @FXML
    public void importarArticulosOnAction(ActionEvent actionEvent) {



    }

    @FXML
    public void cerrarSesionOnAction(ActionEvent actionEvent) {
        try {
            App.setRoot("inicio");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cambiarContrasenaOnAction(ActionEvent actionEvent) throws IOException {
        App.setRoot("cambiarContrasena");
    }

}
