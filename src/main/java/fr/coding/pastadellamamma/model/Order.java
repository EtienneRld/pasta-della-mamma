package fr.coding.pastadellamamma.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int totalPrice;
    private int commandeStatus;  //0 commande - 1 servit - 2 payer
    private String customerName;
    private String idTables;
    private List<Menu> orderMenu;
    private int nbPerson;

    public List<Menu> getOrderMenu() {
        return orderMenu;
    }

    public void addInOrderMenu(Menu menu){
        this.orderMenu.add(menu);
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getCommandeStatus() {
        return commandeStatus;
    }

    public void setCommandeStatus(int commandeStatus) {
        this.commandeStatus = commandeStatus;
    }

    public String getIdTables() {
        return idTables;
    }

    public void setNbPerson(int nbPerson) {
        this.nbPerson = nbPerson;
    }

    public Order(String idTables, String customerName ){
        this.orderMenu = new ArrayList<>();  //liste des plats de la commande
        this.idTables = idTables;
        this.customerName = customerName;  //idCommandes
        this.totalPrice = 0;
        this.commandeStatus = 0;  //a revoir
    }

    @Override
    public String toString() {
        return "Commande{" +
                "totalPrice=" + totalPrice +
                ", commandeStatus=" + commandeStatus +
                ", customerName='" + customerName + '\'' +
                ", idTables='" + idTables + '\'' +
                ", orderMenu='" + orderMenu + '\'' +
                '}';
    }
}
