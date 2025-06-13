module org.example.techshop1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.techshop1 to javafx.fxml;
    exports org.example.techshop1;
}