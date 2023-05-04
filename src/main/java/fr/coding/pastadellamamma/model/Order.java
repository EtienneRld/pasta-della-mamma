package fr.coding.pastadellamamma.model;

public class Order {
    private int totalPrice;
    private int commandeStatus;
    private String customerName;
    private String idTables;

    private int nbPerson;

    public int getNbPerson() {
        return nbPerson;
    }

    public void setNbPerson(int nbPerson) {
        this.nbPerson = nbPerson;
    }

    public Order(String idTables, String customerName ){
        this.idTables = idTables;
        this.customerName = customerName;
        this.totalPrice = 0;
        this.commandeStatus = 0;  //0 en attente de prise de commmande /1 en attente de service /2 servit
    }

    @Override
    public String toString() {
        return "Commande{" +
                "totalPrice=" + totalPrice +
                ", commandeStatus=" + commandeStatus +
                ", customerName='" + customerName + '\'' +
                ", idTables='" + idTables + '\'' +
                '}';
    }
}
