package fr.coding.pastadellamamma.model;

public class Menu {
    String name;
    String description;
    float price;
    String image;

    public Menu(String name, String description, float price, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
