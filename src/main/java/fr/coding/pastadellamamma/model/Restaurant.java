package fr.coding.pastadellamamma.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    /**  Variables  **/
    private ArrayList<Menu> menus = new ArrayList<>();  //menu du restaurant
    private List<Employes>listEmployes; //list des employers du restaurant
    private List<Table>listTables; //list des tables du restaurant
    private List<Order>listCommandes;  //list des commandes - "a revoir"

    /**  Méthodes  **/

    public Restaurant() {  //constructeur
        this.listEmployes = new ArrayList<>();
        this.listTables = new ArrayList<>();
        this.listCommandes = new ArrayList<>();

    }

    public List<Order> getListCommandes() {
        return listCommandes;
    }

    public List<Employes> getListEmployes() {
        return listEmployes;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public List<Table> getListTables() {
        return listTables;
    }

    public void addCommande(Order commande){
        this.listCommandes.add(commande);
    }

    public void addTables(Table table){
        this.listTables.add(table);
    }

    public void addEmployes(Employes employes){
        this.listEmployes.add(employes);
    }

    public void addMenu(Menu menu){ this.menus.add(menu); }

    @Override
    public String toString() {
        return "Restaurant{" +
               // "menus=" + menus +
                ", listEmployes=" + listEmployes +
                ", listTables=" + listTables +
                ", listCommandes=" + listCommandes +
                '}';
    }
}
