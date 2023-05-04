package fr.coding.pastadellamamma.model;

public class Commande {
    private int totalPrice;
    private int commandeStatus;
    private String customerName;
    private String idTables;

    public Commande(String idTables,String customerName ){
        this.idTables = idTables;
        this.customerName = customerName;
        this.totalPrice = 0;
        this.commandeStatus = 0;  //0 en attente de prise de commmande /1 en attente de service /2 servit
    }

}
