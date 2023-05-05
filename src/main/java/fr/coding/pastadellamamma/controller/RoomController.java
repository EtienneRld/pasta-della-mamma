package fr.coding.pastadellamamma.controller;

import fr.coding.pastadellamamma.Main;
import fr.coding.pastadellamamma.model.Employes;
import fr.coding.pastadellamamma.model.Menu;
import fr.coding.pastadellamamma.model.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class RoomController implements Initializable {

    @FXML
    public VBox content;
    @FXML
    public ListView showTables;

    public void loadFXML(String name, String title,VBox content) {
        try {
            VBox menu = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(name)));
            Stage stage = (Stage)content.getScene().getWindow();
            if(title != ""){
                stage.setTitle(title);
            }

            content.getChildren().clear();
            content.getChildren().add(menu);

            stage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

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

        showTables.setOnMouseClicked(e -> {
            int index = showTables.getSelectionModel().getSelectedIndex();
            List<Table> currentTable =  tables.stream().filter(l -> l.getId()==showTables.getItems().get(index)).collect(Collectors.toList());
        //    ModifiTableController.setTable();
           // addMenuToOrder(currentMenu.get(0));
        });

    }
}
