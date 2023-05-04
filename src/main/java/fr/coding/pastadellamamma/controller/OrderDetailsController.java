package fr.coding.pastadellamamma.controller;

import fr.coding.pastadellamamma.Main;
import fr.coding.pastadellamamma.model.Menu;
import fr.coding.pastadellamamma.model.Order;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class OrderDetailsController implements Initializable {

    @FXML
    public Button deleteOrder;
    @FXML
    public ListView menuList;
    @FXML
    public ListView orderListView;

    @FXML
    public  ListView priceListView;
    @FXML
    public Label nTable;
    @FXML
    public Label idCommande;
    @FXML
    public Label statusC;
    private static Order currentOrder;

    private  ObservableList<Menu> showOrder;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nTable.setText(currentOrder.getIdTables());
        idCommande.setText(currentOrder.getCustomerName());
        statusC.setText(String.valueOf(currentOrder.getCommandeStatus()));

        ObservableList<Menu> menus = FXCollections.observableArrayList(Main.pastaDellaMamma.getMenus());
        List<String> showMenus = menus.stream().map(e -> e.getName()).collect(Collectors.toList());
        menuList.getItems().addAll(showMenus);

        menuList.setOnMouseClicked(e -> {
            int index = menuList.getSelectionModel().getSelectedIndex();
            List<Menu> currentMenu =  menus.stream().filter(l -> l.getName()==menuList.getItems().get(index)).collect(Collectors.toList());
            addMenuToOrder(currentMenu.get(0));
            System.out.println(currentOrder.getOrderMenu().get(0).getName());
        });

        showOrder = FXCollections.observableArrayList(currentOrder.getOrderMenu());
        List<String> showOrderMenu = showOrder.stream().map(i -> i.getName()).collect(Collectors.toList());
        List<String> showMenuPrice = showOrder.stream().map(i -> String.valueOf(i.getPrice())).collect(Collectors.toList());
        orderListView.getItems().addAll(showOrderMenu);
        priceListView.getItems().addAll(showMenuPrice);

        showOrder.addListener(new ListChangeListener<Menu>() {
            @Override
            public void onChanged(Change<? extends Menu> change) {
                List<String> showOrderMenu = showOrder.stream().map(i -> i.getName()).collect(Collectors.toList());
                List<String> showMenuPrice = showOrder.stream().map(i -> String.valueOf(i.getPrice())).collect(Collectors.toList());
                orderListView.getItems().clear();
                orderListView.getItems().addAll(showOrderMenu);
                priceListView.getItems().clear();
                priceListView.getItems().addAll(showMenuPrice);
            }
        });

        deleteOrder.setOnAction(j -> {
           List orderToDelete = Main.pastaDellaMamma.getListCommandes().stream().filter(k -> k.getCustomerName()== currentOrder.getCustomerName()).collect(Collectors.toList());
            CommandesController.deleteOrder((Order) orderToDelete.get(0));

        });
    }

    public void addMenuToOrder(Menu menu){
        currentOrder.addInOrderMenu(menu);
        showOrder.add(menu);
    }
    public static void setOrder(Order order){
        currentOrder = order;
    }
}
