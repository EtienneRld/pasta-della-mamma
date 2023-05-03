package fr.coding.pastadellamamma.controller;

import fr.coding.pastadellamamma.Main;
import fr.coding.pastadellamamma.model.Table;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class RoomController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       List<Table> occuped =  Main.pastaDellaMamma.getListTables().stream().filter(e -> !e.isBusy()).collect(Collectors.toList());
    }
}
