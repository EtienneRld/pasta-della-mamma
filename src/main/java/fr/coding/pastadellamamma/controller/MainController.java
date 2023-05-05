package fr.coding.pastadellamamma.controller;

import fr.coding.pastadellamamma.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
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
    public MenuItem menu;

    @FXML
    public MenuItem amployeList;

    @FXML
    public MenuItem employe;

    @FXML
    public MenuItem room;

    @FXML
    public MenuItem commandes;

    @FXML
    public MenuItem service;

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
        menu.setOnAction(e -> loadFXML("menu.fxml", "Menu"));
        amployeList.setOnAction(e -> loadFXML("amployeList.fxml", "Gestion des employés"));
        room.setOnAction(e -> loadFXML("table.fxml", "Gestion de salle"));
        commandes.setOnAction(e -> loadFXML("commande.fxml", "Prise de commandes"));
        service.setOnAction(e -> loadFXML("chrono.fxml", "Chrono"));
    }
}
