package fr.coding.pastadellamamma.controller;

import fr.coding.pastadellamamma.model.Chrono;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ChronoController {
    @FXML
    private Label timerLabel;

    @FXML
    private Button startServiceButton;

    @FXML
    public void initialize() {
        timerLabel.setText(Chrono.getTime());

        if (Chrono.isRunning) {
            Chrono.setTimerLabel(timerLabel);
            startServiceButton.setDisable(true);
        }
    }

    @FXML
    public void onStartServiceButtonClicked() {
        startServiceButton.setDisable(true);
        Chrono chrono = new Chrono(timerLabel, startServiceButton);
        chrono.start();
    }
}
