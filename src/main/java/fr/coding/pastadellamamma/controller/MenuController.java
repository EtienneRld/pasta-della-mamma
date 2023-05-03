package fr.coding.pastadellamamma.controller;

import fr.coding.pastadellamamma.model.Menu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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

    @FXML
    public ListView<String> dishesList;

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

            dishesList.getItems().add(name);

            ////////////////////////////////////////////////////////

            dishesList.setCellFactory(param -> new ListCell<String>() {
                private final ImageView dishImageView = new ImageView();
                @Override
                public void updateItem(String name, boolean empty) {
                    super.updateItem(name, empty);

                    if (empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        Menu menu = menus.stream()
                                .filter(m -> m.getName().equals(name))
                                .findFirst().get();

                        dishImageView.setFitHeight(32);
                        dishImageView.setFitWidth(32);
                        dishImageView.setImage(new Image(menu.getImage()));

                        setText(name);
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

            System.out.println(menus.get(index));
        });
    }
}
