module com.example.proyectoneodatis {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyectoneodatis.controladores to javafx.fxml;
    exports com.example.proyectoneodatis;
}