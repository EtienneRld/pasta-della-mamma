package fr.coding.pastadellamamma.controller;

import fr.coding.pastadellamamma.Main;
import fr.coding.pastadellamamma.model.Employes;
import fr.coding.pastadellamamma.model.MyListCell;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;


import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowEmployeController implements Initializable {

    @FXML private ListView employeListView;
    @FXML public Button changeSceneBtn;

    public ShowEmployeController() throws IOException {

    }



    @Override
    @FXML public void initialize(URL url, ResourceBundle resourceBundle) {

        employeListView.setCellFactory(list -> new MyListCell());
        ObservableList<Employes> employes = FXCollections.observableArrayList(Main.pastaDellaMamma.getListEmployes());
        employeListView.setItems(employes);

    }

}
