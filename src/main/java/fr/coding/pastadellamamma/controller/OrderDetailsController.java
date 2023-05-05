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
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class OrderDetailsController implements Initializable {

    @FXML
    public ListView listViewStatus;
    @FXML
    public Label lblPrixTotal;
    @FXML
    public Button btnOrderMenu;
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
        //set valeur des informations de commande
        nTable.setText(currentOrder.getIdTables());
        idCommande.setText(currentOrder.getCustomerName());
        statusC.setText(String.valueOf(currentOrder.getCommandeStatus()));

        //afficher le menu pour passer commande
        ObservableList<Menu> menus = FXCollections.observableArrayList(Main.pastaDellaMamma.getMenus());
        List<String> showMenus = menus.stream().map(e -> e.getName()).collect(Collectors.toList());
        menuList.getItems().addAll(showMenus);

        menuList.setOnMouseClicked(e -> {
            int index = menuList.getSelectionModel().getSelectedIndex();
            List<Menu> currentMenu =  menus.stream().filter(l -> l.getName()==menuList.getItems().get(index)).collect(Collectors.toList());
            addMenuToOrder(currentMenu.get(0));
        });


        //afficher la commande détaille avec le prix  "qts -> etat du plat"
        showOrder = FXCollections.observableArrayList(currentOrder.getOrderMenu());
        showContent();
        showOrder.addListener(new ListChangeListener<Menu>() {
            @Override
            public void onChanged(Change<? extends Menu> change) {
                showContent();
            }
        });

        deleteOrder.setOnAction(j -> {
           List orderToDelete = Main.pastaDellaMamma.getListCommandes().stream().filter(k -> k.getCustomerName()== currentOrder.getCustomerName()).collect(Collectors.toList());
            CommandesController.deleteOrder((Order) orderToDelete.get(0));
        });
        btnOrderMenu.setOnAction(e-> {
            Double countOrder = currentOrder.getOrderMenu().stream().mapToDouble(Menu::getPrice).sum();
            lblPrixTotal.setText(String.valueOf(countOrder));
            List<Integer> showMenuStatu = showOrder.stream().map(i -> 1).collect(Collectors.toList());
            listViewStatus.getItems().clear();
            listViewStatus.getItems().addAll(showMenuStatu);
            });
    }

    public void showContent(){
        List<String> showOrderMenu = showOrder.stream().map(i -> i.getName()).collect(Collectors.toList());
        List<String> showMenuPrice = showOrder.stream().map(i -> String.valueOf(i.getPrice())).collect(Collectors.toList());
        List<String> showMenuStatu = showOrder.stream().map(i -> String.valueOf(i.getMenuStatus())).collect(Collectors.toList());
        orderListView.getItems().clear();
        orderListView.getItems().addAll(showOrderMenu);
        priceListView.getItems().clear();
        priceListView.getItems().addAll(showMenuPrice);
        listViewStatus.getItems().clear();
        listViewStatus.getItems().addAll(showMenuStatu);
    }
    public void addMenuToOrder(Menu menu){
        currentOrder.addInOrderMenu(menu);
        showOrder.add(menu);
    }
    public static void setOrder(Order order){
        currentOrder = order;
    }
}
