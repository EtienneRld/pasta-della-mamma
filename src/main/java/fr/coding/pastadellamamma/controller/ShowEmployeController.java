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
import java.util.*;

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

import javax.security.auth.login.AccountLockedException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

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

    public void setFirstNameLbl(TextField firstNameLbl) {
        this.firstNameLbl = firstNameLbl;
    }

    public void setNameLbl(TextField nameLbl) {
        this.nameLbl = nameLbl;
    }

    public void setJobCBox(ChoiceBox<String> jobCBox) {
        this.jobCBox = jobCBox;
    }
    private String hours;

    private String[] jobs = {"Cuisiner", "Serveur", "Plongeur"};

    private String name;
    private String firstName;
    private String currentJob;

    public ObservableList<Employes> employes;

    public ShowEmployeController() throws IOException {
    }

    private Integer index = null;


    @Override
    @FXML public void initialize(URL url, ResourceBundle resourceBundle) {

        jobCBox.getItems().addAll(jobs);

        employes = FXCollections.observableList(Main.pastaDellaMamma.getListEmployes());
        employes.addListener(new ListChangeListener<Employes>() {
            @Override
            public void onChanged(Change<? extends Employes> change) {
                System.out.println(employes);

                employeListView.getItems().clear();
                employeListView.getItems().addAll(employes);
              //  System.out.println(employes);
            }
        });
        //List<Employes> employe2 = employes;

        employeListView.getItems().addAll(employes);
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
             index = employeListView.getSelectionModel().getSelectedIndex();
            System.out.println(employes.get(index).getHours());
        });

        changeSceneBtn.setOnAction(e ->{
            if (index != null){
                int row = index;
                employeListView.getItems().remove(row);
                index = null;
            }
        });


        submitBtn.setOnAction(e -> {
            currentJob = jobCBox.getValue();
            name = nameLbl.getText();
            firstName = firstNameLbl.getText();
            Employes employe = new Employes( name, firstName, currentJob, "0");
            employes.add(employe);
            System.out.println(employes);
            jobCBox.setValue("");
            nameLbl.setText("");
            firstNameLbl.setText("");
        });


        submitHours.setOnAction(e -> {

            String indexHours = employes.get(index).getHours();
            int intIndexHours = Integer.parseInt(indexHours);
            int addHours = Integer.parseInt(addHoursTxtField.getText());
            int removeHours = Integer.parseInt(removeHoursTxtField.getText());



            if (index != null && addHours != 0 && removeHours == 0){
                int result = addHours + intIndexHours;
                String stringResult = String.valueOf(result);
                List<Employes> test = employes.stream().filter(x -> x == employes.get(index)).collect(Collectors.toList());
                test.get(0).setHours(stringResult);
                List<Employes> saveList = new ArrayList<>(employes);
                employes.clear();
                employes.addAll(saveList);
                addHoursTxtField.setText("0");


            } else if (index != null && removeHours != 0 && addHours == 0) {
                int result = intIndexHours - removeHours;
                String stringResult = String.valueOf(result);
                List<Employes> test = employes.stream().filter(x -> x == employes.get(index)).collect(Collectors.toList());
                test.get(0).setHours(stringResult);
                List<Employes> saveList = new ArrayList<>(employes);
                employes.clear();
                employes.addAll(saveList);
                removeHoursTxtField.setText("0");

            } else if (index != null && removeHours != 0 && addHours != 0) {
                int result = intIndexHours + addHours - removeHours;
                String stringResult = String.valueOf(result);
                List<Employes> test = employes.stream().filter(x -> x == employes.get(index)).collect(Collectors.toList());
                test.get(0).setHours(stringResult);
                List<Employes> saveList = new ArrayList<>(employes);
                employes.clear();
                employes.addAll(saveList);
                removeHoursTxtField.setText("0");
            } else {
                System.out.println("error");
            }
        });

    }



}
