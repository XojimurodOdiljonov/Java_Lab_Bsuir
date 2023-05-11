module com.example.lotto_8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lotto_8 to javafx.fxml;
    exports com.example.lotto_8;
}