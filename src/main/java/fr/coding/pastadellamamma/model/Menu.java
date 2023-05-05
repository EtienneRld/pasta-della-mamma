package fr.coding.pastadellamamma.model;

public class Menu {
    private String type;
    private String name;
    private String description;
    private String ingredient;
    private float price;
    private String image;
    private int menuStatus; // 0 preparation - 1 pret - 2 servit - 3 débarasser

    public Menu(String type, String name, String description, String ingredient, float price, String image) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.ingredient = ingredient;
        this.price = price;
        this.image = image;
        this.menuStatus = 0;
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

    public int getMenuStatus() {
        return menuStatus;
    }

    public void setStatus() {
        this.menuStatus += 1;
    }

}
