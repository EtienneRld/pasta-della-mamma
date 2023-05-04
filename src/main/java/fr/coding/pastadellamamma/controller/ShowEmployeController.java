package fr.coding.pastadellamamma.controller;

import fr.coding.pastadellamamma.Main;
import fr.coding.pastadellamamma.model.Employes;
import fr.coding.pastadellamamma.model.MyListCell;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import fr.coding.pastadellamamma.Main;
import fr.coding.pastadellamamma.model.Employes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import fr.coding.pastadellamamma.Main;
import fr.coding.pastadellamamma.model.Employes;
import fr.coding.pastadellamamma.controller.ShowEmployeController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowEmployeController implements Initializable {


    @FXML private TextField firstNameLbl;
    @FXML private TextField nameLbl;
    @FXML private ChoiceBox<String> jobCBox;
    @FXML private Button submitBtn;
    @FXML private VBox containerVBox;
    @FXML private ListView employeListView;
    @FXML public Button changeSceneBtn;
    @FXML
    private TextField addHoursTxtField;
    @FXML
    private TextField removeHoursTxtField;
    @FXML
    private Button submitHours;

    private String hours;

    private String[] jobs = {"Cuisiner", "Serveur", "Plongeur"};

    private String name;
    private String firstName;
    private String currentJob;



    public ShowEmployeController() throws IOException {
    }


    @Override
    @FXML public void initialize(URL url, ResourceBundle resourceBundle) {

        jobCBox.getItems().addAll(jobs);

        ObservableList<Employes> employes = FXCollections.observableList(Main.pastaDellaMamma.getListEmployes());
        employes.addListener(new ListChangeListener<Employes>() {
            @Override
            public void onChanged(Change<? extends Employes> change) {
                System.out.println("test");
            }
        });
        //List<Employes> employe2 = employes;

        employeListView.setItems(employes);
        //System.out.println(employes);
        employeListView.setCellFactory(list -> new ListCell<Employes>(){

            @Override
            public void updateItem(Employes name, boolean empty) {
                super.updateItem(name, empty);

                if (empty) {
                    setText(null);

                } else {
                    Employes employe = employes.stream()
                            .filter(m -> m.equals(name))
                            .findFirst().get();


                    setText(String.valueOf(employe));
                }
            }

        });

        System.out.println(".");


        employeListView.setOnMouseClicked(e -> {
            int index = employeListView.getSelectionModel().getSelectedIndex();
            if (index >= 0){
                employeListView.getItems().remove(index);
            }
        });


        submitBtn.setOnAction(e -> {
            currentJob = jobCBox.getValue();
            name = nameLbl.getText();
            firstName = firstNameLbl.getText();
            Employes employe = new Employes( name, firstName, currentJob, hours);
            employes.add(employe);
            hours = "0";
            System.out.println(employes);
        });


        submitHours.setOnAction(e -> {
            if (removeHoursTxtField == null){
                int addHours = Integer.parseInt(addHoursTxtField.getText());
                int convertHours = Integer.parseInt(hours);
                int result = addHours + convertHours;
                hours = String.valueOf(result);

            } else if (addHoursTxtField == null) {
                int addHours = Integer.parseInt(removeHoursTxtField.getText());
                int convertHours = Integer.parseInt(hours);
                int result = addHours - convertHours;
                hours = String.valueOf(result);
            } else {
                System.out.println("error");
            }
        });

    }



}
