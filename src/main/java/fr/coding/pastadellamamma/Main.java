package fr.coding.pastadellamamma;

import fr.coding.pastadellamamma.model.Restaurant;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 480);
        stage.setTitle("Pasta della Mama");
        stage.setScene(scene);
        stage.show();


    }

    public static Restaurant pastaDellaMamma = new Restaurant();


    public static void main(String[] args) {
        launch();
    }
}
