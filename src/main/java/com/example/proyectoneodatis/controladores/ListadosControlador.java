package com.example.proyectoneodatis.controladores;

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

import java.util.ArrayList;
import java.util.List;

public class ListadosControlador{
    @FXML
    private TableView<Articulo> tablaArticulos;

    @FXML
    private TableColumn<Articulo, Integer> colCodigo;

    @FXML
    private TableColumn<Articulo, String> colDenominacion;

    @FXML
    private TableColumn<Articulo, Double> colPrecioVenta;

    @FXML
    private TableColumn<Articulo, String> colCategoria;

    @FXML
    private TableColumn<Articulo, Double> colPrecioUnitario;

    @FXML
    private TableColumn<Articulo, Integer> colStock;

    private ObservableList<Articulo> listaArticulos;

    @FXML
    public void initialize() {
        // Configurar las columnas
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colDenominacion.setCellValueFactory(new PropertyValueFactory<>("denominacion"));
        colPrecioVenta.setCellValueFactory(new PropertyValueFactory<>("precioVenta"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colPrecioUnitario.setCellValueFactory(new PropertyValueFactory<>("precioUnitario"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        List<Articulo> articulos = new ArrayList<>();

        // Agregar los artículos
        articulos.add(new Articulo(1,"Portatil Acer", 500.0, "Informática", 10.0, 20));
        articulos.add(new Articulo(2,"Pala Pádel", 100.0, "Deportes", 5.0, 30));
        articulos.add(new Articulo(3,"Caja Lápices", 6.0, "Escritorio", 10.0, 6));
        articulos.add(new Articulo(4,"Marcadores", 10.0, "Escritorio", 20.0, 19));
        articulos.add(new Articulo(5,"Memoria 32GB", 120.0, "Informática", 8.0, 10));
        articulos.add(new Articulo(6,"Micro Intel", 150.0, "Informática", 4.0, 10));
        articulos.add(new Articulo(7,"Bolas Pádel", 5.0, "Deportes", 15.0, 30));
        articulos.add(new Articulo(8,"Falda Pádel", 15.0, "Deportes", 10.0, 10));
        listaArticulos = FXCollections.observableArrayList();
        ODB odb = ODBFactory.open("neonatis.test");
        for (Articulo articulo : articulos) {
            odb.store(articulo);
        }
        var objetos = odb.getObjects(Articulo.class);
        while (objetos.hasNext()) {
            listaArticulos.add((Articulo) objetos.next());
        }
        odb.close();

        // Enlazar datos a la tabla
        tablaArticulos.setItems(listaArticulos);
    }

    public void atras(ActionEvent actionEvent) {

    }

    public void buscarOnAction(ActionEvent actionEvent) {

    }

    public void nuevoArticuloOnAction(ActionEvent actionEvent) {

    }

    public void borrarArticuloOnAction(ActionEvent actionEvent) {

    }

    public void modificarOnAction(ActionEvent actionEvent) {


    }

    public void exportarOnAction(ActionEvent actionEvent) {

    }

    public void filtrosOnAction(ActionEvent actionEvent) {

    }
}