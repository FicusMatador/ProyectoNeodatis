module com.example.proyectoneodatis {
    requires javafx.controls;
    requires javafx.fxml;
    requires neodatis.odb;
    requires javafx.base;


    opens com.example.proyectoneodatis.controladores to javafx.fxml;
    exports com.example.proyectoneodatis;
}