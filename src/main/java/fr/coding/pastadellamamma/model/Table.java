package fr.coding.pastadellamamma.model;

public class Table {

    private int nbPlaces;
    private String currentCustomer;
    private boolean isBusy;

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

    public Table(int nbPlaces){
        this.nbPlaces = nbPlaces;
        this.setBusy(false);
        this.setCurrentCustomer(null);
    }
}



