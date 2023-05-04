package fr.coding.pastadellamamma.model;

public class Menu {
    String type;
    String name;
    String description;
    String ingredient;
    float price;
    String image;

    public Menu(String type, String name, String description, String ingredient, float price, String image) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.ingredient = ingredient;
        this.price = price;
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredient() {
        return ingredient;
    }

    public float getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
