package fr.coding.pastadellamamma.controller;

import fr.coding.pastadellamamma.Main;
import fr.coding.pastadellamamma.model.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class MenuController implements Initializable {
    @FXML
    public TextField nameField;

    @FXML
    public TextField descriptionField;

    @FXML
    public TextField priceField;

    @FXML
    public TextField imageField;

    @FXML
    public Button addButton;

    @FXML
    public AnchorPane dishes;

    @FXML
    public ListView<String> dishesList;

    @FXML
    public Label nameDetails;

    @FXML
    public Label descriptionDetails;

    @FXML
    public Label ingredientsDetails;

    @FXML
    public Label priceDetails;

    @FXML
    public ImageView imageDetails;

    @FXML
    public AnchorPane detailsAnchor;

    @FXML
    public ComboBox<String> typeComboBox = new ComboBox<>();

    @FXML
    public ListView<String> ingredientsListView = new ListView<>();

    ArrayList<Menu> menus = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> types = FXCollections.observableArrayList("Boisson", "Entrée", "Plat", "Dessert");
        typeComboBox.setItems(types);

        ObservableList<String> ingredients = FXCollections.observableArrayList("Steak (Viande)", "Poulet (Viande)", "Saumon (Poisson)", "Tomate (Fruit)", "Salade (Légumes)", "Oignon (Légumes)", "Schedar (Fromage)", "Gruyère (Fromage)", "Ketchup (Sauce)", "Mayonaise (Sauce)", "Farine de blé", "Farine de Maïs", "Pâtes (Féculent)", "Lait", "Chocolat", "Sucre", "Miel");
        List<String> alphabeticIngredient = ingredients.stream()
                .sorted()
                .collect(Collectors.toList());

        ingredientsListView.setItems(FXCollections.observableArrayList(alphabeticIngredient));
        ingredientsListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        System.out.println(alphabeticIngredient);



        addButton.setOnAction(e -> {
            String type = (String) typeComboBox.getSelectionModel().getSelectedItem();
            String name = nameField.getText();
            String description = descriptionField.getText();
            List<String> selectedIngredients = ingredientsListView.getSelectionModel().getSelectedItems();
            String ingredient = String.join(",", selectedIngredients);
            String image = imageField.getText();
            float price;

            System.out.println(selectedIngredients);

            try {
                price = Float.parseFloat(priceField.getText());
            } catch (final NumberFormatException ex) {
                return; //invalid number error message
            }


            Menu menu = new Menu(type, name, description, ingredient, price, image);
            Main.pastaDellaMamma.getMenus().add(menu);

            dishesList.getItems().add(name);

            dishesList.setCellFactory(param -> new ListCell<String>() {
                private final ImageView dishImageView = new ImageView();

                @Override
                public void updateItem(String name, boolean empty) {
                    super.updateItem(name, empty);

                    if (empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        Menu menu = Main.pastaDellaMamma.getMenus().stream()
                                .filter(m -> m.getName().equals(name))
                                .findFirst().get();

                        dishImageView.setFitHeight(70);
                        dishImageView.setFitWidth(70);
                        dishImageView.setImage(new Image(menu.getImage()));

                        String type = menu.getType();
                        setText(name + " (" + type + ")");
                        setGraphic(dishImageView);
                    }
                }
            });
        });

        dishesList.setOnMouseClicked(e -> {
            int index = dishesList.getSelectionModel().getSelectedIndex();

            if (index < 0) {
                return;
            }

            System.out.println(Main.pastaDellaMamma.getMenus().get(index));
            
            Menu selectedMenu = Main.pastaDellaMamma.getMenus().get(index);
            String type = selectedMenu.getType();
            String name = selectedMenu.getName();
            String description = selectedMenu.getDescription();
            String ingredient = selectedMenu.getIngredient();
            float price = selectedMenu.getPrice();
            String image = selectedMenu.getImage();

            nameDetails.setText(name + " (" + type + ")");
            descriptionDetails.setText(description);
            ingredientsDetails.setText(ingredient);
            priceDetails.setText(Float.toString(price) + " €");
            imageDetails.setImage(new Image(image));

            nameDetails.setMaxWidth(Double.MAX_VALUE);
            detailsAnchor.setLeftAnchor(nameDetails, 0.0);
            detailsAnchor.setRightAnchor(nameDetails, 0.0);
            nameDetails.setAlignment(Pos.CENTER);

            descriptionDetails.setMaxWidth(Double.MAX_VALUE);
            detailsAnchor.setLeftAnchor(descriptionDetails, 0.0);
            detailsAnchor.setRightAnchor(descriptionDetails, 0.0);
            descriptionDetails.setAlignment(Pos.CENTER);

            ingredientsDetails.setMaxWidth(Double.MAX_VALUE);
            detailsAnchor.setLeftAnchor(ingredientsDetails, 0.0);
            detailsAnchor.setRightAnchor(ingredientsDetails, 0.0);
            ingredientsDetails.setAlignment(Pos.CENTER);

            priceDetails.setMaxWidth(Double.MAX_VALUE);
            detailsAnchor.setLeftAnchor(priceDetails, 0.0);
            detailsAnchor.setRightAnchor(priceDetails, 0.0);
            priceDetails.setAlignment(Pos.CENTER);
        });

        typeComboBox.setOnAction(e -> {
            String type = typeComboBox.getSelectionModel().getSelectedItem();
            System.out.println(type);
        });
    }
}