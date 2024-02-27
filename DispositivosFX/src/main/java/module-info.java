module com.example.dispositivosfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dispositivosfx to javafx.fxml;
    exports com.example.dispositivosfx;
}