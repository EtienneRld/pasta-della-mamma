package fr.coding.pastadellamamma.controller;
import fr.coding.pastadellamamma.Main;
import fr.coding.pastadellamamma.model.Employes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

@FXML private TextField firstNameLbl;
@FXML private TextField nameLbl;
@FXML private ChoiceBox<String> jobCBox;

    private String[] jobs = {"Cuisiner", "Serveur", "Plongeur"};

    private String name;
    private String firstName;
    private String currentJob;
    @FXML private void submit(){
        currentJob = jobCBox.getValue();
        name = nameLbl.getText();
        firstName = firstNameLbl.getText();

        Employes employe = new Employes( name,firstName, currentJob);
        Main.pastaDellaMamma.addEmployes(employe);

        System.out.println(Main.pastaDellaMamma.toString());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        jobCBox.getItems().addAll(jobs);

    }


}