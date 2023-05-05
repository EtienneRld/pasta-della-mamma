package fr.coding.pastadellamamma.controller;

import fr.coding.pastadellamamma.model.Order;
import fr.coding.pastadellamamma.model.Table;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifiTableController implements Initializable {

    private static Table currentTable;
    @FXML
    public Button setFreeTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setFreeTable.setOnAction(e -> {

        });
    }

    public static void setTable(Table table){
        currentTable = table;
    }
}
