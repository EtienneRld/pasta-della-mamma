package fr.coding.pastadellamamma.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {



    private List<Employes>listEmployes;

    @Override
    public String toString() {
        return "Restaurant{" +
                "listEmployes=" + listEmployes +
                '}';
    }

    public Restaurant() {
        this.listEmployes = new ArrayList<>();
    }

    public List<Employes> getListEmployes() {
        return listEmployes;
    }

    public void addEmployes(Employes employes){
        this.listEmployes.add(employes);
    }
}
