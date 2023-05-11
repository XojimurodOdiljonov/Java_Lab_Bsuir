module com.example.opyion_1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.opyion_1 to javafx.fxml;
    exports com.example.opyion_1;
}