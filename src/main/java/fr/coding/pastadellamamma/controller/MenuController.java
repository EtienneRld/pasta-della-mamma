package fr.coding.pastadellamamma.controller;

import fr.coding.pastadellamamma.model.Menu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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

    ArrayList<Menu> menus = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String description = descriptionField.getText();
            String image = imageField.getText();
            float price;

            try {
                price = Float.parseFloat(priceField.getText());
            } catch (final NumberFormatException ex) {
                return; //invalid number error message
            }

            Menu menu = new Menu(name, description, price, image);
            menus.add(menu);

            VBox dishe = new VBox();

            Label disheName = new Label();
            disheName.setText(name);

            dishe.getChildren().add(disheName);
            dishes.getChildren().add(dishe);
        });
    }
}
