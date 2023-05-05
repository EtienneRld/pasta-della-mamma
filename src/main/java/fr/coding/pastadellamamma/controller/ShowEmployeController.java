package fr.coding.pastadellamamma.controller;

import fr.coding.pastadellamamma.Main;
import fr.coding.pastadellamamma.model.Employes;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import javafx.scene.control.*;

import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.control.ChoiceBox;

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
