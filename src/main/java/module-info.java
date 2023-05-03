module fr.coding.pastadellamamma {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.coding.pastadellamamma to javafx.fxml;
    exports fr.coding.pastadellamamma;
}