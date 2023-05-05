package fr.coding.pastadellamamma.controller;



import fr.coding.pastadellamamma.Main;
import fr.coding.pastadellamamma.model.Chrono;
import fr.coding.pastadellamamma.model.Order;
import fr.coding.pastadellamamma.model.Table;
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
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static fr.coding.pastadellamamma.model.Chrono.endOrder;

public class CommandesController implements Initializable {

    public static ObservableList<Order> listCommande;

    @FXML
    public VBox content;

    @FXML
    public VBox content2;

    @FXML
    public Button newOrder;

    @FXML
    public ListView orderListView;

    public ObservableList<Order> getListCommande() {
        return listCommande;
    }

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

        listCommande = FXCollections.observableArrayList(Main.pastaDellaMamma.getListCommandes());  //affichage des commandes
        listCommande.addListener(new ListChangeListener<Order>() {
            @Override
            public void onChanged(Change<? extends Order> change) {
                List<String> showOrder = listCommande.stream().map(k -> k.getCustomerName()).collect(Collectors.toList());
                orderListView.getItems().clear();
                orderListView.getItems().addAll(showOrder);

            }
        });
        List<String> showOrder = listCommande.stream().map(k -> k.getCustomerName()).collect(Collectors.toList());
        orderListView.getItems().addAll(showOrder);

        orderListView.setOnMouseClicked(e -> {
            int index = orderListView.getSelectionModel().getSelectedIndex();
            List<Order> currentOrder =  listCommande.stream().filter(l -> l.getCustomerName()==orderListView.getItems().get(index)).collect(Collectors.toList());
            OrderDetailsController.setOrder(currentOrder.get(0));
            loadFXML("orderDetails.fxml", "détail de la commande",content);
        });
        //    Commande test = AddNewOrderController.envoieCommande();
        if (Chrono.endOrder = false) {
            newOrder.setOnAction(e -> loadFXML("AddNewOrder.fxml", "nouvelle commande", content));
        }
    }

    public static void addNewOrder(Order order) {
        listCommande.add(order);
        Main.pastaDellaMamma.getListCommandes().add(order);
    }

    public static void deleteOrder(Order order) {
        List freeTable = Main.pastaDellaMamma.getListTables().stream().filter(e -> e.getId() == order.getIdTables()).collect(Collectors.toList());
        Table table = (Table) freeTable.get(0);
        table.setBusy(false);
        //AddNewOrderController.listTables.add(table);
        listCommande.remove(order);
        Main.pastaDellaMamma.getListCommandes().remove(order);
   
    }



}
