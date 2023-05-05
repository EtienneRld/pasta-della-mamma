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
        //filtre pour récuperer les tableau inocupées
        List<Table> occuped =  Main.pastaDellaMamma.getListTables().stream().filter(e -> !e.isBusy()).collect(Collectors.toList());

        //remplie la list view de toutes les tables présentes dans le restaurants
        ObservableList<Table> tables = FXCollections.observableArrayList(Main.pastaDellaMamma.getListTables());
        List<String> tablesId= tables.stream().map(e -> {
            String res;
            if(e.isBusy()) res = " occupé";
            else res = " libre";
            return e.getId() + res;
        }).collect(Collectors.toList());
        showTables.getItems().addAll(tablesId);
    }
}
