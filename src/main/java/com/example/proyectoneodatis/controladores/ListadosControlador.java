package com.example.proyectoneodatis.controladores;

import com.example.proyectoneodatis.App;
import com.example.proyectoneodatis.Modelo.Articulo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.proyectoneodatis.App.articulos;

public class ListadosControlador{
    @FXML
    private TableView<Articulo> tablaArticulos;

    @FXML
    private TableColumn<Articulo, Integer> colCodigo;

    @FXML
    private TableColumn<Articulo, String> colDenominacion;

    @FXML
    private TableColumn<Articulo, Double> colPrecio;

    @FXML
    private TableColumn<Articulo, String> colCategoria;


    @FXML
    private TableColumn<Articulo, Integer> colUnidadesVendidas;

    @FXML
    private TableColumn<Articulo, Integer> colStock;

    private ObservableList<Articulo> listaArticulos;
    
    ODB odb = ODBFactory.open("neonatis.test");

    @FXML
    public void initialize() {
        // Configurar las columnas
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colDenominacion.setCellValueFactory(new PropertyValueFactory<>("denominacion"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precioDeVentaAlPublico"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colUnidadesVendidas.setCellValueFactory(new PropertyValueFactory<>("unidadesVendidas"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        // Si la base de datos estuviera vacia, se agregan los artículos
        if (!odb.getObjects(Articulo.class).isEmpty()) {
            listaArticulos = FXCollections.observableArrayList();
            for (Articulo articulo : articulos) {
                odb.store(articulo);
                System.out.println(articulo);
            }
            var objetos = odb.getObjects(Articulo.class);
            while (objetos.hasNext()) {
                listaArticulos.add((Articulo) objetos.next());
            }
        }
        tablaArticulos.setItems(listaArticulos);
    }

    public void atras(ActionEvent actionEvent) throws IOException {
        odb.close();
        App.setRoot("menuPrincipal");
    }

    public void buscarOnAction(ActionEvent actionEvent) {

    }

    public void nuevoArticuloOnAction(ActionEvent actionEvent) throws IOException {
        odb.close();
        App.setRoot("crearArticulo");
    }

    public void borrarArticuloOnAction(ActionEvent actionEvent) {
    	odb.delete(tablaArticulos.getSelectionModel().getSelectedItem());
   	}

    public void modificarOnAction(ActionEvent actionEvent) {


    }

    public void exportarOnAction(ActionEvent actionEvent) {

    }

    public void filtrosOnAction(ActionEvent actionEvent) {

    }
}