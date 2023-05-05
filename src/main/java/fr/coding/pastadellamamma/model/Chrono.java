package fr.coding.pastadellamamma.model;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Timer;

public class Chrono extends Thread {

    private static final int SERVICE_DURATION_SECONDS = 25 * 60;
    private static int remainingTime = SERVICE_DURATION_SECONDS;
    private static Timer timer;
    private static Label timerLabel;
    private static Button startServiceButton;
    public static boolean isRunning;

    public static boolean endOrder = false;

    public static void stopService() {
        isRunning = false;
        timer.cancel();
        timer = null;
        remainingTime = SERVICE_DURATION_SECONDS;
        timerLabel.setText(getTime());
        startServiceButton.setDisable(false);
    }

    public static String getTime() {
        int minutes = remainingTime / 60;
        int remainingSeconds = remainingTime % 60;
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }

    public static void setTimerLabel(Label label) {
        timerLabel = label;
    }

    public void run() {
        isRunning = true;

        try {
            for (;;) {
                System.out.println(remainingTime);
                Platform.runLater(() -> timerLabel.setText(getTime()));

                Thread.sleep(1000);
                remainingTime--;

                if (remainingTime <= 0) {
                    stopService();
                }

                if (remainingTime <= 900) {
                   endOrder = true;
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Chrono(Label label, Button startButton) {
        timerLabel = label;
        startServiceButton = startButton;
    }
}