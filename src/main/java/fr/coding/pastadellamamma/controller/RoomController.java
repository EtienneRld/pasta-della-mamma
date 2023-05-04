package fr.coding.pastadellamamma.controller;

import fr.coding.pastadellamamma.Main;
import fr.coding.pastadellamamma.model.Employes;
import fr.coding.pastadellamamma.model.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class RoomController implements Initializable {

    @FXML
    public ListView showTables;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       List<Table> occuped =  Main.pastaDellaMamma.getListTables().stream().filter(e -> !e.isBusy()).collect(Collectors.toList());
       ObservableList<Table> tables = FXCollections.observableArrayList(Main.pastaDellaMamma.getListTables());
       showTables.setItems(tables);
    }
}
