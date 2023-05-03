package fr.coding.pastadellamamma.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {


    private List<Table> listTables;

    @Override
    public String toString() {
        return "Restaurant{" +
                "listTables=" + listTables +
                ", listEmployes=" + listEmployes +
                '}';
    }

    private List<Employes>listEmployes;

    public Restaurant() {
        this.listEmployes = new ArrayList<>();
    }

    public List<Employes> getListEmployes() {
        return listEmployes;
    }

    public void addEmployes(Employes employes){
        this.listEmployes.add(employes);
    }

    public List<Table> getListTables() {
        return listTables;
    }

    public void addTables(Table table){
        this.listTables.add(table);
    }
}
