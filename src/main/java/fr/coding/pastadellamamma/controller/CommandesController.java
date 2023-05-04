package fr.coding.pastadellamamma.controller;

import fr.coding.pastadellamamma.Main;
import fr.coding.pastadellamamma.model.Order;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CommandesController implements Initializable {

    public static ObservableList<Order> listCommande;

    @FXML
    public VBox content;

    @FXML
    public Button newOrder;

    @FXML
    public ListView orderListView;

    public ObservableList<Order> getListCommande() {
        return listCommande;
    }

    public void loadFXML(String name, String title) {
        try {
            VBox menu = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(name)));
            Stage stage = (Stage)content.getScene().getWindow();
            stage.setTitle(title);

            content.getChildren().clear();
            content.getChildren().add(menu);

            stage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listCommande = FXCollections.observableArrayList(Main.pastaDellaMamma.getListCommandes());  //affichage des commandes
        listCommande.addListener(new ListChangeListener<Order>() {
            @Override
            public void onChanged(Change<? extends Order> change) {
                System.out.println("test final");

            }
        });
        orderListView.setItems(listCommande);
        orderListView.onMouseReleasedProperty().addListener(e -> {
            loadFXML("orderDetails.fxml", "détail de la commande");
        });

   //    Commande test = AddNewOrderController.envoieCommande();

        newOrder.setOnAction(e -> loadFXML("AddNewOrder.fxml", "nouvelle commande"));
    }

    public static void addNewOrder(Order order){
        listCommande.add(order);
        Main.pastaDellaMamma.getListCommandes().add(order);
    }


}
