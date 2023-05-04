package fr.coding.pastadellamamma;

import fr.coding.pastadellamamma.model.Employes;
import fr.coding.pastadellamamma.model.Restaurant;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        instantiateEmploye();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("amployeList.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 480);
        stage.setTitle("Pasta della Mama");
        stage.setScene(scene);
        stage.show();



    }

    public static Restaurant pastaDellaMamma;
public  void instantiateEmploye(){
    pastaDellaMamma = new Restaurant();
    Employes eployer1 = new Employes("louis", "edward", "serveur", "0");
    Employes eployer2 = new Employes("pierre", "edward", "serveur", "0");
    pastaDellaMamma.addEmployes(eployer1);
    pastaDellaMamma.addEmployes(eployer2);
}

    public static void main(String[] args) {
        launch();
    }
}
