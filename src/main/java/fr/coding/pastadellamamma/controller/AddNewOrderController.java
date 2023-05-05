package fr.coding.pastadellamamma.controller;

import fr.coding.pastadellamamma.Main;
import fr.coding.pastadellamamma.model.Order;
import fr.coding.pastadellamamma.model.Table;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class AddNewOrderController implements Initializable {

    @FXML
    public TextField nbPerson;

    @FXML
    public TextField idCommande;

    @FXML
    public ChoiceBox nTable;

    @FXML
    public TextField heure;

    @FXML
    public TextField minute;

    @FXML
    public Button addToTable;

    public static ObservableList<Table> listTables;

    private static void handle(ActionEvent e) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listTables = FXCollections.observableArrayList(Main.pastaDellaMamma.getListTables());
        List<Table> freeTable  = listTables.stream().filter(e -> !e.isBusy()).collect(Collectors.toList());
        List<String> freeTableID = freeTable.stream().map(e -> e.getId()).collect(Collectors.toList());
        nTable.getItems().addAll(freeTableID);//afficher toutes les tables innocupé dans la liste

        listTables.addListener(new ListChangeListener<Table>() {  //écouter les changement sur l'observable list
            @Override
            public void onChanged(Change<? extends Table> change) {
                List<Table> freeTable  = listTables.stream().filter(e -> !e.isBusy()).collect(Collectors.toList());
                List<String> freeTableID = freeTable.stream().map(e -> e.getId()).collect(Collectors.toList());
                nTable.getItems().clear();
                nTable.getItems().addAll(freeTableID); //nécessite de reset le tableau avant d'ajouter les tables
            }
        });

        addToTable.setOnAction(e -> {
            Order newOrder = new Order(nTable.getValue().toString() ,idCommande.getText());  //instance de la nouvelle commande
            int nbP = Integer.parseInt(nbPerson.getText());  //set le nombre de personne a la table
            newOrder.setNbPerson(nbP);
            CommandesController.addNewOrder(newOrder);  //ajoute la commande a la list
            List<Table> testTable = Main.pastaDellaMamma.getListTables().stream().filter(i -> i.getId() == nTable.getValue().toString()).collect(Collectors.toList());
            testTable.get(0).setBusy(true);
            listTables.remove(testTable.get(0));

        });

    }


}
