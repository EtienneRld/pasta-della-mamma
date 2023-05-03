package fr.coding.pastadellamamma.model;

public class Table {

    private String id;

    private int nbPlaces;
    private String currentCustomer;
    private boolean isBusy;

   // private String nbRoom;   -> localisation de la table quand il y a plusieur piece  (terrace, interieur ... )

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public String getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(String currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public String getId() {
        return id;
    }

    public Table(String id,int nbPlaces){
        this.nbPlaces = nbPlaces;
        this.id = id;
        this.setBusy(false);
        this.setCurrentCustomer(null);
    }
}



