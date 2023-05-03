package fr.coding.pastadellamamma.controller;

import fr.coding.pastadellamamma.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public VBox content;

    @FXML
    public MenuItem home;

    @FXML
    public MenuItem menu;

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
    public void initialize(URL location, ResourceBundle resources) {
        home.setOnAction(e -> loadFXML("main.fxml", "Pasta della mamma"));
        menu.setOnAction(e -> loadFXML("menu.fxml", "Menu"));
    }

    //quitter.setOnAction(event -> System.exit(0));

    /*armee.setOnAction(event ->  {
        contenu.getChildren().clear();
        contenu.getChildren().add(contenuArmee);
    });

    menuItemBiblio.setOnAction(event ->  {
        contenu.getChildren().clear();
        contenu.getChildren().add(contenuBibliotheque);
    });*/
}