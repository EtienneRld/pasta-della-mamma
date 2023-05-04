package fr.coding.pastadellamamma.controller;

import fr.coding.pastadellamamma.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CommandesController implements Initializable {

    @FXML
    public VBox content;

    @FXML
    public Button newOrder;

    public void loadFXML(String name, String title) {
        try {
            VBox menu = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(name)));
            Stage stage = (Stage)content.getScene().getWindow();
            stage.setTitle(title);

            content.getChildren().clear();
            content.getChildren().add(menu);

            stage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newOrder.setOnAction(e -> loadFXML("nouvelleCommande.fxml","nouvelle commande"));
    }
}
