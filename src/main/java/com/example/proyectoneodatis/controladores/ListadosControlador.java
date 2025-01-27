package com.example.proyectoneodatis.controladores;

import com.example.proyectoneodatis.Modelo.Articulo;
import javafx.event.ActionEvent;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import java.util.ArrayList;
import java.util.List;

public class ListadosControlador{

    public void initialize(){
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
        ODB odb = ODBFactory.open("neonatis.test"); // Abrir BD
        for (Articulo articulo : articulos) {
            odb.store(articulo);
        }

        //recuperamos todos los objetos
        Objects<Articulo> objects = odb.getObjects(Articulo.class);
        System.out.printf("%d Jugadores: %n", objects.size());
        int i = 1;

        //visualizar los objetos
        while (objects.hasNext()) {
            Articulo jug = objects.next();
            System.out.printf("%d: %s, %s, %s,%s, %d\n", i++, jug.getDenominacion(), jug.getPrecioDeVentaAlPublico(), jug.getCategoria(), jug.getUnidadesVendidas(),jug.getStock());

        }
        odb.close(); // Cerrar BD
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